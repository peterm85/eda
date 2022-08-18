package eda.user.port.repository;

import eda.user.domain.entity.User;

public interface UserRepository {

  User create(User user);
}
