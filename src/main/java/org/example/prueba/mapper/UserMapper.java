package org.example.prueba.mapper;

import org.example.prueba.domain.entity.User;
import org.example.prueba.dto.UserRequestDTO;
import org.example.prueba.dto.UserResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDTO dto);


    UserResponseDTO toDto(User entity);

    List<UserResponseDTO> toDtoList(List<User> users);
}

