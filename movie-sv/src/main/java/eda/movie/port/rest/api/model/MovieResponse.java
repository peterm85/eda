package eda.movie.port.rest.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieResponse {
  private String id;
  private String imdbId;
  private String name;
  private Integer stock;
}
