package eda.videoclub.service.movie.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import eda.videoclub.service.movie.adapter.repository.MongoDBMovieDefaultRepository;
import eda.videoclub.service.movie.adapter.repository.MongoDBMovieRepositoryImpl;
import eda.videoclub.service.movie.adapter.repository.converter.MovieEntityToMovieConverter;
import eda.videoclub.service.movie.adapter.repository.converter.MovieToMovieEntityConverter;
import eda.videoclub.service.movie.adapter.repository.entity.MovieEntity;
import eda.videoclub.service.movie.domain.entity.Movie;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MongoDBMovieRepositoryImplTest {

  @InjectMocks MongoDBMovieRepositoryImpl mongoDBMovieRepositoryImpl;

  @Mock private MongoDBMovieDefaultRepository mongoDBMovieDefaultRepository;
  @Mock private MovieEntityToMovieConverter movieEntityToMovieConverter;
  @Mock private MovieToMovieEntityConverter movieToMovieEntityConverter;

  @Test
  void insertTest() {

    // Given
    final Movie input =
        Movie.builder()
            .imdbId("tt0120737")
            .name("The Lord of the Rings - The Fellowship of the Ring")
            .stock(3)
            .build();

    final MovieEntity entity =
        MovieEntity.builder()
            .id("62fc96faced333564842f302")
            .imdbId("tt0120737")
            .name("The Lord of the Rings - The Fellowship of the Ring")
            .stock(3)
            .build();

    // When
    Mockito.when(mongoDBMovieDefaultRepository.insert(Mockito.any(MovieEntity.class)))
        .thenReturn(entity);

    Mockito.when(movieToMovieEntityConverter.convert(input)).thenReturn(entity);
    Mockito.when(movieEntityToMovieConverter.convert(entity)).thenReturn(input);

    final Movie result = mongoDBMovieRepositoryImpl.create(input);

    // Then
    assertNotNull(result);
  }
}
