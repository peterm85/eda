package eda.booking.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.booking.adapter.rest.converter.BookingRequestToBookingConverter;
import eda.booking.domain.entity.Booking;
import eda.booking.port.rest.api.model.BookingRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BookingRequestToBookingConverterTest {

  private BookingRequestToBookingConverter converter = new BookingRequestToBookingConverter();

  @Test
  void convertTest() {
    // given
    final BookingRequest source =
        BookingRequest.builder().imdbId("tt0120737").userId("62fe1a48df883b786b2eaf0").build();
    // when
    final Booking result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getImdbId(), source.getImdbId());
    assertEquals(result.getUserId(), source.getUserId());
  }
}
