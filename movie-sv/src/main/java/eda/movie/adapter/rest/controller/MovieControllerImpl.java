package eda.movie.adapter.rest.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eda.movie.adapter.rest.converter.MovieRequestToMovieConverter;
import eda.movie.adapter.rest.converter.MovieToMovieResponseConverter;
import eda.movie.domain.entity.Movie;
import eda.movie.port.rest.MovieController;
import eda.movie.port.rest.api.model.MovieRequest;
import eda.movie.port.rest.api.model.MovieResponse;
import eda.movie.service.MovieService;

@RequestMapping("/videoclub")
@RestController
public class MovieControllerImpl implements MovieController {

  private static final String SLASH = "/";
  private static final String MOVIE_PATH = SLASH + "movie";

  @Autowired private MovieService movieService;

  @Autowired private MovieRequestToMovieConverter movieRequestToMovieConverter;
  @Autowired private MovieToMovieResponseConverter movieToMovieResponseConverter;

  @Override
  @PostMapping(value = MOVIE_PATH)
  public ResponseEntity<MovieResponse> create(@Valid @NotNull MovieRequest request) {

    final Movie movie = movieRequestToMovieConverter.convert(request);
    final MovieResponse filmResponse =
        movieToMovieResponseConverter.convert(movieService.createMovie(movie));

    return ResponseEntity.status(HttpStatus.CREATED).body(filmResponse);
  }
}
