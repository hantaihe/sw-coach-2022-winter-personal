package com.swcoaching.example1.user;

import com.swcoaching.example1.user.jpa.UserEntity;
import com.swcoaching.example1.user.jpa.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findByUsername(String username) {
    UserEntity userEntity = userRepository.findByUsername(username);
    return User.of(userEntity);
  }
}
