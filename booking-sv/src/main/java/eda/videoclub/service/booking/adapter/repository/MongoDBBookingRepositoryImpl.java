package eda.videoclub.service.booking.adapter.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eda.videoclub.service.booking.adapter.repository.converter.BookingEntityToBookingConverter;
import eda.videoclub.service.booking.adapter.repository.converter.BookingToBookingEntityConverter;
import eda.videoclub.service.booking.adapter.repository.entity.BookingEntity;
import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.port.repository.BookingRepository;

@Repository
public class MongoDBBookingRepositoryImpl implements BookingRepository {

  @Autowired private MongoDBBookingDefaultRepository mongoDBMovieDefaultRepository;

  @Autowired private BookingToBookingEntityConverter bookingToBookingEntityConverter;
  @Autowired private BookingEntityToBookingConverter bookingEntityToBookingConverter;

  @Override
  public Booking create(final Booking booking) {
    final BookingEntity entity = bookingToBookingEntityConverter.convert(booking);
    final BookingEntity entityResult = mongoDBMovieDefaultRepository.insert(entity);
    return bookingEntityToBookingConverter.convert(entityResult);
  }

  @Override
  public Booking getById(final String bookingId) throws Exception {
    final Optional<BookingEntity> entityResult = mongoDBMovieDefaultRepository.findById(bookingId);
    if (entityResult.isPresent()) {
      return bookingEntityToBookingConverter.convert(entityResult.get());
    } else {
      throw new Exception("Booking with id " + bookingId + " not found");
    }
  }

  @Override
  public Booking update(final Booking booking) {
    final BookingEntity entity = bookingToBookingEntityConverter.convert(booking);
    final BookingEntity entityResult = mongoDBMovieDefaultRepository.save(entity);
    return bookingEntityToBookingConverter.convert(entityResult);
  }
}
