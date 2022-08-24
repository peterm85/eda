package eda.videoclub.service.user.port.repository;

import eda.videoclub.service.user.domain.entity.User;

public interface UserRepository {

  User create(User user);

  Boolean existUser(String id);
}
