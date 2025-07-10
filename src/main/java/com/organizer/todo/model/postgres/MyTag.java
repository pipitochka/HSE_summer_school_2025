package com.organizer.todo.model.postgres;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tags")
public class MyTag {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<AudioTour> audioTours;
}

