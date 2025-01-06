package com.github.karynad.service;

import com.github.karynad.model.Role;
import com.github.karynad.model.User;
import com.github.karynad.model.dto.UserDTO;
import com.github.karynad.repository.RoleRepository;
import com.github.karynad.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RabbitTemplate rabbitTemplate;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, RabbitTemplate rabbitTemplate) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public User register(UserDTO userDTO) {
        String hashedPassword = passwordEncoder.encode(userDTO.getRawPassword());

        User user = new User();
        user.setUsername(userDTO.getUsername());
        Role role = roleRepository.findByName("USER");
        if (role == null) {
            throw new IllegalStateException("Role 'ADMIN' does not exist in the database");
        }
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPasswordHash(hashedPassword);
        User savedUser = userRepository.save(user);

        // RabbitMQ
        for(int i=0; i<10; i++) {
            rabbitTemplate.convertAndSend("user-exchange", "user.created", savedUser.getId() + "  " + savedUser.getUsername() + i);
        }

        return savedUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
