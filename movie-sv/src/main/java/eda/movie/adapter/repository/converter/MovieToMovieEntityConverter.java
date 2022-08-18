package eda.movie.adapter.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.movie.adapter.repository.entity.MovieEntity;
import eda.movie.domain.entity.Movie;

@Component
public class MovieToMovieEntityConverter implements Converter<Movie, MovieEntity> {

  @Override
  public MovieEntity convert(final Movie source) {

    return MovieEntity.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .name(source.getName())
        .stock(source.getStock())
        .build();
  }
}
