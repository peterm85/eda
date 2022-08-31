package eda.videoclub.service.booking.repository;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.videoclub.service.booking.adapter.repository.MongoDBBookingDefaultRepository;
import eda.videoclub.service.booking.adapter.repository.MongoDBBookingRepositoryImpl;
import eda.videoclub.service.booking.adapter.repository.converter.BookingEntityToBookingConverter;
import eda.videoclub.service.booking.adapter.repository.converter.BookingToBookingEntityConverter;
import eda.videoclub.service.booking.adapter.repository.entity.BookingEntity;
import eda.videoclub.service.booking.domain.entity.Booking;
import eda.videoclub.service.booking.domain.entity.BookingStatus;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MongoDBBookingRepositoryImplTest {

  @InjectMocks MongoDBBookingRepositoryImpl mongoDBBookingRepositoryImpl;

  @Mock private MongoDBBookingDefaultRepository mongoDBBookingDefaultRepository;
  @Mock private BookingEntityToBookingConverter bookingEntityToBookingConverter;
  @Mock private BookingToBookingEntityConverter bookingToBookingEntityConverter;

  @Test
  void insertTest() {

    // Given
    final Booking input =
        Booking.builder()
            .imdbId("tt0120737")
            .userId("62fe1a48df883b786b2eaf0")
            .status(BookingStatus.CREATED)
            .build();

    final BookingEntity entity =
        BookingEntity.builder()
            .id("62fc96faced333564842f302")
            .imdbId("tt0120737")
            .userId("62fe1a48df883b786b2eaf0")
            .status(BookingStatus.CREATED)
            .lastUpdateDatetime(Instant.now())
            .build();

    // When
    Mockito.when(mongoDBBookingDefaultRepository.insert(Mockito.any(BookingEntity.class)))
        .thenReturn(entity);

    Mockito.when(bookingToBookingEntityConverter.convert(input)).thenReturn(entity);
    Mockito.when(bookingEntityToBookingConverter.convert(entity)).thenReturn(input);

    final Booking result = mongoDBBookingRepositoryImpl.create(input);

    // Then
    assertNotNull(result);
  }
}
