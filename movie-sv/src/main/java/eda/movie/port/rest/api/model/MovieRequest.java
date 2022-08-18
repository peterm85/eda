package eda.movie.port.rest.api.model;

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
public class MovieRequest {
  @ApiModelProperty(notes = "Movie identification", example = "1234567890", required = true)
  @NotEmpty
  private String imdbId;

  @ApiModelProperty(notes = "Movie name", example = "Star Wars", required = true)
  @NotEmpty
  private String name;

  @ApiModelProperty(notes = "Number of CDs available", example = "10", required = true)
  @Min(value = 1)
  private Integer stock;
}
