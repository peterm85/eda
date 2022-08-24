package eda.videoclub.service.user.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eda.videoclub.service.user.adapter.repository.entity.UserEntity;

public interface MongoDBUserDefaultRepository extends MongoRepository<UserEntity, String> {}
