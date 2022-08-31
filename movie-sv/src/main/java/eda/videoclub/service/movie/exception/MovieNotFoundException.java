package eda.videoclub.service.movie.exception;

public class MovieNotFoundException extends Exception {

  private static final long serialVersionUID = 6255315253360500989L;

  public MovieNotFoundException(String message) {
    super(message);
  }
}
