package com.example.Event.Management.System.Service;



import com.example.Event.Management.System.Entity.User;

public interface UserService {

    User findByEmail(String email);
}

