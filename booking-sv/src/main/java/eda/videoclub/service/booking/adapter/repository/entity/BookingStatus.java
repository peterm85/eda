package eda.videoclub.service.booking.adapter.repository.entity;

public enum BookingStatus {
  CREATED,
  CONFIRMED,
  CANCELLED;

  public static BookingStatus fromString(final String value) {
    for (final BookingStatus item : values()) {
      if (item.name().equalsIgnoreCase(value)) {
        return item;
      }
    }
    return null;
  }
}
