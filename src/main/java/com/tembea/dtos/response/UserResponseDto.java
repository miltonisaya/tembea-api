package com.tembea.dtos.response;

import com.tembea.enums.SexEnum;
import com.tembea.enums.UserTypeEnum;
import com.tembea.entities.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

  private final String uuid;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String email;
  private final String mobile;
  private final SexEnum sex;
  private final UserTypeEnum userType;

  public UserResponseDto(User user) {
    this.uuid = user.getUuid();
    this.firstName = user.getFirstName();
    this.middleName = user.getMiddleName();
    this.lastName = user.getLastName();
    this.email = user.getEmail();
    this.mobile = user.getMobile();
    this.sex = user.getSex();
    this.userType = user.getUserType();
  }
}
