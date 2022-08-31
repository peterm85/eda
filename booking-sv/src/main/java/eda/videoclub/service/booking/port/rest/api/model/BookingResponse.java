package eda.videoclub.service.booking.port.rest.api.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import eda.videoclub.service.booking.domain.entity.BookingStatusVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponse {

  private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  private static final String TIMEZONE = "UTC";

  @ApiModelProperty(
      notes = "Internal identification",
      example = "62fc96faced333564842f303",
      required = true)
  private String id;

  @ApiModelProperty(notes = "Movie identification", example = "1234567890", required = true)
  private String imdbId;

  @ApiModelProperty(
      notes = "User identification",
      example = "62fe1a48df883b786b2eaf08",
      required = true)
  private String userId;

  @ApiModelProperty(notes = "Booking status", example = "CREATED", required = true)
  private BookingStatusVO status;

  @ApiModelProperty(notes = "Last update datetime", example = "2022-09-10", required = true)
  @JsonFormat(pattern = DATE_FORMAT, timezone = TIMEZONE)
  private Instant lastUpdateDatetime;
}
