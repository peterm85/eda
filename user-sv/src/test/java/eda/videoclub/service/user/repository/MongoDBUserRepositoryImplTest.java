package eda.videoclub.service.user.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.videoclub.service.user.adapter.repository.MongoDBUserDefaultRepository;
import eda.videoclub.service.user.adapter.repository.MongoDBUserRepositoryImpl;
import eda.videoclub.service.user.adapter.repository.converter.UserEntityToUserConverter;
import eda.videoclub.service.user.adapter.repository.converter.UserToUserEntityConverter;
import eda.videoclub.service.user.adapter.repository.entity.UserEntity;
import eda.videoclub.service.user.domain.entity.User;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MongoDBUserRepositoryImplTest {

  @InjectMocks MongoDBUserRepositoryImpl mongoDBUserRepositoryImpl;

  @Mock private MongoDBUserDefaultRepository mongoDBUserDefaultRepository;
  @Mock private UserEntityToUserConverter userEntityToUserConverter;
  @Mock private UserToUserEntityConverter userToUserEntityConverter;

  @Test
  void insertTest() {

    // Given
    final User input =
        User.builder()
            .id("62fc96faced333564842f302")
            .name("Jose Luis")
            .address("Montequinto street, 15th")
            .age(25)
            .build();

    final UserEntity entity =
        UserEntity.builder()
            .id("62fc96faced333564842f302")
            .name("Jose Luis")
            .address("Montequinto street, 15th")
            .age(25)
            .build();

    // When
    Mockito.when(mongoDBUserDefaultRepository.insert(Mockito.any(UserEntity.class)))
        .thenReturn(entity);

    Mockito.when(userToUserEntityConverter.convert(input)).thenReturn(entity);
    Mockito.when(userEntityToUserConverter.convert(entity)).thenReturn(input);

    final User result = mongoDBUserRepositoryImpl.create(input);

    // Then
    assertNotNull(result);
  }
}
