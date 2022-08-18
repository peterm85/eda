package eda.user.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.user.adapter.rest.converter.UserRequestToUserConverter;
import eda.user.domain.entity.User;
import eda.user.port.rest.api.model.UserRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserRequestToUserConverterTest {

  private UserRequestToUserConverter converter = new UserRequestToUserConverter();

  @Test
  void convertTest() {
    // given
    final UserRequest source =
        UserRequest.builder().name("Jose Luis").address("Montequinto street, 15th").age(25).build();
    // when
    final User result = converter.convert(source);

    // then
    assertNotNull(result);
    assertEquals(result.getName(), source.getName());
    assertEquals(result.getAddress(), source.getAddress());
    assertEquals(result.getAge(), source.getAge());
  }
}
