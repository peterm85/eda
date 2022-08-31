package eda.videoclub.service.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.domain.entity.BookingStatus;
import eda.videoclub.service.booking.port.repository.BookingRepository;

@Service
public class BookingService {

  @Autowired private BookingRepository bookingRepository;

  public Booking createBooking(final Booking booking) {

    booking.setStatus(BookingStatus.CREATED);

    return bookingRepository.create(booking);
  }

  public Booking confirmBooking(final String bookingId) throws Exception {

    Booking booking = bookingRepository.getById(bookingId);

    booking.setStatus(BookingStatus.CONFIRMED);

    return bookingRepository.update(booking);
  }
}
