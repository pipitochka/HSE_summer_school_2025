package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
import com.audiotour.dto.Institution;
import com.audiotour.dto.TagDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AudioTourDetailsAllOf
 */

@JsonTypeName("AudioTourDetails_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T12:35:57.113105+03:00[Europe/Moscow]")
public class AudioTourDetailsAllOf {

  private Institution institution;

  @Valid
  private List<@Valid TagDto> tags;

  public AudioTourDetailsAllOf institution(Institution institution) {
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

  public AudioTourDetailsAllOf tags(List<@Valid TagDto> tags) {
    this.tags = tags;
    return this;
  }

  public AudioTourDetailsAllOf addTagsItem(TagDto tagsItem) {
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
    AudioTourDetailsAllOf audioTourDetailsAllOf = (AudioTourDetailsAllOf) o;
    return Objects.equals(this.institution, audioTourDetailsAllOf.institution) &&
        Objects.equals(this.tags, audioTourDetailsAllOf.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(institution, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AudioTourDetailsAllOf {\n");
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

