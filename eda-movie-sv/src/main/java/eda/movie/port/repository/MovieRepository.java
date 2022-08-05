package eda.movie.port.repository;

import eda.movie.domain.entity.Movie;

public interface MovieRepository {

  Movie create(Movie movie);
}
