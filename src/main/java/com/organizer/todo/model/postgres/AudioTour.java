package com.organizer.todo.model.postgres;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "audio_tours")
public class AudioTour {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "audio_url", nullable = false)
    private String audioUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id", nullable = false)
    private Institution institution;

    @ManyToMany
    @JoinTable(
        name = "audio_tour_tags",
        joinColumns = @JoinColumn(name = "audio_tour_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<MyTag> tags;

    @Column(name = "is_available")
    String available;
}

