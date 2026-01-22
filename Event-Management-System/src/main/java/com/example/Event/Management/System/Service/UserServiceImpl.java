package com.example.Event.Management.System.Service;
import com.example.Event.Management.System.Entity.User;
import com.example.Event.Management.System.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + email));
    }

    public long countUsers() { return userRepository.count(); }

}

