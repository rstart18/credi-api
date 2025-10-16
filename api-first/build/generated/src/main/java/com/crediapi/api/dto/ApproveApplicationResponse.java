package com.crediapi.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ApproveApplicationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-16T13:39:11.171769400-05:00[America/Bogota]")
public class ApproveApplicationResponse {

  private Long applicationId;

  private Long loanId;

  private String status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime approvedAt;

  public ApproveApplicationResponse applicationId(Long applicationId) {
    this.applicationId = applicationId;
    return this;
  }

  /**
   * Get applicationId
   * @return applicationId
  */
  
  @Schema(name = "applicationId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("applicationId")
  public Long getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Long applicationId) {
    this.applicationId = applicationId;
  }

  public ApproveApplicationResponse loanId(Long loanId) {
    this.loanId = loanId;
    return this;
  }

  /**
   * Get loanId
   * @return loanId
  */
  
  @Schema(name = "loanId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("loanId")
  public Long getLoanId() {
    return loanId;
  }

  public void setLoanId(Long loanId) {
    this.loanId = loanId;
  }

  public ApproveApplicationResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ApproveApplicationResponse approvedAt(OffsetDateTime approvedAt) {
    this.approvedAt = approvedAt;
    return this;
  }

  /**
   * Get approvedAt
   * @return approvedAt
  */
  @Valid 
  @Schema(name = "approvedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("approvedAt")
  public OffsetDateTime getApprovedAt() {
    return approvedAt;
  }

  public void setApprovedAt(OffsetDateTime approvedAt) {
    this.approvedAt = approvedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApproveApplicationResponse approveApplicationResponse = (ApproveApplicationResponse) o;
    return Objects.equals(this.applicationId, approveApplicationResponse.applicationId) &&
        Objects.equals(this.loanId, approveApplicationResponse.loanId) &&
        Objects.equals(this.status, approveApplicationResponse.status) &&
        Objects.equals(this.approvedAt, approveApplicationResponse.approvedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, loanId, status, approvedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApproveApplicationResponse {\n");
    sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
    sb.append("    loanId: ").append(toIndentedString(loanId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    approvedAt: ").append(toIndentedString(approvedAt)).append("\n");
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

