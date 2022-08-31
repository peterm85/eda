package eda.videoclub.service.booking.command.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.booking.command.ConfirmBookingCommand;
import eda.videoclub.service.booking.service.BookingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConfirmBookingCommandHandler {

  @Autowired private BookingService bookingService;

  public void handle(final ConfirmBookingCommand command) {

    try {
      bookingService.confirmBooking(command.getBookingId());
      log.info("Booking with id {} has been CONFIRMED", command.getBookingId());

    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
