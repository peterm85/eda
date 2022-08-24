package eda.videoclub.service.user.adapter.rest.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eda.videoclub.service.user.adapter.rest.converter.UserRequestToUserConverter;
import eda.videoclub.service.user.adapter.rest.converter.UserToUserResponseConverter;
import eda.videoclub.service.user.domain.entity.User;
import eda.videoclub.service.user.port.rest.UserController;
import eda.videoclub.service.user.port.rest.api.model.UserRequest;
import eda.videoclub.service.user.port.rest.api.model.UserResponse;
import eda.videoclub.service.user.service.UserService;

@RequestMapping("/videoclub")
@RestController
public class UserControllerImpl implements UserController {

  private static final String SLASH = "/";
  private static final String MOVIE_PATH = SLASH + "user";

  @Autowired private UserService userService;

  @Autowired private UserRequestToUserConverter userRequestToMovieConverter;
  @Autowired private UserToUserResponseConverter userToMovieResponseConverter;

  @Override
  @PostMapping(value = MOVIE_PATH)
  public ResponseEntity<UserResponse> create(@Valid @NotNull final UserRequest request) {

    final User user = userRequestToMovieConverter.convert(request);
    final UserResponse response =
        userToMovieResponseConverter.convert(userService.createUser(user));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
