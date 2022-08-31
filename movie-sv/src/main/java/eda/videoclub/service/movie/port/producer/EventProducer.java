package eda.videoclub.service.movie.port.producer;

import eda.videoclub.service.movie.command.MovieReservationCommand;
import eda.videoclub.service.movie.domain.entity.RejectionReasonVO;

public interface EventProducer {

  void sendMessage(MovieReservationCommand command);

  void sendErrorMessage(MovieReservationCommand command, RejectionReasonVO reason);
}
