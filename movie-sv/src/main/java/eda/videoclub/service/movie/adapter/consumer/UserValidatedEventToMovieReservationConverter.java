package eda.videoclub.service.movie.adapter.consumer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.UserValidatedEvent;
import eda.videoclub.service.movie.command.MovieReservationCommand;

@Component
public class UserValidatedEventToMovieReservationConverter
    implements Converter<UserValidatedEvent, MovieReservationCommand> {

  @Override
  public MovieReservationCommand convert(final UserValidatedEvent source) {

    return MovieReservationCommand.builder()
        .bookingId(source.getBookingId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .build();
  }
}
