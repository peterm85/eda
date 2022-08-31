package eda.videoclub.service.booking.adapter.consumer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.MovieReservedEvent;
import eda.videoclub.service.booking.command.ConfirmBookingCommand;

@Component
public class MovieReservationEventToConfirmBookingConverter
    implements Converter<MovieReservedEvent, ConfirmBookingCommand> {

  @Override
  public ConfirmBookingCommand convert(final MovieReservedEvent source) {

    return ConfirmBookingCommand.builder()
        .bookingId(source.getBookingId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .build();
  }
}
