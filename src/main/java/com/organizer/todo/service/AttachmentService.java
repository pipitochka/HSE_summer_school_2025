package com.organizer.todo.service;

import com.audiotour.dto.AudioTourDto;
import com.organizer.todo.exception.ConflictException;
import com.organizer.todo.exception.ResourceNotFoundException;
import com.organizer.todo.model.postgres.AudioTour;
import com.organizer.todo.repository.postgres.AudioTourRepository;
import com.organizer.todo.repository.postgres.InstitutionRepository;
import com.organizer.todo.repository.postgres.TagRepository;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttachmentService {

    private final MinioClient minioClient;
    private final AudioTourRepository audioTourRepository;
    private final InstitutionRepository institutionRepository;
    private final TagRepository tagRepository;
    private final DtoMapper dtoMapper;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Transactional
    public AudioTourDto uploadAttachment(UUID institutionId, MultipartFile file, String title,
                                          String description, List<UUID> tags) {
        try {

            var institution = institutionRepository.findById(institutionId);
            if (!institution.isPresent()) {
                throw new ResourceNotFoundException("Institution not found" + institutionId);
            }

            if (tags != null && !tags.isEmpty()) {
                for (var tag : tags) {
                    if (!tagRepository.existsById(tag)) {
                        throw new ResourceNotFoundException("Tag not found" + tag);
                    }
                }
            }

            AudioTour audioTour = AudioTour.builder()
                    .id(UUID.randomUUID())
                    .title(title)
                    .description(description)
                    .institution(institution.get())
                    .available("true")
                    .build();

            if (tags != null && !tags.isEmpty()) {
                for (var tag : tags) {
                    var nice = tagRepository.findById(tag);
                    if (nice.isPresent()) {
                        audioTour.getTags().add(nice.get());
                    }
                }
            }

            String s3Key = audioTour.getId() + "-" + audioTour.getTitle();

            if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
                throw new ConflictException("Bucket does not exist");
            }

            try {
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(s3Key)
                                .stream(file.getInputStream(), file.getSize(), -1)
                                .contentType(file.getContentType())
                                .build()
                );

            } catch (Exception e) {
                throw new ConflictException(e.getMessage());
            }

            return dtoMapper.toAudioTourDto(audioTourRepository.save(audioTour));

        } catch (Exception e) {
            log.error("Failed to upload attachment", e);
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    public record DownloadedFile(InputStreamResource resource, String filename) {}

    public DownloadedFile downloadAttachment(UUID institutionId, UUID tourId) {
        AudioTour audioTour = audioTourRepository.findById(tourId)
                .orElseThrow(() -> new ResourceNotFoundException("Attachment not found: " + tourId));

        if (!audioTour.getInstitution().getId().equals(institutionId)) {
            throw new ConflictException("Institution id mismatch");
        }
        if (audioTour.getAvailable() == "false"){
            throw new ConflictException("AudioTour id is not available");
        }

        String s3Key = audioTour.getId() + "-" + audioTour.getTitle();

        try {
            InputStream stream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(s3Key)
                            .build()
            );
            return new DownloadedFile(new InputStreamResource(stream), audioTour.getTitle());
        } catch (Exception e) {
            log.error("Download failed", e);
            throw new RuntimeException("Download failed", e);
        }
    }
}

