package com.audiotour.repository.postgres;

import com.audiotour.model.postgres.Attachment;
import com.audiotour.model.postgres.AudioTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    List<Attachment> findAllByAudioTour(AudioTour audioTour);
    void deleteAllByAudioTour(AudioTour audioTour);
}

