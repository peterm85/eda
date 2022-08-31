package eda.videoclub.service.booking.domain.entity;

public enum BookingStatusVO {
  CREATED,
  CONFIRMED,
  CANCELLED;

  public static BookingStatusVO fromString(final String value) {
    for (final BookingStatusVO item : values()) {
      if (item.name().equalsIgnoreCase(value)) {
        return item;
      }
    }
    return null;
  }
}
