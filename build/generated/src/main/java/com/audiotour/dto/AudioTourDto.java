package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AudioTourDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T13:08:50.398387+03:00[Europe/Moscow]")
public class AudioTourDto {

  private UUID id;

  private String title;

  private JsonNullable<String> description = JsonNullable.undefined();

  private URI audioUrl;

  private UUID institutionId;

  @Valid
  private List<UUID> tagIds;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  public AudioTourDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public AudioTourDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public AudioTourDto description(String description) {
    this.description = JsonNullable.of(description);
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public JsonNullable<String> getDescription() {
    return description;
  }

  public void setDescription(JsonNullable<String> description) {
    this.description = description;
  }

  public AudioTourDto audioUrl(URI audioUrl) {
    this.audioUrl = audioUrl;
    return this;
  }

  /**
   * Get audioUrl
   * @return audioUrl
  */
  @Valid 
  @Schema(name = "audioUrl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("audioUrl")
  public URI getAudioUrl() {
    return audioUrl;
  }

  public void setAudioUrl(URI audioUrl) {
    this.audioUrl = audioUrl;
  }

  public AudioTourDto institutionId(UUID institutionId) {
    this.institutionId = institutionId;
    return this;
  }

  /**
   * Get institutionId
   * @return institutionId
  */
  @Valid 
  @Schema(name = "institutionId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("institutionId")
  public UUID getInstitutionId() {
    return institutionId;
  }

  public void setInstitutionId(UUID institutionId) {
    this.institutionId = institutionId;
  }

  public AudioTourDto tagIds(List<UUID> tagIds) {
    this.tagIds = tagIds;
    return this;
  }

  public AudioTourDto addTagIdsItem(UUID tagIdsItem) {
    if (this.tagIds == null) {
      this.tagIds = new ArrayList<>();
    }
    this.tagIds.add(tagIdsItem);
    return this;
  }

  /**
   * Get tagIds
   * @return tagIds
  */
  @Valid 
  @Schema(name = "tagIds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tagIds")
  public List<UUID> getTagIds() {
    return tagIds;
  }

  public void setTagIds(List<UUID> tagIds) {
    this.tagIds = tagIds;
  }

  public AudioTourDto createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  */
  @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AudioTourDto audioTourDto = (AudioTourDto) o;
    return Objects.equals(this.id, audioTourDto.id) &&
        Objects.equals(this.title, audioTourDto.title) &&
        equalsNullable(this.description, audioTourDto.description) &&
        Objects.equals(this.audioUrl, audioTourDto.audioUrl) &&
        Objects.equals(this.institutionId, audioTourDto.institutionId) &&
        Objects.equals(this.tagIds, audioTourDto.tagIds) &&
        Objects.equals(this.createdAt, audioTourDto.createdAt);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, hashCodeNullable(description), audioUrl, institutionId, tagIds, createdAt);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AudioTourDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    audioUrl: ").append(toIndentedString(audioUrl)).append("\n");
    sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
    sb.append("    tagIds: ").append(toIndentedString(tagIds)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

