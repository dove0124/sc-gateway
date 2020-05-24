package com.springboot.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.book.pojo.User;
import com.springboot.book.repository.UserRepository;
import com.springboot.book.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**** imports ****/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> getUser(Long id) {
        return userRepository.findById(id);
    }
    
    @Override
    public Mono<User> insertUser( User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        Mono<Void> result = userRepository.deleteById(id);
        return result;
    }

    @Override
    public Flux<User> findUsers(String userName, String note) {
        return userRepository.findByUserNameLikeAndNoteLike(userName, note);
    }

}
