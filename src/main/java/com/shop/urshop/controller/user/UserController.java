package com.shop.urshop.controller.user;

import com.shop.urshop.controller.BaseController;
import com.shop.urshop.entity.User;
import com.shop.urshop.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        final List<GetAllUserResponse> data=GetAllUserResponse.fromUsers(userService.getAll());
        return success(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdUserResponse(@PathVariable int id) {
        final GetByIdUserResponse data=GetByIdUserResponse.fromUser(userService.getById(id));
        return success(data);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateUserRequest createUserRequest) {
        final User user = User.builder()
                .userName(createUserRequest.userName())
                .email(createUserRequest.email())
                .password(createUserRequest.password())
                //.password(passwordEncoder.encode(createUserRequest.password()))
                .creationDate(String.valueOf(LocalDate.now()))
                .build();
        this.userService.add(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody final UpdateUserRequest updateUserRequest) {
        User user =User.builder()
                .id(updateUserRequest.id())
                .userName(updateUserRequest.userName())
                .email(updateUserRequest.email())
                .build();
        this.userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.userService.delete(id);
    }

    @PostMapping("/changePassword")
    public void changePassword(@RequestHeader("Authorization") String jwtToken, @RequestBody final ResetPswrdRequest resetPswrdRequest) {
        this.userService.changePassword(resetPswrdRequest.getNewPassword(),jwtToken);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        return userService.authenticate(authRequest);
    }

}
