package com.organizer.todo.repository.postgres;


import com.organizer.todo.model.postgres.AudioTour;
import com.organizer.todo.model.postgres.Institution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AudioTourRepository extends JpaRepository<AudioTour, UUID> {
    List<AudioTour> findAllByInstitution(Institution institution);
    Page<AudioTour> findAllByInstitution_Id(UUID institutionId, Pageable pageable);

}

