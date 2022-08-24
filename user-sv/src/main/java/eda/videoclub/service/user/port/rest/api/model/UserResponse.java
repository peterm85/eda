package eda.videoclub.service.user.port.rest.api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
  @ApiModelProperty(
      notes = "Internal identification",
      example = "62fc96faced333564842f302",
      required = true)
  private String id;

  @ApiModelProperty(notes = "User name", example = "Jose Luis", required = true)
  @NotEmpty
  private String name;

  @ApiModelProperty(notes = "User address", example = "Montequinto street, 15th", required = true)
  @NotEmpty
  private String address;

  @ApiModelProperty(notes = "User age", example = "22", required = true)
  @Min(value = 16)
  private Integer age;
}
