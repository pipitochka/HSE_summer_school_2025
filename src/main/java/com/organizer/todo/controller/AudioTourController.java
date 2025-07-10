package com.audiotour.controller;

import com.audiotour.api.AudioToursApi;
import com.audiotour.dto.*;
import com.audiotour.service.AudioTourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AudioTourController implements AudioToursApi {

    private final AudioTourService audioTourService;

    @Override
    public ResponseEntity<AudioTour> createAudioTour(UUID institutionId, AudioTourCreate audioTourCreate) {
        AudioTour created = audioTourService.createAudioTour(institutionId, audioTourCreate);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PaginatedAudioTours> listAudioTours(UUID institutionId, Integer page, Integer size) {
        PaginatedAudioTours result = audioTourService.listAudioTours(institutionId, page, size);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<AudioTourDetails> getAudioTourById(UUID institutionId, UUID tourId) {
        AudioTourDetails details = audioTourService.getAudioTourDetails(institutionId, tourId);
        return ResponseEntity.ok(details);
    }

    @Override
    public ResponseEntity<AudioTour> updateAudioTour(UUID institutionId, UUID tourId, AudioTourUpdate audioTourUpdate) {
        AudioTour updated = audioTourService.updateAudioTour(institutionId, tourId, audioTourUpdate);
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> deleteAudioTour(UUID institutionId, UUID tourId) {
        audioTourService.deleteAudioTour(institutionId, tourId);
        return ResponseEntity.noContent().build();
    }
}

