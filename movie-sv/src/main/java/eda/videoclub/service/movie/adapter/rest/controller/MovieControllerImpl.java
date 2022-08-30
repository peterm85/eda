package eda.videoclub.service.movie.adapter.rest.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eda.videoclub.service.movie.adapter.rest.converter.MovieRequestToMovieConverter;
import eda.videoclub.service.movie.adapter.rest.converter.MovieToMovieResponseConverter;
import eda.videoclub.service.movie.domain.entity.Movie;
import eda.videoclub.service.movie.port.rest.MovieController;
import eda.videoclub.service.movie.port.rest.api.model.MovieRequest;
import eda.videoclub.service.movie.port.rest.api.model.MovieResponse;
import eda.videoclub.service.movie.service.MovieService;

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
  public ResponseEntity<MovieResponse> create(@Valid @NotNull final MovieRequest request) {

    final Movie movie = movieRequestToMovieConverter.convert(request);
    final MovieResponse response =
        movieToMovieResponseConverter.convert(movieService.createMovie(movie));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
