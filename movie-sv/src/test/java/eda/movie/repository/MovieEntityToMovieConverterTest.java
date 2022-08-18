package eda.movie.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.movie.adapter.repository.converter.MovieEntityToMovieConverter;
import eda.movie.adapter.repository.entity.MovieEntity;
import eda.movie.domain.entity.Movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MovieEntityToMovieConverterTest {

  private MovieEntityToMovieConverter converter = new MovieEntityToMovieConverter();

  @Test
  void convertTest() {
    // given
    final MovieEntity source =
        MovieEntity.builder()
            .id("62fe0314af8266262ac59e29")
            .imdbId("tt0120737")
            .name("The Lord of the Rings - The Fellowship of the Ring")
            .stock(3)
            .build();
    // when
    final Movie result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getId(), source.getId());
    assertEquals(result.getImdbId(), source.getImdbId());
    assertEquals(result.getName(), source.getName());
    assertEquals(result.getStock(), source.getStock());
  }
}
