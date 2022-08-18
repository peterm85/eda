package eda.movie.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.movie.adapter.rest.converter.MovieRequestToMovieConverter;
import eda.movie.domain.entity.Movie;
import eda.movie.port.rest.api.model.MovieRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MovieRequestToMovieConverterTest {

  private MovieRequestToMovieConverter converter = new MovieRequestToMovieConverter();

  @Test
  void convertTest() {
    // given
    final MovieRequest source =
        MovieRequest.builder()
            .imdbId("tt0120737")
            .name("The Lord of the Rings - The Fellowship of the Ring")
            .stock(3)
            .build();
    // when
    final Movie result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getImdbId(), source.getImdbId());
    assertEquals(result.getName(), source.getName());
    assertEquals(result.getStock(), source.getStock());
  }
}
