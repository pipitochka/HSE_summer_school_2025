package com.organizer.todo.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.organizer.todo.dto.Institution;
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
 * PaginatedInstitutions
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-10T12:39:26.405200+03:00[Europe/Moscow]")
public class PaginatedInstitutions {

  @Valid
  private List<@Valid Institution> items;

  private Long totalElements;

  private Integer totalPages;

  private Integer page;

  private Integer size;

  public PaginatedInstitutions items(List<@Valid Institution> items) {
    this.items = items;
    return this;
  }

  public PaginatedInstitutions addItemsItem(Institution itemsItem) {
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
  public List<@Valid Institution> getItems() {
    return items;
  }

  public void setItems(List<@Valid Institution> items) {
    this.items = items;
  }

  public PaginatedInstitutions totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
  */
  
  @Schema(name = "total_elements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total_elements")
  public Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }

  public PaginatedInstitutions totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
  */
  
  @Schema(name = "total_pages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total_pages")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public PaginatedInstitutions page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  */
  
  @Schema(name = "page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("page")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public PaginatedInstitutions size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
  */
  
  @Schema(name = "size", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginatedInstitutions paginatedInstitutions = (PaginatedInstitutions) o;
    return Objects.equals(this.items, paginatedInstitutions.items) &&
        Objects.equals(this.totalElements, paginatedInstitutions.totalElements) &&
        Objects.equals(this.totalPages, paginatedInstitutions.totalPages) &&
        Objects.equals(this.page, paginatedInstitutions.page) &&
        Objects.equals(this.size, paginatedInstitutions.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, totalElements, totalPages, page, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginatedInstitutions {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

