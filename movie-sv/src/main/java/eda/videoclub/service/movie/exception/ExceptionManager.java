package eda.videoclub.service.movie.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eda.videoclub.service.movie.command.MovieReservationCommand;
import eda.videoclub.service.movie.domain.entity.RejectionReasonVO;
import eda.videoclub.service.movie.port.producer.EventProducer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ExceptionManager {

  @Autowired private EventProducer eventProducer;

  public void handler(final MovieReservationCommand command, final Exception ex) {

    log.error(ex.getMessage());

    RejectionReasonVO reasonEnum;
    if (ex instanceof MovieNotFoundException) {
      reasonEnum = RejectionReasonVO.MOVIE_NOT_FOUND;
    } else if (ex instanceof MovieNotAvailableException) {
      reasonEnum = RejectionReasonVO.MOVIE_NOT_AVAILABLE;
    } else {
      reasonEnum = RejectionReasonVO.UNKNOWN_ERROR;
    }

    eventProducer.sendErrorMessage(command, reasonEnum);
  }
}
