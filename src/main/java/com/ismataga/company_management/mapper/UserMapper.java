package com.ismataga.company_management.mapper;


import com.ismataga.company_management.dto.UserDTO;
import com.ismataga.company_management.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

    User mapToUserEntity(UserDTO userDTO);

    List<UserDTO> mapToUserDTOList(List<User> user);

//    @Mapping(target="company.activeDate",expression = "java(duration.getYears())")
    UserDTO mapToUserDTO(User user);
}
