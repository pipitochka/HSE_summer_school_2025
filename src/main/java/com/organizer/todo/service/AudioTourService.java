package com.organizer.todo.service;

import com.audiotour.dto.*;
import com.organizer.todo.exception.ConflictException;
import com.organizer.todo.exception.ResourceNotFoundException;
import com.organizer.todo.model.postgres.AudioTour;
import com.organizer.todo.model.postgres.Institution;
import com.organizer.todo.repository.postgres.AudioTourRepository;
import com.organizer.todo.repository.postgres.InstitutionRepository;
import com.organizer.todo.repository.postgres.TagRepository;
import io.minio.MinioClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AudioTourService {

    private final AudioTourRepository audioTourRepository;
    private final InstitutionRepository institutionRepository;
    private final TagRepository tagRepository;
    private final DtoMapper dtoMapper;
    private final MinioClient minioClient;


    public List<AudioTourDto> listToursByInstitution(UUID institutionId) {
        Institution institution = institutionRepository.findById(institutionId)
                .orElseThrow(() -> new ResourceNotFoundException("Institution not found: " + institutionId));

        return audioTourRepository.findAllByInstitution(institution).stream()
                .map(dtoMapper::toAudioTourDto)
                .toList();
    }

    @Transactional
    public AudioTourDto createTour(AudioTourCreate create) {
        Institution institution = institutionRepository.findById(create.getInstitutionId())
                .orElseThrow(() -> new ResourceNotFoundException("Institution not found: " + create.getInstitutionId()));

        if (create.getAudioUrl() == null) {
            throw new ResourceNotFoundException("AudioUrl not found: url");
        }

        if (create.getTags() != null) {
            for (var el : create.getTags()) {
                if (!tagRepository.existsById(el)) {
                    throw new ResourceNotFoundException("Tag not found: " + el);
                }
            }
        }

        AudioTour tour = AudioTour.builder()
                .id(UUID.randomUUID())
                .title(create.getTitle())
                .description(create.getDescription().orElse(null))
                .audioUrl(String.valueOf(create.getAudioUrl()))
                .institution(institution)
                .available("false")
                .build();

        if (create.getTags() != null) {
            for (var el : create.getTags()) {
                var tag = tagRepository.findById(el);
                if (tag.isPresent()) {
                    tour.getTags().add(tag.get());
                } else {
                    throw new ResourceNotFoundException("Tag not found: " + el);
                }
            }
        }

        return dtoMapper.toAudioTourDto(audioTourRepository.save(tour));
    }

    public AudioTourDto updateTour(UUID id, AudioTourUpdate update) {
        AudioTour tour = audioTourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AudioTour not found: " + id));

        tour.setTitle(update.getTitle());
        tour.setDescription(update.getDescription());

        return dtoMapper.toAudioTourDto(audioTourRepository.save(tour));
    }

    @Transactional
    public void deleteTour(UUID institutionId, UUID tourId) {
        var institution = institutionRepository.findById(institutionId);
        if (institution.isEmpty()){
            throw new ResourceNotFoundException("Institution not found: " + institutionId);
        }
        var audioTour = audioTourRepository.findById(tourId);
        if (audioTour.isEmpty()){
            throw new ResourceNotFoundException("AudioTour not found: " + tourId);
        }
        if (audioTour.get().getInstitution().getId() != institution.get().getId()){
            throw new ConflictException("AudioTour already has another institution");
        }

        audioTourRepository.deleteById(audioTour.get().getId());
    }

    public AudioTourDto findTourById(UUID institutionId, UUID tourId) {
        var institution = institutionRepository.findById(institutionId);
        if (institution.isEmpty()){
            throw new ResourceNotFoundException("Institution not found: " + institutionId);
        }

        var audioTour = audioTourRepository.findById(tourId);
        if (audioTour.isEmpty()){
            throw new ResourceNotFoundException("AudioTour not found: " + tourId);
        }

        if (audioTour.get().getInstitution().getId() != institution.get().getId()){
            throw new ConflictException("AudioTour already has another institution");
        }

        return dtoMapper.toAudioTourDto(audioTour.get());
    }

    public PaginatedAudioTours listAudiTours(Pageable pageable, UUID institutionId) {
        return dtoMapper.toPaginatedAudioTours(audioTourRepository
                .findAllByInstitutionId(institutionId, pageable)
                .map(dtoMapper::toAudioTourDto));
    }
}

