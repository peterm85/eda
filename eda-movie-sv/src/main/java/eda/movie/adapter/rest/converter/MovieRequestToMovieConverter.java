package eda.movie.adapter.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.movie.domain.entity.Movie;
import eda.movie.port.rest.api.model.MovieRequest;

@Component
public class MovieRequestToMovieConverter implements Converter<MovieRequest, Movie> {

  @Override
  public Movie convert(final MovieRequest source) {

    return Movie.builder()
        .imdbId(source.getImdbId())
        .name(source.getName())
        .stock(source.getStock())
        .build();
  }
}
