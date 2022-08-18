package eda.movie.rest.controller.ut;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import eda.movie.adapter.rest.controller.MovieControllerImpl;
import eda.movie.port.rest.api.model.MovieRequest;
import eda.movie.port.rest.api.model.MovieResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MovieControllerImplTest {

  @InjectMocks MovieControllerImpl filmControllerImpl;

  @Test
  void createFilmTest() {

    // given
    final MovieRequest request =
        MovieRequest.builder()
            .imdbId("tt0120737")
            .name("The Lord of the Rings - The Fellowship of the Ring")
            .stock(3)
            .build();

    // when
    final ResponseEntity<MovieResponse> response = filmControllerImpl.create(request);

    // then
    assertNotNull(response);
  }
}
