package com.audiotour.service;

import com.audiotour.dto.AudioTourDto;
import com.audiotour.dto.AudioTourCreate;
import com.audiotour.dto.AudioTourUpdate;
import com.audiotour.exception.ResourceNotFoundException;
import com.audiotour.model.postgres.AudioTour;
import com.audiotour.model.postgres.Institution;
import com.audiotour.repository.postgres.AudioTourRepository;
import com.audiotour.repository.postgres.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AudioTourService {

    private final AudioTourRepository audioTourRepository;
    private final InstitutionRepository institutionRepository;
    private final DtoMapper dtoMapper;

    public List<AudioTourDto> listToursByInstitution(UUID institutionId) {
        Institution institution = institutionRepository.findById(institutionId)
                .orElseThrow(() -> new ResourceNotFoundException("Institution not found: " + institutionId));

        return audioTourRepository.findAllByInstitution(institution).stream()
                .map(dtoMapper::toAudioTourDto)
                .toList();
    }

    public AudioTourDto createTour(AudioTourCreate create) {
        Institution institution = institutionRepository.findById(create.getInstitutionId())
                .orElseThrow(() -> new ResourceNotFoundException("Institution not found: " + create.getInstitutionId()));

        AudioTour tour = AudioTour.builder()
                .id(UUID.randomUUID())
                .title(create.getTitle())
                .description(create.getDescription())
                .institution(institution)
                .build();

        return dtoMapper.toAudioTourDto(audioTourRepository.save(tour));
    }

    public AudioTourDto updateTour(UUID id, AudioTourUpdate update) {
        AudioTour tour = audioTourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AudioTour not found: " + id));

        tour.setTitle(update.getTitle());
        tour.setDescription(update.getDescription());

        return dtoMapper.toAudioTourDto(audioTourRepository.save(tour));
    }

    public void deleteTour(UUID id) {
        audioTourRepository.deleteById(id);
    }
}

