package eda.videoclub.service.movie.adapter.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.service.movie.adapter.repository.entity.MovieEntity;
import eda.videoclub.service.movie.domain.entity.Movie;

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
