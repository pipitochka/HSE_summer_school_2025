package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * InstitutionDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-12T09:49:41.309338+03:00[Europe/Moscow]")
public class InstitutionDto {

  private UUID id;

  private String name;

  private String description;

  private URI websiteUrl;

  public InstitutionDto id(UUID id) {
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

  public InstitutionDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InstitutionDto description(String description) {
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

  public InstitutionDto websiteUrl(URI websiteUrl) {
    this.websiteUrl = websiteUrl;
    return this;
  }

  /**
   * Get websiteUrl
   * @return websiteUrl
  */
  @Valid 
  @Schema(name = "websiteUrl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("websiteUrl")
  public URI getWebsiteUrl() {
    return websiteUrl;
  }

  public void setWebsiteUrl(URI websiteUrl) {
    this.websiteUrl = websiteUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstitutionDto institutionDto = (InstitutionDto) o;
    return Objects.equals(this.id, institutionDto.id) &&
        Objects.equals(this.name, institutionDto.name) &&
        Objects.equals(this.description, institutionDto.description) &&
        Objects.equals(this.websiteUrl, institutionDto.websiteUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, websiteUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstitutionDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    websiteUrl: ").append(toIndentedString(websiteUrl)).append("\n");
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

