package com.ismataga.company_management.service;


import com.ismataga.company_management.dto.UserDTO;


import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);

    void updateUserById(Long id, UserDTO userDTO);

    void deleteUser(Long id);


}
