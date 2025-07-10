package com.organizer.todo.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AudioTourCreate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T12:39:26.405200+03:00[Europe/Moscow]")
public class AudioTourCreate {

  private String title;

  private JsonNullable<String> description = JsonNullable.undefined();

  private UUID institutionId;

  private URI audioUrl;

  @Valid
  private List<UUID> tags;

  /**
   * Default constructor
   * @deprecated Use {@link AudioTourCreate#AudioTourCreate(String, URI)}
   */
  @Deprecated
  public AudioTourCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AudioTourCreate(String title, URI audioUrl) {
    this.title = title;
    this.audioUrl = audioUrl;
  }

  public AudioTourCreate title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @NotNull 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public AudioTourCreate description(String description) {
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

  public AudioTourCreate institutionId(UUID institutionId) {
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

  public AudioTourCreate audioUrl(URI audioUrl) {
    this.audioUrl = audioUrl;
    return this;
  }

  /**
   * Get audioUrl
   * @return audioUrl
  */
  @NotNull @Valid 
  @Schema(name = "audio_url", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("audio_url")
  public URI getAudioUrl() {
    return audioUrl;
  }

  public void setAudioUrl(URI audioUrl) {
    this.audioUrl = audioUrl;
  }

  public AudioTourCreate tags(List<UUID> tags) {
    this.tags = tags;
    return this;
  }

  public AudioTourCreate addTagsItem(UUID tagsItem) {
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
  public List<UUID> getTags() {
    return tags;
  }

  public void setTags(List<UUID> tags) {
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
    AudioTourCreate audioTourCreate = (AudioTourCreate) o;
    return Objects.equals(this.title, audioTourCreate.title) &&
        equalsNullable(this.description, audioTourCreate.description) &&
        Objects.equals(this.institutionId, audioTourCreate.institutionId) &&
        Objects.equals(this.audioUrl, audioTourCreate.audioUrl) &&
        Objects.equals(this.tags, audioTourCreate.tags);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, hashCodeNullable(description), institutionId, audioUrl, tags);
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
    sb.append("class AudioTourCreate {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
    sb.append("    audioUrl: ").append(toIndentedString(audioUrl)).append("\n");
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

