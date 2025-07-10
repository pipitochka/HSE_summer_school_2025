package com.audiotour.repository.postgres;

import com.audiotour.model.postgres.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, UUID> {
    // Добавьте методы фильтрации по владельцу, если будет user_id
}

