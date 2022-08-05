package eda.movie.port.rest.api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieRequest {
  @NotEmpty private String imdbId;
  @NotEmpty private String name;

  @Min(value = 1)
  private Integer stock;
}
