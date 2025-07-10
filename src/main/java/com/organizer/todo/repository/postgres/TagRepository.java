package com.organizer.todo.repository.postgres;


import com.organizer.todo.model.postgres.MyTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<MyTag, UUID> {
    Optional<MyTag> findByName(String name);
}

