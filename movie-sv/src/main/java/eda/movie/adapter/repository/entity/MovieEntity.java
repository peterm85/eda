package eda.movie.adapter.repository.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = MovieEntity.DOCUMENT_COLLECTION_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieEntity {

  public static final String DOCUMENT_COLLECTION_NAME = "movies";

  @Id private String id;

  @Indexed(unique = true)
  private String imdbId;

  private String name;

  private Integer stock;

  @CreatedDate private Instant auditCreationDate;
}
