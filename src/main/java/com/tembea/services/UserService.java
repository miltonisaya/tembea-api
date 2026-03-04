package com.tembea.services;

import com.tembea.dtos.request.UserRequestDto;
import com.tembea.dtos.response.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import com.tembea.entities.User;

public interface UserService {

  Page<UserResponseDto> findAll(Specification<User> spec, Pageable pageable);

  UserResponseDto findByUuid(String uuid);

  UserResponseDto create(UserRequestDto dto);

  UserResponseDto update(String uuid, UserRequestDto dto);

  void delete(String uuid);
}
