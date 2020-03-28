package com.example.newsblog.services;

import com.example.newsblog.exeptions.AuthEx;
import com.example.newsblog.models.User;
import com.example.newsblog.repositiries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class UserService {
    private UserRepository userRepository;

    private Map<String, User> auth;
    private Map<Long, String> tokens;

    @Autowired
    public UserService(UserRepository userRepository, Map<String, User> auth, Map<Long, String> tokens) {
        this.userRepository = userRepository;
        this.auth = auth;
        this.tokens = tokens;
    }

    public UserService() {
    }

    public void addUser(User newUser){
        userRepository.save(newUser);
    }

    public String auth(User user) {
        if (tokens.containsKey(user.getId())) throw new AuthEx();
        String login = user.getLogin();
        String password = user.getPassword();

        if (auth.containsKey(login)) {
            if (auth.get(login).getPassword().equals(password)) {
                String token = Integer.toString(new Random().nextInt());
                tokens.put(auth.get(login).getId(), token);
                return token;
            }
        }
        return null;
    }

    public boolean logIn(String token) {return tokens.containsValue(token);}

}


