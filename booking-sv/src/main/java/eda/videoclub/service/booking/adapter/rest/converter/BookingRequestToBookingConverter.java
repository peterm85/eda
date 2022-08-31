package eda.videoclub.service.booking.adapter.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.port.rest.api.model.BookingRequest;

@Component
public class BookingRequestToBookingConverter implements Converter<BookingRequest, Booking> {

  @Override
  public Booking convert(final BookingRequest source) {

    return Booking.builder().imdbId(source.getImdbId()).userId(source.getUserId()).build();
  }
}
