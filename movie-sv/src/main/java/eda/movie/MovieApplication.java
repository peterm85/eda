package eda.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MovieApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieApplication.class, args);
  }
}
