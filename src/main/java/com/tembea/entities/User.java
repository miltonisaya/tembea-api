package com.tembea.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tembea.enums.SexEnum;
import com.tembea.enums.UserTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "User")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "mobile")
  private String mobile;

  @Enumerated(EnumType.STRING)
  @Column(name = "sex")
  private SexEnum sex;

  @Column(name = "user_type")
  @Enumerated(EnumType.STRING)
  private UserTypeEnum userType;

  @Column(name = "password")
  @JsonIgnore
  private String password;
}
