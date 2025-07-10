package com.organizer.todo.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.net.URI;
import java.util.Arrays;
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
 * AudioTourAllOf
 */

@JsonTypeName("AudioTour_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T12:39:26.405200+03:00[Europe/Moscow]")
public class AudioTourAllOf {

  private JsonNullable<String> description = JsonNullable.undefined();

  private URI audioUrl;

  private UUID institutionId;

  public AudioTourAllOf description(String description) {
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

  public AudioTourAllOf audioUrl(URI audioUrl) {
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

  public AudioTourAllOf institutionId(UUID institutionId) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AudioTourAllOf audioTourAllOf = (AudioTourAllOf) o;
    return equalsNullable(this.description, audioTourAllOf.description) &&
        Objects.equals(this.audioUrl, audioTourAllOf.audioUrl) &&
        Objects.equals(this.institutionId, audioTourAllOf.institutionId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(description), audioUrl, institutionId);
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
    sb.append("class AudioTourAllOf {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    audioUrl: ").append(toIndentedString(audioUrl)).append("\n");
    sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
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

