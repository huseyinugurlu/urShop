package com.shop.urshop.user;

import com.shop.urshop.controller.auth.AuthRequest;
import com.shop.urshop.controller.auth.AuthResponse;
import com.shop.urshop.entity.User;
import com.shop.urshop.exception.BusinessException;
import com.shop.urshop.security.Authority;
import com.shop.urshop.security.SecurityUser;
import com.shop.urshop.security.token.JwtTokenService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
  private final UserRepository userRepository;
  private final JwtDecoder jwtDecoder;
  private final JwtTokenService jwtTokenService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public UserManager(
      UserRepository userRepository,
      JwtDecoder jwtDecoder,
      JwtTokenService jwtTokenService,
      PasswordEncoder passwordEncoder,
      AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.jwtDecoder = jwtDecoder;
    this.jwtTokenService = jwtTokenService;
    this.passwordEncoder = passwordEncoder;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public User getById(int userId) {
    return userRepository
        .findById(userId)
        .orElseThrow(() -> new BusinessException("User is not found!"));
  }

  @Override
  public void add(User user) {
    this.userRepository.save(user);
  }

  @Override
  public void update(User user) {
    if (userRepository.existsById(user.getId())) {
      userRepository.save(user);
    } else {
      throw new RuntimeException("user bulunamadı");
    }
  }

  @Override
  public void delete(int userId) {
    this.userRepository.deleteById(userId);
  }

  @Override
  public void changePassword(String newPassword, String jwtToken) {
    String token = jwtToken.replace("Bearer ", "");
    Jwt jwt = jwtDecoder.decode(token);
    User user = jwtTokenService.getUser(jwt);
    if (userRepository.existsById(user.getId())) {
      User user1 =
          User.builder()
              .id(user.getId())
              .name(user.getName())
              .email(user.getEmail())
              .password(passwordEncoder.encode(newPassword))
              .creationDate(user.getCreationDate())
              .authority(user.getAuthority())
              .build();
      userRepository.save(user1);
    } else {
      throw new RuntimeException("user bulunamadı");
    }
  }

  @Override
  public AuthResponse authenticate(AuthRequest authRequest) {
    final String token;
    Authority authority = Authority.ROLE_CUSTOMER;
    var user = userRepository.findByName(authRequest.getUsername());
    if (Objects.nonNull(user)) {
      if (Authority.ROLE_CASHIER.getAuthority().equals(user.getAuthority())) {
        authority = Authority.ROLE_CASHIER;
      }
      final SecurityUser.SecurityUserBuilder securityUserBuilder =
          SecurityUser.builder()
              .id(user.getId())
              .name(user.getName())
              .email(user.getEmail())
              .authority(authority)
              .creationDate(user.getCreationDate());
      token = jwtTokenService.createToken(securityUserBuilder.build());
    } else {
      throw new UsernameNotFoundException("invalid user request !");
    }
    return new AuthResponse(token, authority.getAuthority());
  }
}
