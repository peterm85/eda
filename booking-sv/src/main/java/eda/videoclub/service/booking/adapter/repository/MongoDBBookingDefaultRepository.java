package eda.videoclub.service.booking.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eda.videoclub.service.booking.adapter.repository.entity.BookingEntity;

public interface MongoDBBookingDefaultRepository extends MongoRepository<BookingEntity, String> {}
