package eda.user.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import eda.user.adapter.rest.controller.UserControllerImpl;
import eda.user.adapter.rest.converter.UserRequestToUserConverter;
import eda.user.adapter.rest.converter.UserToUserResponseConverter;
import eda.user.domain.entity.User;
import eda.user.port.rest.api.model.UserRequest;
import eda.user.port.rest.api.model.UserResponse;
import eda.user.service.UserService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserControllerImplTest {

  @InjectMocks UserControllerImpl userControllerImpl;

  @Mock UserRequestToUserConverter userRequestToUserConverter;
  @Mock UserToUserResponseConverter userToUserResponseConverter;
  @Mock UserService userService;

  @Test
  void createUserTest() {

    // given
    final UserRequest request =
        UserRequest.builder().name("Jose Luis").address("Montequinto street, 15th").age(25).build();

    final User user =
        User.builder()
            .id("62fc96faced333564842f302")
            .name("Jose Luis")
            .address("Montequinto street, 15th")
            .age(25)
            .build();

    // when
    Mockito.when(userService.createUser(Mockito.any())).thenReturn(user);

    final ResponseEntity<UserResponse> response = userControllerImpl.create(request);

    // then
    assertNotNull(response);
  }
}
