package eda.movie.port.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import eda.movie.port.rest.api.model.MovieRequest;
import eda.movie.port.rest.api.model.MovieResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
    value = "Entrypoint to manage films",
    produces = "application/json",
    consumes = "application/json")
public interface MovieController {

  @ApiOperation(value = "Create film endpoint")
  @ApiResponses({@ApiResponse(code = 201, message = "Created")})
  ResponseEntity<MovieResponse> create(@Valid @RequestBody @NotNull final MovieRequest request);
}
