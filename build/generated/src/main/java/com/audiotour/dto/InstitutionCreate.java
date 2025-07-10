package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.util.Arrays;
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
 * InstitutionCreate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T12:35:57.113105+03:00[Europe/Moscow]")
public class InstitutionCreate {

  private String name;

  private JsonNullable<String> description = JsonNullable.undefined();

  private JsonNullable<URI> websiteUrl = JsonNullable.undefined();

  /**
   * Default constructor
   * @deprecated Use {@link InstitutionCreate#InstitutionCreate(String)}
   */
  @Deprecated
  public InstitutionCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InstitutionCreate(String name) {
    this.name = name;
  }

  public InstitutionCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InstitutionCreate description(String description) {
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

  public InstitutionCreate websiteUrl(URI websiteUrl) {
    this.websiteUrl = JsonNullable.of(websiteUrl);
    return this;
  }

  /**
   * Get websiteUrl
   * @return websiteUrl
  */
  @Valid 
  @Schema(name = "website_url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("website_url")
  public JsonNullable<URI> getWebsiteUrl() {
    return websiteUrl;
  }

  public void setWebsiteUrl(JsonNullable<URI> websiteUrl) {
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
    InstitutionCreate institutionCreate = (InstitutionCreate) o;
    return Objects.equals(this.name, institutionCreate.name) &&
        equalsNullable(this.description, institutionCreate.description) &&
        equalsNullable(this.websiteUrl, institutionCreate.websiteUrl);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, hashCodeNullable(description), hashCodeNullable(websiteUrl));
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
    sb.append("class InstitutionCreate {\n");
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

