package eda.videoclub.service.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.movie.domain.entity.Movie;
import eda.videoclub.service.movie.port.repository.MovieRepository;

@Service
public class MovieService {

  @Autowired private MovieRepository movieRepository;

  public Movie createMovie(final Movie movie) {
    return movieRepository.create(movie);
  }

  public Movie reserveMovie(final String imdbId) throws Exception {
    final Movie movie = movieRepository.getByImdbId(imdbId);

    if (movie.getStock() == 0)
      throw new Exception("Not enough stock for movie with imbdId " + imdbId);
    else movie.setStock(movie.getStock() - 1);

    return movieRepository.update(movie);
  }
}
