package com.javaschool.ev.mapper;

import com.javaschool.ev.domain.User;
import com.javaschool.ev.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getUserId());
        user.setFirstname(userDTO.getFirstName());
        user.setLastname(userDTO.getLastName());
        user.setBirthDate(userDTO.getBirthDate());
        return user;
    }

    public UserDTO convertToDto (User user){
        UserDTO dto = new UserDTO();
        dto.setFirstName(user.getFirstname());
        dto.setLastName(user.getLastname());
        dto.setBirthDate(user.getBirthdate());
        return dto;
    }

}
