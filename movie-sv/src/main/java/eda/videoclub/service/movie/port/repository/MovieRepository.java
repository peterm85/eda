package eda.videoclub.service.movie.port.repository;

import eda.videoclub.service.movie.domain.entity.Movie;

public interface MovieRepository {

  Movie create(Movie movie);

  Movie getByImdbId(String movieId) throws Exception;

  Movie update(Movie movie);
}
