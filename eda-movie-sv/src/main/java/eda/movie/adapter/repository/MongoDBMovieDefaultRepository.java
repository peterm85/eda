package eda.movie.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eda.movie.adapter.repository.entity.MovieEntity;

public interface MongoDBMovieDefaultRepository extends MongoRepository<MovieEntity, String> {}
