package eda.videoclub.service.movie.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.videoclub.service.movie.adapter.repository.converter.MovieToMovieEntityConverter;
import eda.videoclub.service.movie.adapter.repository.entity.MovieEntity;
import eda.videoclub.service.movie.domain.entity.Movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MovieToMovieEntityConverterTest {

  private MovieToMovieEntityConverter converter = new MovieToMovieEntityConverter();

  @Test
  void convertTest() {
    // given
    final Movie source =
        Movie.builder()
            .imdbId("tt0120737")
            .name("The Lord of the Rings - The Fellowship of the Ring")
            .stock(3)
            .build();
    // when
    final MovieEntity result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getImdbId(), source.getImdbId());
    assertEquals(result.getName(), source.getName());
    assertEquals(result.getStock(), source.getStock());
  }
}
