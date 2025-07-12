package com.organizer.todo.service;


import com.audiotour.dto.*;
import com.organizer.todo.model.postgres.Attachment;
import com.organizer.todo.model.postgres.AudioTour;
import com.organizer.todo.model.postgres.Institution;
import com.organizer.todo.model.postgres.MyTag;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoMapper {

    public AttachmentMetadata toAttachmentMetadataDto(Attachment attachment) {
        return new AttachmentMetadata()
                .id(attachment.getId())
                .filename(attachment.getFilename())
                .sizeBytes(attachment.getSizeBytes())
                .uploadedAt(attachment.getUploadedAt());
    }

    public InstitutionDto toInstitutionDto(Institution institution) {
        return new InstitutionDto()
                .id(institution.getId())
                .name(institution.getName())
                .description(institution.getDescription());
    }

    public com.audiotour.dto.Institution toInstitution(Institution institution) {
        return new com.audiotour.dto.Institution()
                .id(institution.getId())
                .name(institution.getName())
                .description(institution.getDescription());
    }

    public AudioTourDto toAudioTourDto(AudioTour tour) {
        return new AudioTourDto()
                .id(tour.getId())
                .title(tour.getTitle())
                .description(tour.getDescription())
                .institutionId(tour.getInstitution().getId());
    }

    public TagDto toTagDto(MyTag tag) {
        return new TagDto()
                .id(tag.getId())
                .name(tag.getName());
    }

    public PaginatedInstitutions toPaginatedInstitutions(Page<com.audiotour.dto.InstitutionDto> list) {
        PaginatedInstitutions paginatedInstitutions = new PaginatedInstitutions();

        paginatedInstitutions.setItems(list.getContent());
        paginatedInstitutions.setPage(list.getPageable().getPageNumber());
        paginatedInstitutions.setTotalElements(list.getTotalElements());
        paginatedInstitutions.setSize(list.getPageable().getPageSize());
        paginatedInstitutions.setTotalPages(list.getTotalPages());

        return paginatedInstitutions;
    }

    public PaginatedAudioTours toPaginatedAudioTours(Page<com.audiotour.dto.AudioTourDto> list) {
        PaginatedAudioTours paginatedAudioTours = new PaginatedAudioTours();

        paginatedAudioTours.setItems(list.getContent());
        paginatedAudioTours.setPage(list.getPageable().getPageNumber());
        paginatedAudioTours.setTotalElements(list.getTotalElements());
        paginatedAudioTours.setSize(list.getPageable().getPageSize());
        paginatedAudioTours.setTotalPages(list.getTotalPages());

        return paginatedAudioTours;
    }
}

