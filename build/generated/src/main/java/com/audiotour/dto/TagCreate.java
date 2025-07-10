package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TagCreate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T13:08:50.398387+03:00[Europe/Moscow]")
public class TagCreate {

  private String name;

  /**
   * Default constructor
   * @deprecated Use {@link TagCreate#TagCreate(String)}
   */
  @Deprecated
  public TagCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TagCreate(String name) {
    this.name = name;
  }

  public TagCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Уникальное имя тега
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Импрессионизм", description = "Уникальное имя тега", requiredMode = Schema.RequiredMode.REQUIRED)
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
    TagCreate tagCreate = (TagCreate) o;
    return Objects.equals(this.name, tagCreate.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagCreate {\n");
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

