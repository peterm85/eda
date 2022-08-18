package eda.user.port.rest.api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

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
