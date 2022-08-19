package eda.booking.adapter.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.booking.domain.entity.Booking;
import eda.booking.port.rest.api.model.BookingRequest;

@Component
public class BookingRequestToBookingConverter implements Converter<BookingRequest, Booking> {

  @Override
  public Booking convert(final BookingRequest source) {

    return Booking.builder().imdbId(source.getImdbId()).userId(source.getUserId()).build();
  }
}
