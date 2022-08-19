package eda.booking.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.booking.adapter.repository.converter.BookingToBookingEntityConverter;
import eda.booking.adapter.repository.entity.BookingEntity;
import eda.booking.domain.entity.Booking;
import eda.booking.domain.entity.BookingStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BookingToBookingEntityConverterTest {

  private BookingToBookingEntityConverter converter = new BookingToBookingEntityConverter();

  @Test
  void convertTest() {
    // given
    final Booking source =
        Booking.builder()
            .imdbId("tt0120737")
            .userId("62fe1a48df883b786b2eaf0")
            .status(BookingStatus.CREATED)
            .build();
    // when
    final BookingEntity result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getImdbId(), source.getImdbId());
    assertEquals(result.getUserId(), source.getUserId());
    assertEquals(result.getStatus(), source.getStatus());
  }
}
