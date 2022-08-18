package eda.user.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.user.adapter.repository.converter.UserToUserEntityConverter;
import eda.user.adapter.repository.entity.UserEntity;
import eda.user.domain.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserToUserEntityConverterTest {

  private UserToUserEntityConverter converter = new UserToUserEntityConverter();

  @Test
  void convertTest() {
    // given
    final User source =
        User.builder().name("Jose Luis").address("Montequinto street, 15th").age(25).build();
    // when
    final UserEntity result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getName(), source.getName());
    assertEquals(result.getAddress(), source.getAddress());
    assertEquals(result.getAge(), source.getAge());
  }
}
