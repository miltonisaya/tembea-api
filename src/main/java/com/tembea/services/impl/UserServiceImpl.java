package com.tembea.services.impl;

import com.tembea.controllers.exceptions.ResourceNotFoundException;
import com.tembea.dtos.request.UserRequestDto;
import com.tembea.dtos.response.UserResponseDto;
import com.tembea.entities.User;
import com.tembea.i18n.MessageKey;
import com.tembea.i18n.MessageService;
import com.tembea.repositories.UserRepository;
import com.tembea.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final MessageService messageService;

  @Override
  public Page<UserResponseDto> findAll(Specification<User> spec, Pageable pageable) {
    return userRepository.findAll(spec, pageable).map(UserResponseDto::new);
  }

  @Override
  public UserResponseDto findByUuid(String uuid) {
    return userRepository.findByUuid(uuid)
        .map(UserResponseDto::new)
        .orElseThrow(() -> new ResourceNotFoundException(
            messageService.get(MessageKey.USER_NOT_FOUND, uuid)));
  }

  @Override
  public UserResponseDto create(UserRequestDto dto) {
    return new UserResponseDto(userRepository.save(toEntity(dto)));
  }

  @Override
  public UserResponseDto update(String uuid, UserRequestDto dto) {
    User user = userRepository.findByUuid(uuid)
        .orElseThrow(() -> new ResourceNotFoundException(
            messageService.get(MessageKey.USER_NOT_FOUND, uuid)));

    user.setFirstName(dto.getFirstName());
    user.setMiddleName(dto.getMiddleName());
    user.setLastName(dto.getLastName());
    user.setEmail(dto.getEmail());
    user.setMobile(dto.getMobile());
    user.setSex(dto.getSex());
    user.setUserType(dto.getUserType());
    user.setPassword(dto.getPassword());

    return new UserResponseDto(userRepository.save(user));
  }

  @Override
  public void delete(String uuid) {
    User user = userRepository.findByUuid(uuid)
        .orElseThrow(() -> new ResourceNotFoundException(
            messageService.get(MessageKey.USER_NOT_FOUND, uuid)));
    userRepository.delete(user);
  }

  private User toEntity(UserRequestDto dto) {
    User user = new User();
    user.setFirstName(dto.getFirstName());
    user.setMiddleName(dto.getMiddleName());
    user.setLastName(dto.getLastName());
    user.setEmail(dto.getEmail());
    user.setMobile(dto.getMobile());
    user.setSex(dto.getSex());
    user.setUserType(dto.getUserType());
    user.setPassword(dto.getPassword());
    return user;
  }
}
