package com.example.Event.Management.System.Config;
import com.example.Event.Management.System.Entity.User;
import com.example.Event.Management.System.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository,
                                PasswordEncoder passwordEncoder) {

        return args -> {

            String adminEmail = "admin@gmail.com";

            // Check if admin already exists
            if (userRepository.findByEmail(adminEmail).isEmpty()) {

                User admin = new User();
                admin.setName("Admin");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode("admin")); // BCrypt
                admin.setRole("Role_Admin"); // matches your current setup

                userRepository.save(admin);

                System.out.println("✅ Default ADMIN created");
                System.out.println("📧 Email: admin@gmail.com");
                System.out.println("🔑 Password: admin");
            }
        };
    }
}

