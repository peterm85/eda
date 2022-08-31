package eda.videoclub.service.booking.repository;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.videoclub.service.booking.adapter.repository.converter.BookingEntityToBookingConverter;
import eda.videoclub.service.booking.adapter.repository.entity.BookingEntity;
import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.domain.entity.BookingStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BookingEntityToBookingConverterTest {

  private BookingEntityToBookingConverter converter = new BookingEntityToBookingConverter();

  @Test
  void convertTest() {
    // given
    final BookingEntity source =
        BookingEntity.builder()
            .id("62fe0314af8266262ac59e29")
            .imdbId("tt0120737")
            .userId("62fe1a48df883b786b2eaf0")
            .status(BookingStatus.CREATED)
            .lastUpdateDatetime(Instant.now())
            .build();
    // when
    final Booking result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getId(), source.getId());
    assertEquals(result.getImdbId(), source.getImdbId());
    assertEquals(result.getUserId(), source.getUserId());
    assertEquals(result.getStatus(), source.getStatus());
    assertEquals(result.getLastUpdateDatetime(), source.getLastUpdateDatetime());
  }
}
