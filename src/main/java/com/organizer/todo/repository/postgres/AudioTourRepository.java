package com.audiotour.repository.postgres;

import com.audiotour.model.postgres.AudioTour;
import com.audiotour.model.postgres.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AudioTourRepository extends JpaRepository<AudioTour, UUID> {
    List<AudioTour> findAllByInstitution(Institution institution);
}

