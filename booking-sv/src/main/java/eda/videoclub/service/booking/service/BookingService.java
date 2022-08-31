package eda.videoclub.service.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.domain.entity.BookingStatusVO;
import eda.videoclub.service.booking.domain.entity.RejectionReasonVO;
import eda.videoclub.service.booking.port.repository.BookingRepository;

@Service
public class BookingService {

  @Autowired private BookingRepository bookingRepository;

  public Booking createBooking(final Booking booking) {

    booking.setStatus(BookingStatusVO.CREATED);

    return bookingRepository.create(booking);
  }

  public Booking confirmBooking(final String bookingId) throws Exception {
    return updateBooking(bookingId, BookingStatusVO.CONFIRMED, null);
  }

  public Booking cancelBooking(final String bookingId, final RejectionReasonVO reason)
      throws Exception {
    return updateBooking(bookingId, BookingStatusVO.CANCELLED, reason);
  }

  private Booking updateBooking(
      final String bookingId, final BookingStatusVO status, final RejectionReasonVO reason)
      throws Exception {

    Booking booking = bookingRepository.getById(bookingId);

    booking.setStatus(status);
    booking.setReason(reason);

    return bookingRepository.update(booking);
  }
}
