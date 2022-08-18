package eda.movie.port.rest.api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
  @NotEmpty private String imdbId;
  @NotEmpty private String name;

  @Min(value = 1)
  private Integer stock;
}
