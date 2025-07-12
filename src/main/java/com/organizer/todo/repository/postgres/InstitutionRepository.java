package com.organizer.todo.repository.postgres;


import com.organizer.todo.model.postgres.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, UUID> {

    boolean existsByName(String name);

    boolean existsById(UUID uuid);
}

