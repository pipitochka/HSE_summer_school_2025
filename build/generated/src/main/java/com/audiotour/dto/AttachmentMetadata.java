package com.audiotour.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AttachmentMetadata
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-07-12T09:49:41.309338+03:00[Europe/Moscow]")
public class AttachmentMetadata {

  private UUID id;

  private String filename;

  private URI url;

  private Long sizeBytes;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime uploadedAt;

  public AttachmentMetadata id(UUID id) {
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

  public AttachmentMetadata filename(String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * Get filename
   * @return filename
  */
  
  @Schema(name = "filename", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public AttachmentMetadata url(URI url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  */
  @Valid 
  @Schema(name = "url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("url")
  public URI getUrl() {
    return url;
  }

  public void setUrl(URI url) {
    this.url = url;
  }

  public AttachmentMetadata sizeBytes(Long sizeBytes) {
    this.sizeBytes = sizeBytes;
    return this;
  }

  /**
   * Get sizeBytes
   * @return sizeBytes
  */
  
  @Schema(name = "size_bytes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size_bytes")
  public Long getSizeBytes() {
    return sizeBytes;
  }

  public void setSizeBytes(Long sizeBytes) {
    this.sizeBytes = sizeBytes;
  }

  public AttachmentMetadata uploadedAt(OffsetDateTime uploadedAt) {
    this.uploadedAt = uploadedAt;
    return this;
  }

  /**
   * Get uploadedAt
   * @return uploadedAt
  */
  @Valid 
  @Schema(name = "uploaded_at", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uploaded_at")
  public OffsetDateTime getUploadedAt() {
    return uploadedAt;
  }

  public void setUploadedAt(OffsetDateTime uploadedAt) {
    this.uploadedAt = uploadedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentMetadata attachmentMetadata = (AttachmentMetadata) o;
    return Objects.equals(this.id, attachmentMetadata.id) &&
        Objects.equals(this.filename, attachmentMetadata.filename) &&
        Objects.equals(this.url, attachmentMetadata.url) &&
        Objects.equals(this.sizeBytes, attachmentMetadata.sizeBytes) &&
        Objects.equals(this.uploadedAt, attachmentMetadata.uploadedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, filename, url, sizeBytes, uploadedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentMetadata {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    sizeBytes: ").append(toIndentedString(sizeBytes)).append("\n");
    sb.append("    uploadedAt: ").append(toIndentedString(uploadedAt)).append("\n");
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

