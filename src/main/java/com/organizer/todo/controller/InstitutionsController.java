package com.organizer.todo.controller;


import com.audiotour.api.InstitutionsApi;
import com.audiotour.dto.*;
import com.organizer.todo.service.AudioTourService;
import com.organizer.todo.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
        AudioTourDto created = audioTourService.createTour(audioTourCreate);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
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
        InstitutionDto created = institutionService.createInstitution(institutionCreate);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<PaginatedInstitutions> listInstitutions(Integer page, Integer size) {
        PaginatedInstitutions result = (PaginatedInstitutions) institutionService.listInstitutions();
        return ResponseEntity.ok(result);
    }

    /**
     * PATCH /institutions/{institution_id}/audio-tours/{tour_id} : Обновить аудиоэкскурсию
     * Администратор учреждения обновляет данные своей экскурсии.
     *
     * @param institutionId   (required)
     * @param tourId          (required)
     * @param audioTourUpdate (required)
     * @return Экскурсия успешно обновлена. (status code 200)
     * or Доступ запрещен. (status code 403)
     */
    @Override
    public ResponseEntity<AudioTourDto> updateNestedAudioTour(UUID institutionId, UUID tourId, AudioTourUpdate audioTourUpdate) {
        return null;
    }


    @Override
    public ResponseEntity<InstitutionDto> getInstitutionById(UUID institutionId) {
        InstitutionDto institution = institutionService.getInstitutionById(institutionId);
        return ResponseEntity.ok(institution);
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
    public ResponseEntity<AudioTourDetails> getNestedAudioTourById(UUID institutionId, UUID tourId) {
        return null;
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
        return null;
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
        return null;
    }


}

