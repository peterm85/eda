package eda.videoclub.service.movie.adapter.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eda.videoclub.service.movie.adapter.repository.entity.MovieEntity;

public interface MongoDBMovieDefaultRepository extends MongoRepository<MovieEntity, String> {
  List<MovieEntity> findByImdbId(String imdbId);
}
