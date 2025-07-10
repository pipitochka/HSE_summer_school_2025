package com.audiotour.controller;

import com.audiotour.api.InstitutionsApi;
import com.audiotour.dto.*;
import com.audiotour.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class InstitutionsController implements InstitutionsApi {

    private final InstitutionService institutionService;

    @Override
    public ResponseEntity<Institution> createInstitution(InstitutionCreate institutionCreate) {
        Institution created = institutionService.createInstitution(institutionCreate);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PaginatedInstitutions> listInstitutions(Integer page, Integer size) {
        PaginatedInstitutions result = institutionService.listInstitutions(page, size);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Institution> getInstitutionById(UUID institutionId) {
        Institution institution = institutionService.getInstitutionById(institutionId);
        return ResponseEntity.ok(institution);
    }

    @Override
    public ResponseEntity<Void> deleteInstitution(UUID institutionId) {
        institutionService.deleteInstitution(institutionId);
        return ResponseEntity.noContent().build();
    }
}

