package com.organizer.todo.service;



import com.audiotour.dto.AttachmentMetadata;
import com.audiotour.dto.AudioTourDto;
import com.audiotour.dto.InstitutionDto;
import com.audiotour.dto.TagDto;
import com.organizer.todo.model.postgres.Attachment;
import com.organizer.todo.model.postgres.AudioTour;
import com.organizer.todo.model.postgres.Institution;
import com.organizer.todo.model.postgres.MyTag;
import org.springframework.stereotype.Component;

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
}

