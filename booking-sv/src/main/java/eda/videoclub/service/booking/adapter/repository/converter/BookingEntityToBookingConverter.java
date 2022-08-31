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
public class BookingEntityToBookingConverter implements Converter<BookingEntity, Booking> {

  @Override
  public Booking convert(BookingEntity source) {

    return Booking.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .status(
            BookingStatusVO.fromString(
                Optional.ofNullable(source.getStatus()).map(BookingStatus::name).orElse(null)))
        .reason(
            RejectionReasonVO.fromString(
                Optional.ofNullable(source.getReason()).map(RejectionReason::name).orElse(null)))
        .lastUpdateDatetime(source.getLastUpdateDatetime())
        .build();
  }
}
