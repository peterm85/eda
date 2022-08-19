package eda.booking.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eda.booking.adapter.repository.entity.BookingEntity;

public interface MongoDBBookingDefaultRepository extends MongoRepository<BookingEntity, String> {}
