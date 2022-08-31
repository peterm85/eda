package eda.videoclub.service.booking.adapter.repository.entity;

public enum RejectionReason {
  USER_NOT_FOUND,
  MOVIE_NOT_FOUND,
  MOVIE_NOT_AVAILABLE,
  UNKNOWN_ERROR;

  public static RejectionReason fromString(final String value) {
    for (final RejectionReason item : values()) {
      if (item.name().equalsIgnoreCase(value)) {
        return item;
      }
    }
    return null;
  }
}
