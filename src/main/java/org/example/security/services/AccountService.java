package org.example.security.services;

import org.example.security.entities.Role;
import org.example.security.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    User createUser(String username, String password,String email,String confimPassword);

    Role createRole(String role);

    void addRoleToUser(String username, String role);

    void removeRoleFromUser(String username, String role);

    User loadUserByUsername(String username);

}
