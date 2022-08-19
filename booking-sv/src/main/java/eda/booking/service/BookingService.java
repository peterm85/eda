package eda.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.booking.domain.entity.Booking;
import eda.booking.domain.entity.BookingStatus;
import eda.booking.port.repository.BookingRepository;

@Service
public class BookingService {

  @Autowired private BookingRepository bookingRepository;

  public Booking createBooking(Booking booking) {

    booking.setStatus(BookingStatus.CREATED);

    return bookingRepository.create(booking);
  }
}
