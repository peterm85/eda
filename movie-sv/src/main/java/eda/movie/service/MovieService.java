package eda.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.movie.domain.entity.Movie;
import eda.movie.port.repository.MovieRepository;

@Service
public class MovieService {

  @Autowired private MovieRepository movieRepository;

  public Movie createMovie(final Movie movie) {
    return movieRepository.create(movie);
  }
}
