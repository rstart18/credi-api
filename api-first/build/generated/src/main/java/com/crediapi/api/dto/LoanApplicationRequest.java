package com.crediapi.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * LoanApplicationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-16T13:39:11.171769400-05:00[America/Bogota]")
public class LoanApplicationRequest {

  private Long customerId;

  private Long productId;

  private BigDecimal amount;

  private Integer termMonths;

  public LoanApplicationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LoanApplicationRequest(Long customerId, Long productId, BigDecimal amount, Integer termMonths) {
    this.customerId = customerId;
    this.productId = productId;
    this.amount = amount;
    this.termMonths = termMonths;
  }

  public LoanApplicationRequest customerId(Long customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @NotNull 
  @Schema(name = "customerId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerId")
  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public LoanApplicationRequest productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @NotNull 
  @Schema(name = "productId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productId")
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public LoanApplicationRequest amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * minimum: 1000
   * @return amount
  */
  @NotNull @Valid @DecimalMin("1000") 
  @Schema(name = "amount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public LoanApplicationRequest termMonths(Integer termMonths) {
    this.termMonths = termMonths;
    return this;
  }

  /**
   * Get termMonths
   * minimum: 6
   * maximum: 60
   * @return termMonths
  */
  @NotNull @Min(6) @Max(60) 
  @Schema(name = "termMonths", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("termMonths")
  public Integer getTermMonths() {
    return termMonths;
  }

  public void setTermMonths(Integer termMonths) {
    this.termMonths = termMonths;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoanApplicationRequest loanApplicationRequest = (LoanApplicationRequest) o;
    return Objects.equals(this.customerId, loanApplicationRequest.customerId) &&
        Objects.equals(this.productId, loanApplicationRequest.productId) &&
        Objects.equals(this.amount, loanApplicationRequest.amount) &&
        Objects.equals(this.termMonths, loanApplicationRequest.termMonths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, productId, amount, termMonths);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoanApplicationRequest {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    termMonths: ").append(toIndentedString(termMonths)).append("\n");
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

