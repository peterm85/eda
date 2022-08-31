package eda.videoclub.service.booking.adapter.repository.converter;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.service.booking.adapter.repository.entity.BookingEntity;
import eda.videoclub.service.booking.adapter.repository.entity.BookingStatus;
import eda.videoclub.service.booking.adapter.repository.entity.RejectionReason;
import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.domain.entity.BookingStatusVO;
import eda.videoclub.service.booking.domain.entity.RejectionReasonVO;

@Component
public class BookingToBookingEntityConverter implements Converter<Booking, BookingEntity> {

  @Override
  public BookingEntity convert(final Booking source) {

    return BookingEntity.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .status(
            BookingStatus.fromString(
                Optional.ofNullable(source.getStatus()).map(BookingStatusVO::name).orElse(null)))
        .reason(
            RejectionReason.fromString(
                Optional.ofNullable(source.getReason()).map(RejectionReasonVO::name).orElse(null)))
        .lastUpdateDatetime(source.getLastUpdateDatetime())
        .build();
  }
}
