package eda.movie.adapter.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.movie.adapter.repository.entity.MovieEntity;
import eda.movie.domain.entity.Movie;

@Component
public class MovieEntityToMovieConverter implements Converter<MovieEntity, Movie> {

  @Override
  public Movie convert(MovieEntity source) {

    return Movie.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .name(source.getName())
        .stock(source.getStock())
        .build();
  }
}
