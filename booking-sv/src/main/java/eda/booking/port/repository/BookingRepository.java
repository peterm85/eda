package eda.booking.port.repository;

import eda.booking.domain.entity.Booking;

public interface BookingRepository {

  Booking create(Booking movie);
}
