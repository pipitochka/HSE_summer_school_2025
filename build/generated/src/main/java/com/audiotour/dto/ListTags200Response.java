package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
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
 * ListTags200Response
 */

@JsonTypeName("listTags_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T13:08:50.398387+03:00[Europe/Moscow]")
public class ListTags200Response {

  @Valid
  private List<@Valid TagDto> items;

  public ListTags200Response items(List<@Valid TagDto> items) {
    this.items = items;
    return this;
  }

  public ListTags200Response addItemsItem(TagDto itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("items")
  public List<@Valid TagDto> getItems() {
    return items;
  }

  public void setItems(List<@Valid TagDto> items) {
    this.items = items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTags200Response listTags200Response = (ListTags200Response) o;
    return Objects.equals(this.items, listTags200Response.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTags200Response {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

