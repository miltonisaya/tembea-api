package com.tembea.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserTypeEnum {
  TRAVELER,
  OPERATOR;

  @JsonCreator
  public static UserTypeEnum fromValue(String value) {
    if (value == null) return null;
    for (UserTypeEnum e : values()) {
      if (e.name().equalsIgnoreCase(value.trim())) {
        return e;
      }
    }
    throw new IllegalArgumentException("Invalid userType: '" + value + "'. Accepted values: TRAVELER, OPERATOR");
  }
}
