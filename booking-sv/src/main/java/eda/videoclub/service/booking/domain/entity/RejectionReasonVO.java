package eda.videoclub.service.booking.domain.entity;

public enum RejectionReasonVO {
  USER_NOT_FOUND,
  MOVIE_NOT_FOUND,
  MOVIE_NOT_AVAILABLE,
  UNKNOWN_ERROR;

  public static RejectionReasonVO fromString(final String value) {
    for (final RejectionReasonVO item : values()) {
      if (item.name().equalsIgnoreCase(value)) {
        return item;
      }
    }
    return null;
  }
}
