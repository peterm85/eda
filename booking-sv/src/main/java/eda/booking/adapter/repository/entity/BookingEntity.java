package eda.booking.adapter.repository.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import eda.booking.domain.entity.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = BookingEntity.DOCUMENT_COLLECTION_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingEntity {

  public static final String DOCUMENT_COLLECTION_NAME = "bookings";

  @Id private String id;

  private String imdbId;

  private String userId;

  private BookingStatus status;

  @LastModifiedDate private Instant lastUpdateDatetime;

  @CreatedDate private Instant auditCreationDate;
}
