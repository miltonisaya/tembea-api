package com.tembea.dtos.request;

import com.tembea.enums.SexEnum;
import com.tembea.enums.UserTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

  @NotBlank(message = "{validation.firstName.required}")
  private String firstName;

  private String middleName;

  @NotBlank(message = "{validation.lastName.required}")
  private String lastName;

  @NotBlank(message = "{validation.email.required}")
  @Email(message = "{validation.email.invalid}")
  private String email;

  @NotBlank(message = "{validation.mobile.required}")
  private String mobile;

  @NotNull(message = "{validation.sex.required}")
  private SexEnum sex;

  @NotNull(message = "{validation.userType.required}")
  private UserTypeEnum accountType;

  @NotBlank(message = "{validation.password.required}")
  @Size(min = 8, message = "{validation.password.size}")
  private String password;

  @NotBlank(message = "{validation.password.required}")
  @Size(min = 8, message = "{validation.password.size}")
  private String confirmPassword;
}
