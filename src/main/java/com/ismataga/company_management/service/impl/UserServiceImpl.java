package com.ismataga.company_management.service.impl;


import com.ismataga.company_management.dto.UserDTO;
import com.ismataga.company_management.entity.User;
import com.ismataga.company_management.exceptions.UserNotFoundException;
import com.ismataga.company_management.mapper.UserMapper;

import com.ismataga.company_management.repository.UserRepository;
import com.ismataga.company_management.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper ;

    @Override
    public void createUser(UserDTO userDTO) {
        log.info("createUser().start");
        User user = userMapper.mapToUserEntity(userDTO);
        userRepository.save(user);
        log.info("createdToDo().end");
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("getAllUsers().start");
        List<User> users = userRepository.findAll();
        List<UserDTO> userResponses = userMapper.mapToUserDTOList(users);
        log.info("getAllUsers().end");
        return userResponses;
    }

    @Override
    public UserDTO getUserById(Long id) {
        log.info("getUserById().start id {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not founded by id " + id));
        log.info("getUserById().end id {} ", id);
        return userMapper.mapToUserDTO(user);
    }

    @Override
    public void updateUserById(Long id, UserDTO userDTO) {
        log.info("updateUserById().start id {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not founded by id " + id));
        if (userDTO.getFirstName() != null) {
            user.setFirstName(userDTO.getFirstName());
        }
        userRepository.save(user);
        log.info("updateUserById().end id {}", id);

    }

    @Override
    public void deleteUser(Long id) {
        log.info("deleteUserById().start id {}", id);
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not founded by id " + id));
        userRepository.deleteById(id);
        log.info("deleteUserById().end id {}", id);
    }


}
