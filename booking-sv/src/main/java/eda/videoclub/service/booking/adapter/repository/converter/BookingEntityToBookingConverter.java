package eda.videoclub.service.booking.adapter.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.service.booking.adapter.repository.entity.BookingEntity;
import eda.videoclub.service.booking.domain.entity.Booking;

@Component
public class BookingEntityToBookingConverter implements Converter<BookingEntity, Booking> {

  @Override
  public Booking convert(BookingEntity source) {

    return Booking.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .status(source.getStatus())
        .lastUpdateDatetime(source.getLastUpdateDatetime())
        .build();
  }
}
