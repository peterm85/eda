package eda.videoclub.service.movie.exception;

public class MovieNotAvailableException extends Exception {

  private static final long serialVersionUID = -8456444960869651991L;

  public MovieNotAvailableException(String message) {
    super(message);
  }
}
