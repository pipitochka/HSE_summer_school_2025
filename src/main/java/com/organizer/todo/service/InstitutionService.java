package com.audiotour.service;

import com.audiotour.dto.InstitutionDto;
import com.audiotour.dto.InstitutionCreate;
import com.audiotour.dto.InstitutionUpdate;
import com.audiotour.exception.ResourceNotFoundException;
import com.audiotour.model.postgres.Institution;
import com.audiotour.repository.postgres.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .description(create.getDescription())
                .build();

        return dtoMapper.toInstitutionDto(institutionRepository.save(institution));
    }

    @Transactional
    public InstitutionDto updateInstitution(UUID id, InstitutionUpdate update) {
        Institution institution = institutionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institution not found: " + id));

        institution.setName(update.getName());
        institution.setDescription(update.getDescription());

        return dtoMapper.toInstitutionDto(institutionRepository.save(institution));
    }

    public void deleteInstitution(UUID id) {
        institutionRepository.deleteById(id);
    }
}

