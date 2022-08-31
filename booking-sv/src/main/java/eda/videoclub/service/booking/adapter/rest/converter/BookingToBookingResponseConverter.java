package eda.videoclub.service.booking.adapter.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.port.rest.api.model.BookingResponse;

@Component
public class BookingToBookingResponseConverter implements Converter<Booking, BookingResponse> {

  @Override
  public BookingResponse convert(final Booking source) {

    return BookingResponse.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .status(source.getStatus())
        .lastUpdateDatetime(source.getLastUpdateDatetime())
        .build();
  }
}
