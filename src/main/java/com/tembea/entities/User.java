package com.tembea.entities;

import com.tembea.enums.SexEnum;
import com.tembea.enums.UserTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class User {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "mobile")
  private String mobile;

  @Enumerated(EnumType.STRING)
  @Column(name = "sex")
  private SexEnum sex;

  @Column(name = "user_type")
  @Enumerated(EnumType.STRING)
  private UserTypeEnum userType;
}
