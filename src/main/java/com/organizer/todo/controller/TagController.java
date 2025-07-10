package com.organizer.todo.controller;

import com.audiotour.api.TagsApi;
import com.audiotour.dto.*;
import com.organizer.todo.model.postgres.MyTag;
import com.organizer.todo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TagController implements TagsApi {

    private final TagService tagService;

    @Override
    public ResponseEntity<ListTags200Response> listTags() {
        List<TagDto> tags = tagService.listTags();
        return ResponseEntity.ok(new ListTags200Response().items(tags));
    }

    /**
     * POST /tags : Создать новый тег
     *
     * @param createTagRequest (required)
     * @return Тег успешно создан. (status code 201)
     */
    @Override
    public ResponseEntity<TagDto> createTag(CreateTagRequest createTagRequest) {
        TagDto created = tagService.createTag(createTagRequest.getName());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteTag(UUID tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.noContent().build();
    }
}

