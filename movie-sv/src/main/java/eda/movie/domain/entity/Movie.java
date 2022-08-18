package eda.movie.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {

  private String id;

  private String imdbId;

  private String name;

  private Integer stock;
}
