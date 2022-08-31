package eda.videoclub.service.booking.command.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.booking.command.CancelBookingCommand;
import eda.videoclub.service.booking.service.BookingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CancelBookingCommandHandler {

  @Autowired private BookingService bookingService;

  public void handle(final CancelBookingCommand command) {

    try {
      bookingService.cancelBooking(command.getBookingId(), command.getReason());
      log.info("Booking with id {} has been CANCELLED", command.getBookingId());

    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
