package eda.videoclub.messaging.message;

public enum RejectionReasonEnum {
  USER_NOT_FOUND,
  MOVIE_NOT_FOUND,
  MOVIE_NOT_AVAILABLE,
  UNKNOWN_ERROR;

  public static RejectionReasonEnum fromString(final String value) {
    for (final RejectionReasonEnum item : values()) {
      if (item.name().equalsIgnoreCase(value)) {
        return item;
      }
    }
    return null;
  }
}
