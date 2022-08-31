package eda.videoclub.service.booking.rest;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.videoclub.service.booking.adapter.rest.converter.BookingToBookingResponseConverter;
import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.domain.entity.BookingStatus;
import eda.videoclub.service.booking.port.rest.api.model.BookingResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BookingToBookingResponseConverterTest {

  private BookingToBookingResponseConverter converter = new BookingToBookingResponseConverter();

  @Test
  void convertTest() {
    // given
    final Booking source =
        Booking.builder()
            .imdbId("tt0120737")
            .userId("62fe1a48df883b786b2eaf0")
            .status(BookingStatus.CREATED)
            .lastUpdateDatetime(Instant.now())
            .build();
    // when
    final BookingResponse result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getImdbId(), source.getImdbId());
    assertEquals(result.getUserId(), source.getUserId());
    assertEquals(result.getStatus(), source.getStatus());
    assertEquals(result.getLastUpdateDatetime(), source.getLastUpdateDatetime());
  }
}
