package com.tembea.i18n;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageKey {

  // User
  USER_CREATED("user.created"),
  USER_UPDATED("user.updated"),
  USER_DELETED("user.deleted"),
  USER_NOT_FOUND("user.not.found"),

  // Validation
  VALIDATION_FIRST_NAME_REQUIRED("validation.firstName.required"),
  VALIDATION_LAST_NAME_REQUIRED("validation.lastName.required"),
  VALIDATION_EMAIL_REQUIRED("validation.email.required"),
  VALIDATION_EMAIL_INVALID("validation.email.invalid"),
  VALIDATION_MOBILE_REQUIRED("validation.mobile.required"),
  VALIDATION_SEX_REQUIRED("validation.sex.required"),
  VALIDATION_USER_TYPE_REQUIRED("validation.userType.required"),
  VALIDATION_PASSWORD_REQUIRED("validation.password.required"),
  VALIDATION_PASSWORD_SIZE("validation.password.size");

  private final String key;
}
