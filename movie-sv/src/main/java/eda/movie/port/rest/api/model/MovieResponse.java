package eda.movie.port.rest.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieResponse {
  @ApiModelProperty(
      notes = "Internal identification",
      example = "62fc96faced333564842f302",
      required = true)
  private String id;

  @ApiModelProperty(notes = "Movie identification", example = "1234567890", required = true)
  private String imdbId;

  @ApiModelProperty(notes = "Movie name", example = "Star Wars", required = true)
  private String name;

  @ApiModelProperty(notes = "Number of CDs available", example = "10", required = true)
  private Integer stock;
}
