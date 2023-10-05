package com.shop.urshop.user;

import com.shop.urshop.controller.user.AuthRequest;
import com.shop.urshop.entity.User;
import com.shop.urshop.exception.BusinessException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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

    @Override
    public void changePassword(String newPassword,String jwtToken) {
//        String token = jwtToken.replace("Bearer ", "");
//        Jwt jwt = jwtDecoder.decode(token);
//        User user = jwtTokenService.getUser(jwt);
//        if(userRepository.existsById((int) user.getId())){
//            User user1=User.builder()
//                    .id(user.getId())
//                    .name(user.getName())
//                    .email(user.getEmail())
//                    .password(passwordEncoder.encode(newPassword))
//                    .creationDate(user.getCreationDate())
//                    .authority(user.getAuthority())
//                    .build();
//            userRepository.save(user1);
//        }else {
//            throw new RuntimeException("user bulunamadı");
//        }
    }

    @Override
    public String authenticate(AuthRequest authRequest) {
//        Authentication authentication =
//                authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                authRequest.getUsername(), authRequest.getPassword()));
//        var user = userRepository.findByName(authRequest.getUsername());
//        if (authentication.isAuthenticated()) {
//            return jwtTokenService.createToken(user);
//        } else {
//            throw new UsernameNotFoundException("invalid user request !");
//        }
        return null;
    }
}
