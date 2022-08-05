package eda.movie.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eda.movie.adapter.repository.converter.MovieEntityToMovieConverter;
import eda.movie.adapter.repository.converter.MovieToMovieEntityConverter;
import eda.movie.adapter.repository.entity.MovieEntity;
import eda.movie.domain.entity.Movie;
import eda.movie.port.repository.MovieRepository;

@Repository
public class MongoDBMovieRepositoryImpl implements MovieRepository {

  @Autowired private MongoDBMovieDefaultRepository mongoDBMovieDefaultRepository;

  @Autowired private MovieToMovieEntityConverter movieToMovieEntityConverter;
  @Autowired private MovieEntityToMovieConverter movieEntityToMovieConverter;

  @Override
  public Movie create(final Movie movie) {
    final MovieEntity entity = movieToMovieEntityConverter.convert(movie);
    final MovieEntity entityResult = mongoDBMovieDefaultRepository.insert(entity);
    return movieEntityToMovieConverter.convert(entityResult);
  }
}
