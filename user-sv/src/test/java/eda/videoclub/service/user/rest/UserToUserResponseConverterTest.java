package eda.videoclub.service.user.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.videoclub.service.user.adapter.rest.converter.UserToUserResponseConverter;
import eda.videoclub.service.user.domain.entity.User;
import eda.videoclub.service.user.port.rest.api.model.UserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserToUserResponseConverterTest {

  private UserToUserResponseConverter converter = new UserToUserResponseConverter();

  @Test
  void convertTest() {
    // given
    final User source =
        User.builder()
            .id("62fc96faced333564842f302")
            .name("Jose Luis")
            .address("Montequinto street, 15th")
            .age(25)
            .build();
    // when
    final UserResponse result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getId(), source.getId());
    assertEquals(result.getName(), source.getName());
    assertEquals(result.getAddress(), source.getAddress());
    assertEquals(result.getAge(), source.getAge());
  }
}
