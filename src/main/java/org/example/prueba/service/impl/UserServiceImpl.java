package org.example.prueba.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.prueba.domain.entity.User;
import org.example.prueba.dto.UserRequestDTO;
import org.example.prueba.dto.UserResponseDTO;
import org.example.prueba.mapper.UserMapper;
import org.example.prueba.repository.UserRepository;
import org.example.prueba.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {

        if (repository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email already exists");
        }

        User user = mapper.toEntity(dto);
        return mapper.toDto(repository.save(user));
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public UserResponseDTO findById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapper.toDto(user);
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.name());
        user.setEmail(dto.email());

        return mapper.toDto(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

