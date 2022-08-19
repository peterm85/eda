package eda.booking.port.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import eda.booking.port.rest.api.model.BookingRequest;
import eda.booking.port.rest.api.model.BookingResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(
    value = "Entrypoint to booking movies",
    produces = "application/json",
    consumes = "application/json")
public interface BookingController {

  @ApiOperation(value = "Endpoint for booking a movie")
  @ApiResponses({@ApiResponse(code = 201, message = "Created")})
  ResponseEntity<BookingResponse> bookMovie(@Valid @RequestBody @NotNull BookingRequest request);
}
