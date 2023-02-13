package com.service.books.Service;

import java.util.Optional;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.books.Entity.User;
import com.service.books.Repository.UserRepository;

@Service
@TransactionScoped
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User savUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findOneUser(Long userId) {
        Optional<User> tempUser = userRepository.findById(userId);

        if (!tempUser.isPresent()) {
            return null;
        }

        return userRepository.findById(userId).get();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
