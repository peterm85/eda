package eda.videoclub.service.movie.port.producer;

import eda.videoclub.service.movie.command.MovieReservationCommand;

public interface EventProducer {

  void sendMessage(MovieReservationCommand command);
}
