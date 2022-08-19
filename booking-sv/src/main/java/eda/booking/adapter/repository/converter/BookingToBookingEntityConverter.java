package eda.booking.adapter.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.booking.adapter.repository.entity.BookingEntity;
import eda.booking.domain.entity.Booking;

@Component
public class BookingToBookingEntityConverter implements Converter<Booking, BookingEntity> {

  @Override
  public BookingEntity convert(final Booking source) {

    return BookingEntity.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .status(source.getStatus())
        .lastUpdateDatetime(source.getLastUpdateDatetime())
        .build();
  }
}
