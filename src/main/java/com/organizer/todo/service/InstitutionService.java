package com.organizer.todo.service;

import com.audiotour.dto.InstitutionDto;
import com.audiotour.dto.InstitutionCreate;
import com.audiotour.dto.PaginatedInstitutions;
import com.organizer.todo.exception.ConflictException;
import com.organizer.todo.exception.ResourceNotFoundException;
import com.organizer.todo.model.postgres.Institution;
import com.organizer.todo.repository.postgres.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstitutionService {

    private final InstitutionRepository institutionRepository;
    private final DtoMapper dtoMapper;

    public PaginatedInstitutions listInstitutions(Pageable pageable) {
        return dtoMapper.toPaginatedInstitutions(institutionRepository.findAll(pageable)
                .map(dtoMapper::toInstitutionDto));
    }

    public InstitutionDto createInstitution(InstitutionCreate create) {
        if (institutionRepository.existsByName(create.getName())) {
            throw new ConflictException("Institution with name " + create.getName() + " already exists");
        }
        Institution institution = Institution.builder()
                .id(UUID.randomUUID())
                .name(create.getName())
                .description(create.getDescription().orElse(null))
                .build();

        return dtoMapper.toInstitutionDto(institutionRepository.save(institution));
    }

    public void deleteInstitution(UUID id) {
        institutionRepository.deleteById(id);
    }

    public InstitutionDto getInstitutionById(UUID id) {
        var entity = institutionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institution not found: " + id));
        return dtoMapper.toInstitutionDto(entity);
    }
}
