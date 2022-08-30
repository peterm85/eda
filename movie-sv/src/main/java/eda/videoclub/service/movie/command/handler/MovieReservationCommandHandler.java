package eda.videoclub.service.movie.command.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.movie.command.MovieReservationCommand;
import eda.videoclub.service.movie.domain.entity.Movie;
import eda.videoclub.service.movie.port.producer.EventProducer;
import eda.videoclub.service.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieReservationCommandHandler {

  @Autowired private MovieService movieService;
  @Autowired private EventProducer eventProducer;

  public void handle(final MovieReservationCommand command) {

    Movie updatedMovie;
    try {
      updatedMovie = movieService.reserveMovie(command.getImdbId());

      log.info(
          "Movie with imbdId {} has been reserved by {}. Total stock: {}",
          updatedMovie.getImdbId(),
          command.getUserId(),
          updatedMovie.getStock());

      eventProducer.sendMessage(command);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
