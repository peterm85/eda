package eda.videoclub.service.user.port.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import eda.videoclub.service.user.port.rest.api.model.UserRequest;
import eda.videoclub.service.user.port.rest.api.model.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
    value = "Entrypoint to manage users",
    produces = "application/json",
    consumes = "application/json")
public interface UserController {

  @ApiOperation(value = "Create user endpoint")
  @ApiResponses({@ApiResponse(code = 201, message = "Created")})
  ResponseEntity<UserResponse> create(@Valid @RequestBody @NotNull UserRequest request);
}
