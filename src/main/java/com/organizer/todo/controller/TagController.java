package com.audiotour.controller;

import com.audiotour.api.TagsApi;
import com.audiotour.dto.*;
import com.audiotour.service.TagService;
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
    public ResponseEntity<Tag> createTag(TagCreate tagCreate) {
        Tag created = tagService.createTag(tagCreate);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ListTags200Response> listTags() {
        List<Tag> tags = tagService.listTags();
        return ResponseEntity.ok(new ListTags200Response().items(tags));
    }

    @Override
    public ResponseEntity<Void> deleteTag(UUID tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.noContent().build();
    }
}

