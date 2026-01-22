package com.example.Event.Management.System.Config;

import com.example.Event.Management.System.Entity.User;
import com.example.Event.Management.System.Repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: " + email));

        // Normalize DB role: Role_Admin → ROLE_ADMIN
        String role = user.getRole()
                .toUpperCase()
                .replace("ROLE_", "");

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities("ROLE_" + role) // ROLE_ADMIN
                .build();
    }
}
