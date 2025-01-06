package com.github.karynad.service;

import com.github.karynad.model.User;
import com.github.karynad.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    User register(UserDTO userDTO);

    List<User> findAll();
}
