package com.shop.urshop.user;

import com.shop.urshop.entity.User;
import com.shop.urshop.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int userId) {
    return userRepository.findById(userId).orElseThrow(() -> new BusinessException("User is not found!"));
    }

    @Override
    public void add(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void update(User user) {
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
        }else {
            throw new RuntimeException("user bulunamadı");
        }
    }

    //resetpassword

    @Override
    public void delete(int userId) {
        this.userRepository.deleteById(userId);
    }
}
