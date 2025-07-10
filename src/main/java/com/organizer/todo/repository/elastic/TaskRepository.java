package com.organizer.todo.repository.elastic;

import com.organizer.todo.model.elastic.TaskDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends ElasticsearchRepository<TaskDocument, String> {
    boolean existsByCategoryId(UUID categoryId);
}