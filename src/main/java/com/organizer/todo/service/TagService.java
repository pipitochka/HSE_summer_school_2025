package com.organizer.todo.service;

import com.audiotour.dto.TagDto;
import com.organizer.todo.exception.ConflictException;
import com.organizer.todo.model.postgres.MyTag;
import com.organizer.todo.repository.postgres.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final DtoMapper dtoMapper;

    public List<TagDto> listTags() {
        return tagRepository.findAll().stream()
                .map(dtoMapper::toTagDto)
                .toList();
    }

    public TagDto createTag(String name) {
        tagRepository.findByName(name).ifPresent(tag -> {
            throw new ConflictException("Tag already exists: " + name);
        });

        MyTag tag = MyTag.builder()
                .id(UUID.randomUUID())
                .name(name)
                .build();

        return dtoMapper.toTagDto(tagRepository.save(tag));
    }

    public void deleteTag(UUID id) {
        tagRepository.deleteById(id);
    }
}

