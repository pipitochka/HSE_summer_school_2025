package com.organizer.todo.controller;


import com.audiotour.api.InstitutionsApi;
import com.audiotour.dto.*;
import com.organizer.todo.exception.ConflictException;
import com.organizer.todo.exception.ResourceNotFoundException;
import com.organizer.todo.service.AudioTourService;
import com.organizer.todo.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class InstitutionsController implements InstitutionsApi {

    private final InstitutionService institutionService;

    private final AudioTourService audioTourService;

    /**
     * POST /institutions/{institution_id}/audio-tours : Создать новую аудиоэкскурсию для учреждения
     * Создает новую аудиоэкскурсию, которая будет принадлежать указанному учреждению.
     *
     * @param institutionId   (required)
     * @param audioTourCreate (required)
     * @return Экскурсия успешно создана. (status code 201)
     * or Доступ запрещен. (status code 403)
     */
    @Override
    public ResponseEntity<AudioTourDto> createAudioTourForInstitution(UUID institutionId, AudioTourCreate audioTourCreate) {
        try {
            AudioTourDto created = audioTourService.createTour(audioTourCreate);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (ConflictException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (ResourceNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST /institutions : Создать новое учреждение
     * Администратор платформы создает новое учреждение.
     *
     * @param institutionCreate (required)
     * @return Учреждение успешно создано. (status code 201)
     * or Доступ запрещен. (status code 403)
     */
    @Override
    public ResponseEntity<InstitutionDto> createInstitution(InstitutionCreate institutionCreate) {
        try {
            InstitutionDto created = institutionService.createInstitution(institutionCreate);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (ConflictException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @Override
    public ResponseEntity<PaginatedInstitutions> listInstitutions(Integer page, Integer size) {
        PaginatedInstitutions result = institutionService.listInstitutions(Pageable.ofSize(size).withPage(page));
        return ResponseEntity.ok(result);
    }

    /**
     * POST /institutions/{institute_id}/upload : Загрузить файл
     * Загружает аудиофайл с метаданными (название, описание, ID учреждения и теги).
     *
     * @param institutionId  (required)
     * @param file           (required)
     * @param title          (required)
     * @param institutionId2 (required)
     * @param description    (optional)
     * @param tags           (optional)
     * @return Файл успешно загружен. (status code 200)
     * or Неверный формат запроса. (status code 400)
     * or Требуется аутентификация. (status code 401)
     */
    @Override
    public ResponseEntity<Void> uploadAudio(UUID institutionId, MultipartFile file, String title, UUID institutionId2, String description, List<UUID> tags) {
        return null;
    }


    @Override
    public ResponseEntity<InstitutionDto> getInstitutionById(UUID institutionId) {
        try {
            InstitutionDto institution = institutionService.getInstitutionById(institutionId);
            return ResponseEntity.ok(institution);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GET /institutions/{institution_id}/audio-tours/{tour_id} : Получить детальную информацию об аудиоэкскурсии
     * Возвращает полную информацию о конкретной аудиоэкскурсии.
     *
     * @param institutionId (required)
     * @param tourId        (required)
     * @return Детальная информация об экскурсии. (status code 200)
     * or Учреждение или экскурсия не найдены. (status code 404)
     */
    @Override
    public ResponseEntity<AudioTourDto> getNestedAudioTourById(UUID institutionId, UUID tourId) {
        try{
            return ResponseEntity.ok(audioTourService.findTourById(institutionId, tourId));
        } catch (ConflictException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * GET /institutions/{institution_id}/audio-tours : Получить список экскурсий учреждения
     * Возвращает список всех аудиоэкскурсий, созданных указанным учреждением.
     *
     * @param institutionId (required)
     * @param page          Номер страницы (начиная с 1). (optional, default to 1)
     * @param size          Количество элементов на странице. (optional, default to 20)
     * @return Список экскурсий учреждения. (status code 200)
     * or Учреждение не найдено. (status code 404)
     */
    @Override
    public ResponseEntity<PaginatedAudioTours> listInstitutionTours(UUID institutionId, Integer page, Integer size) {
        PaginatedAudioTours result = audioTourService.listAudiTours(Pageable.ofSize(size).withPage(page), institutionId);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Void> deleteInstitution(UUID institutionId) {
        institutionService.deleteInstitution(institutionId);
        return ResponseEntity.noContent().build();
    }

    /**
     * DELETE /institutions/{institution_id}/audio-tours/{tour_id} : Удалить аудиоэкскурсию
     * Администратор учреждения удаляет свою экскурсию.
     *
     * @param institutionId (required)
     * @param tourId        (required)
     * @return Экскурсия успешно удалена. (status code 204)
     * or Доступ запрещен. (status code 403)
     */
    @Override
    public ResponseEntity<Void> deleteNestedAudioTour(UUID institutionId, UUID tourId) {
        try {
            audioTourService.deleteTour(institutionId, tourId);
            return ResponseEntity.noContent().build();
        } catch (ConflictException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * GET /institutions/{institute_id}/download/{id} : Скачать файл
     * Загружает аудиофайл по идентификатору.
     *
     * @param institutionId (required)
     * @return Успешная загрузка файла. (status code 200)
     * or Файл не найден. (status code 404)
     * or Требуется аутентификация. (status code 401)
     */
    @Override
    public ResponseEntity<Resource> downloadAudio(UUID institutionId) {
        return null;
    }


}

