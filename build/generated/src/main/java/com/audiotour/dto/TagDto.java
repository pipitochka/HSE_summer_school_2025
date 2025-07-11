package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TagDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-11T16:34:38.753307+03:00[Europe/Moscow]")
public class TagDto {

  private UUID id;

  private String name;

  /**
   * Default constructor
   * @deprecated Use {@link TagDto#TagDto(String)}
   */
  @Deprecated
  public TagDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TagDto(String name) {
    this.name = name;
  }

  public TagDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор тега
   * @return id
  */
  @Valid 
  @Schema(name = "id", description = "Уникальный идентификатор тега", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public TagDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название тега
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Название тега", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagDto tagDto = (TagDto) o;
    return Objects.equals(this.id, tagDto.id) &&
        Objects.equals(this.name, tagDto.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

