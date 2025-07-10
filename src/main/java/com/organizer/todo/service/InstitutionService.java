package com.organizer.todo.service;

import com.audiotour.dto.InstitutionDto;
import com.audiotour.dto.InstitutionCreate;
import com.audiotour.dto.InstitutionUpdate;
import com.organizer.todo.exception.ResourceNotFoundException;
import com.organizer.todo.model.postgres.Institution;
import com.organizer.todo.repository.postgres.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;
    private final DtoMapper dtoMapper;

    public List<InstitutionDto> listInstitutions() {
        return institutionRepository.findAll().stream()
                .map(dtoMapper::toInstitutionDto)
                .toList();
    }

    public InstitutionDto createInstitution(InstitutionCreate create) {
        Institution institution = Institution.builder()
                .id(UUID.randomUUID())
                .name(create.getName())
                .description(create.getDescription().orElse(null))
                .build();

        return dtoMapper.toInstitutionDto(institutionRepository.save(institution));
    }

    @Transactional
    public InstitutionDto updateInstitution(UUID id, InstitutionUpdate update) {
        Institution institution = institutionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institution not found: " + id));

        institution.setName(update.getName().orElse(null));
        institution.setDescription(update.getDescription().orElse(null));

        return dtoMapper.toInstitutionDto(institutionRepository.save(institution));
    }

    public void deleteInstitution(UUID id) {
        institutionRepository.deleteById(id);
    }

    public InstitutionDto getInstitutionById(UUID institutionId) {
        return (InstitutionDto) institutionRepository.findAllById(Collections.singleton(institutionId));
    }
}

