package com.organizer.todo.model.postgres;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attachments")
public class Attachment {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audio_tour_id", nullable = false)
    private AudioTour audioTour;

    @Column(nullable = false)
    private String filename;

    @Column(name = "s3_key", nullable = false, unique = true)
    private String s3Key;

    @Column(name = "size_bytes", nullable = false)
    private Long sizeBytes;

    @Column(name = "uploaded_at", nullable = false)
    private OffsetDateTime uploadedAt;
}

