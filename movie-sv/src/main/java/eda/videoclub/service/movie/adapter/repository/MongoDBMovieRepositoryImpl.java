package eda.videoclub.service.movie.adapter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eda.videoclub.service.movie.adapter.repository.converter.MovieEntityToMovieConverter;
import eda.videoclub.service.movie.adapter.repository.converter.MovieToMovieEntityConverter;
import eda.videoclub.service.movie.adapter.repository.entity.MovieEntity;
import eda.videoclub.service.movie.domain.entity.Movie;
import eda.videoclub.service.movie.exception.MovieNotFoundException;
import eda.videoclub.service.movie.port.repository.MovieRepository;

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

  @Override
  public Movie getByImdbId(final String movieId) throws Exception {
    final List<MovieEntity> entityResults = mongoDBMovieDefaultRepository.findByImdbId(movieId);
    if (!entityResults.isEmpty() && entityResults.size() == 1) {
      return movieEntityToMovieConverter.convert(entityResults.get(0));
    } else {
      throw new MovieNotFoundException("Movie with imbdId " + movieId + " not found");
    }
  }

  @Override
  public Movie update(final Movie movie) {
    final MovieEntity entity = movieToMovieEntityConverter.convert(movie);
    final MovieEntity entityResult = mongoDBMovieDefaultRepository.save(entity);
    return movieEntityToMovieConverter.convert(entityResult);
  }
}
