package org.example.security.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.security.entities.Role;
import org.example.security.entities.User;
import org.example.security.repositories.RoleRepository;
import org.example.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService{

    /*
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

     */

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(String username, String password, String email, String confimPassword) {
        User user = userRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("EXIST");
        if(!password.equals(confimPassword)) throw new RuntimeException("ERROR");
        user = User.builder()
            .userId(UUID.randomUUID().toString())
            .username(username)
            .password(passwordEncoder.encode(password))
            .email(email)
            .build();
        return userRepository.save(user);
    }


    @Override
    public Role createRole(String role) {
        Role role1 = roleRepository.findById(role).orElse(null);
                role1 = Role.builder()
                .role(role)
                .build();

        return roleRepository.save(role1);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findById(role).orElse(null);

        user.getRoles().add(role1);
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        User user = userRepository.findByUsername(username);
        Role role1 = roleRepository.findById(role).orElse(null);

        user.getRoles().remove(role1);
    }

    @Override
    public User loadUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }


}
