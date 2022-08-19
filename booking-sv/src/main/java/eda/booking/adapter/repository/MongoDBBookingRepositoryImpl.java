package eda.booking.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eda.booking.adapter.repository.converter.BookingEntityToBookingConverter;
import eda.booking.adapter.repository.converter.BookingToBookingEntityConverter;
import eda.booking.adapter.repository.entity.BookingEntity;
import eda.booking.domain.entity.Booking;
import eda.booking.port.repository.BookingRepository;

@Repository
public class MongoDBBookingRepositoryImpl implements BookingRepository {

  @Autowired private MongoDBBookingDefaultRepository mongoDBMovieDefaultRepository;

  @Autowired private BookingToBookingEntityConverter movieToMovieEntityConverter;
  @Autowired private BookingEntityToBookingConverter movieEntityToMovieConverter;

  @Override
  public Booking create(final Booking movie) {
    final BookingEntity entity = movieToMovieEntityConverter.convert(movie);
    final BookingEntity entityResult = mongoDBMovieDefaultRepository.insert(entity);
    return movieEntityToMovieConverter.convert(entityResult);
  }
}
