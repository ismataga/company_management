package com.ismataga.company_management.controller;
import com.ismataga.company_management.dto.UserDTO;
import com.ismataga.company_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
      return   userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("{id}")
    public void updateUserById(@PathVariable Long id,@RequestBody UserDTO userDTO){
        userService.updateUserById(id, userDTO);
    }
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }





}
