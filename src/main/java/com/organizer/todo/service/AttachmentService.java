package com.organizer.todo.service;

import com.audiotour.dto.AttachmentMetadata;
import com.organizer.todo.exception.ResourceNotFoundException;
import com.organizer.todo.model.postgres.Attachment;
import com.organizer.todo.model.postgres.AudioTour;
import com.organizer.todo.repository.postgres.AttachmentRepository;
import com.organizer.todo.repository.postgres.AudioTourRepository;
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
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttachmentService {

    private final MinioClient minioClient;
    private final AttachmentRepository attachmentRepository;
    private final AudioTourRepository audioTourRepository;
    private final DtoMapper dtoMapper;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Transactional
    public AttachmentMetadata uploadAttachment(UUID tourId, MultipartFile file) {
        AudioTour audioTour = audioTourRepository.findById(tourId)
                .orElseThrow(() -> new ResourceNotFoundException("AudioTour not found: " + tourId));

        try {
            String s3Key = UUID.randomUUID() + "-" + file.getOriginalFilename();

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(s3Key)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );

            Attachment attachment = Attachment.builder()
                    .id(UUID.randomUUID())
                    .audioTour(audioTour)
                    .filename(file.getOriginalFilename())
                    .s3Key(s3Key)
                    .sizeBytes(file.getSize())
                    .uploadedAt(OffsetDateTime.now())
                    .build();

            return dtoMapper.toAttachmentMetadataDto(attachmentRepository.save(attachment));

        } catch (Exception e) {
            log.error("Failed to upload attachment", e);
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    public record DownloadedFile(InputStreamResource resource, String filename) {}

    public DownloadedFile downloadAttachment(UUID attachmentId) {
        Attachment attachment = attachmentRepository.findById(attachmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Attachment not found: " + attachmentId));

        try {
            InputStream stream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(attachment.getS3Key())
                            .build()
            );
            return new DownloadedFile(new InputStreamResource(stream), attachment.getFilename());
        } catch (Exception e) {
            log.error("Download failed", e);
            throw new RuntimeException("Download failed", e);
        }
    }

    @Transactional
    public void deleteAttachment(UUID attachmentId) {
        Attachment attachment = attachmentRepository.findById(attachmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Attachment not found: " + attachmentId));

        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName)
                            .object(attachment.getS3Key())
                            .build()
            );
            attachmentRepository.delete(attachment);
        } catch (Exception e) {
            log.error("Delete failed", e);
            throw new RuntimeException("Delete failed", e);
        }
    }
}

