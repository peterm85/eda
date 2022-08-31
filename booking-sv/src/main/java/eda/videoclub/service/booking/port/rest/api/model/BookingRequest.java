package eda.videoclub.service.booking.port.rest.api.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
  @ApiModelProperty(notes = "Movie identification", example = "1234567890", required = true)
  @NotEmpty
  private String imdbId;

  @ApiModelProperty(
      notes = "User identification name",
      example = "62fe1a48df883b786b2eaf08",
      required = true)
  @NotEmpty
  private String userId;
}
