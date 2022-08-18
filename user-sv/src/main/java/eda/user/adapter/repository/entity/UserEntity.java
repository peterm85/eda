package eda.user.adapter.repository.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = UserEntity.DOCUMENT_COLLECTION_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity {

  public static final String DOCUMENT_COLLECTION_NAME = "users";

  @Id private String id;

  private String name;

  private String address;

  private Integer age;

  @CreatedDate private Instant auditCreationDate;
}
