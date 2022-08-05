package eda.movie.adapter.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.movie.domain.entity.Movie;
import eda.movie.port.rest.api.model.MovieResponse;

@Component
public class MovieToMovieResponseConverter implements Converter<Movie, MovieResponse> {

  @Override
  public MovieResponse convert(final Movie source) {

    return MovieResponse.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .name(source.getName())
        .stock(source.getStock())
        .build();
  }
}
