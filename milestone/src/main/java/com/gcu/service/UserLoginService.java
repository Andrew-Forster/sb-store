package com.gcu.service;

import com.gcu.data.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    private final UsersRepository usersRepository;

    public UserLoginService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean authenticate(String username, String password) {
        return usersRepository.authenticate(username, password);
    }
}