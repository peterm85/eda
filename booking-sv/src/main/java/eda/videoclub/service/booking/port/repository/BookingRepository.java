package eda.videoclub.service.booking.port.repository;

import eda.videoclub.service.booking.domain.entity.Booking;

public interface BookingRepository {

  Booking create(Booking booking);

  Booking getById(String bookingId) throws Exception;

  Booking update(Booking booking);
}
