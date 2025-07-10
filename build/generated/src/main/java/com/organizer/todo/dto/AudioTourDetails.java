package com.organizer.todo.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.organizer.todo.dto.Institution;
import com.organizer.todo.dto.TagDto;
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
 * AudioTourDetails
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T12:39:26.405200+03:00[Europe/Moscow]")
public class AudioTourDetails {

  private UUID id;

  private String title;

  private String institutionName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  private JsonNullable<String> description = JsonNullable.undefined();

  private URI audioUrl;

  private UUID institutionId;

  private Institution institution;

  @Valid
  private List<@Valid TagDto> tags;

  public AudioTourDetails id(UUID id) {
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

  public AudioTourDetails title(String title) {
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

  public AudioTourDetails institutionName(String institutionName) {
    this.institutionName = institutionName;
    return this;
  }

  /**
   * Get institutionName
   * @return institutionName
  */
  
  @Schema(name = "institution_name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("institution_name")
  public String getInstitutionName() {
    return institutionName;
  }

  public void setInstitutionName(String institutionName) {
    this.institutionName = institutionName;
  }

  public AudioTourDetails createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  */
  @Valid 
  @Schema(name = "created_at", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public AudioTourDetails description(String description) {
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

  public AudioTourDetails audioUrl(URI audioUrl) {
    this.audioUrl = audioUrl;
    return this;
  }

  /**
   * Get audioUrl
   * @return audioUrl
  */
  @Valid 
  @Schema(name = "audio_url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("audio_url")
  public URI getAudioUrl() {
    return audioUrl;
  }

  public void setAudioUrl(URI audioUrl) {
    this.audioUrl = audioUrl;
  }

  public AudioTourDetails institutionId(UUID institutionId) {
    this.institutionId = institutionId;
    return this;
  }

  /**
   * Get institutionId
   * @return institutionId
  */
  @Valid 
  @Schema(name = "institution_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("institution_id")
  public UUID getInstitutionId() {
    return institutionId;
  }

  public void setInstitutionId(UUID institutionId) {
    this.institutionId = institutionId;
  }

  public AudioTourDetails institution(Institution institution) {
    this.institution = institution;
    return this;
  }

  /**
   * Get institution
   * @return institution
  */
  @Valid 
  @Schema(name = "institution", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("institution")
  public Institution getInstitution() {
    return institution;
  }

  public void setInstitution(Institution institution) {
    this.institution = institution;
  }

  public AudioTourDetails tags(List<@Valid TagDto> tags) {
    this.tags = tags;
    return this;
  }

  public AudioTourDetails addTagsItem(TagDto tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
  */
  @Valid 
  @Schema(name = "tags", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tags")
  public List<@Valid TagDto> getTags() {
    return tags;
  }

  public void setTags(List<@Valid TagDto> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AudioTourDetails audioTourDetails = (AudioTourDetails) o;
    return Objects.equals(this.id, audioTourDetails.id) &&
        Objects.equals(this.title, audioTourDetails.title) &&
        Objects.equals(this.institutionName, audioTourDetails.institutionName) &&
        Objects.equals(this.createdAt, audioTourDetails.createdAt) &&
        equalsNullable(this.description, audioTourDetails.description) &&
        Objects.equals(this.audioUrl, audioTourDetails.audioUrl) &&
        Objects.equals(this.institutionId, audioTourDetails.institutionId) &&
        Objects.equals(this.institution, audioTourDetails.institution) &&
        Objects.equals(this.tags, audioTourDetails.tags);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, institutionName, createdAt, hashCodeNullable(description), audioUrl, institutionId, institution, tags);
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
    sb.append("class AudioTourDetails {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    institutionName: ").append(toIndentedString(institutionName)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    audioUrl: ").append(toIndentedString(audioUrl)).append("\n");
    sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
    sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

