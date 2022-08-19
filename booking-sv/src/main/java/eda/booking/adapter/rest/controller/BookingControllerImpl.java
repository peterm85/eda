package eda.booking.adapter.rest.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eda.booking.adapter.rest.converter.BookingRequestToBookingConverter;
import eda.booking.adapter.rest.converter.BookingToBookingResponseConverter;
import eda.booking.domain.entity.Booking;
import eda.booking.port.rest.BookingController;
import eda.booking.port.rest.api.model.BookingRequest;
import eda.booking.port.rest.api.model.BookingResponse;
import eda.booking.service.BookingService;

@RequestMapping("/videoclub")
@RestController
public class BookingControllerImpl implements BookingController {

  private static final String SLASH = "/";
  private static final String MOVIE_PATH = SLASH + "booking";

  @Autowired private BookingService bookingService;

  @Autowired private BookingRequestToBookingConverter bookingRequestToBookingConverter;
  @Autowired private BookingToBookingResponseConverter bookingToBookingResponseConverter;

  @Override
  @PostMapping(value = MOVIE_PATH)
  public ResponseEntity<BookingResponse> bookMovie(@Valid @NotNull final BookingRequest request) {

    final Booking booking = bookingRequestToBookingConverter.convert(request);
    final BookingResponse response =
        bookingToBookingResponseConverter.convert(bookingService.createBooking(booking));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
