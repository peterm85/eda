package eda.videoclub.service.movie.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import eda.videoclub.service.movie.adapter.rest.controller.MovieControllerImpl;
import eda.videoclub.service.movie.adapter.rest.converter.MovieRequestToMovieConverter;
import eda.videoclub.service.movie.adapter.rest.converter.MovieToMovieResponseConverter;
import eda.videoclub.service.movie.domain.entity.Movie;
import eda.videoclub.service.movie.port.rest.api.model.MovieRequest;
import eda.videoclub.service.movie.port.rest.api.model.MovieResponse;
import eda.videoclub.service.movie.service.MovieService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MovieControllerImplTest {

  @InjectMocks MovieControllerImpl movieControllerImpl;

  @Mock MovieRequestToMovieConverter MovieRequestToMovieConverter;
  @Mock MovieToMovieResponseConverter MovieToMovieResponseConverter;
  @Mock MovieService movieService;

  @Test
  void createMovieTest() {

    // given
    final MovieRequest request =
        MovieRequest.builder()
            .imdbId("tt0120737")
            .name("The Lord of the Rings - The Fellowship of the Ring")
            .stock(3)
            .build();

    final Movie movie =
        Movie.builder()
            .id("62fc96faced333564842f302")
            .imdbId("tt0120737")
            .name("The Lord of the Rings - The Fellowship of the Ring")
            .stock(3)
            .build();

    // when
    Mockito.when(movieService.createMovie(Mockito.any())).thenReturn(movie);

    final ResponseEntity<MovieResponse> response = movieControllerImpl.create(request);

    // then
    assertNotNull(response);
  }
}
