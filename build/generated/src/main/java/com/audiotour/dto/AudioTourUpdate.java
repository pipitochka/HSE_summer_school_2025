package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AudioTourUpdate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T12:35:57.113105+03:00[Europe/Moscow]")
public class AudioTourUpdate {

  private String title;

  private String description;

  private URI audioUrl;

  @Valid
  private List<UUID> tags;

  public AudioTourUpdate title(String title) {
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

  public AudioTourUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AudioTourUpdate audioUrl(URI audioUrl) {
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

  public AudioTourUpdate tags(List<UUID> tags) {
    this.tags = tags;
    return this;
  }

  public AudioTourUpdate addTagsItem(UUID tagsItem) {
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
    AudioTourUpdate audioTourUpdate = (AudioTourUpdate) o;
    return Objects.equals(this.title, audioTourUpdate.title) &&
        Objects.equals(this.description, audioTourUpdate.description) &&
        Objects.equals(this.audioUrl, audioTourUpdate.audioUrl) &&
        Objects.equals(this.tags, audioTourUpdate.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, audioUrl, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AudioTourUpdate {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

