package eda.videoclub.service.booking.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import eda.videoclub.service.booking.adapter.rest.controller.BookingControllerImpl;
import eda.videoclub.service.booking.adapter.rest.converter.BookingRequestToBookingConverter;
import eda.videoclub.service.booking.adapter.rest.converter.BookingToBookingResponseConverter;
import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.port.rest.api.model.BookingRequest;
import eda.videoclub.service.booking.port.rest.api.model.BookingResponse;
import eda.videoclub.service.booking.service.BookingService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BookingControllerImplTest {

  @InjectMocks BookingControllerImpl movieControllerImpl;

  @Mock BookingRequestToBookingConverter MovieRequestToMovieConverter;
  @Mock BookingToBookingResponseConverter MovieToMovieResponseConverter;
  @Mock BookingService movieService;

  @Test
  void createMovieTest() {

    // given
    final BookingRequest request =
        BookingRequest.builder().imdbId("tt0120737").userId("62fe1a48df883b786b2eaf0").build();

    final Booking booking =
        Booking.builder()
            .id("62fc96faced333564842f302")
            .imdbId("tt0120737")
            .userId("62fe1a48df883b786b2eaf0")
            .build();

    // when
    Mockito.when(movieService.createBooking(Mockito.any())).thenReturn(booking);

    final ResponseEntity<BookingResponse> response = movieControllerImpl.bookMovie(request);

    // then
    assertNotNull(response);
  }
}
