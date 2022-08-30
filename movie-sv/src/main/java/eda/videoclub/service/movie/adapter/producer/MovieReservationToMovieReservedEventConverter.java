package eda.videoclub.service.movie.adapter.producer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.MovieReservedEvent;
import eda.videoclub.service.movie.command.MovieReservationCommand;

@Component
public class MovieReservationToMovieReservedEventConverter
    implements Converter<MovieReservationCommand, MovieReservedEvent> {

  @Override
  public MovieReservedEvent convert(final MovieReservationCommand source) {

    return MovieReservedEvent.builder()
        .bookingId(source.getBookingId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .build();
  }
}
