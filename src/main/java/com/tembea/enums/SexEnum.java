package com.tembea.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SexEnum {
  MALE, FEMALE;

  @JsonCreator
  public static SexEnum fromValue(String value) {
    if (value == null) return null;
    for (SexEnum e : values()) {
      if (e.name().equalsIgnoreCase(value.trim())) {
        return e;
      }
    }
    throw new IllegalArgumentException("Invalid sex: '" + value + "'. Accepted values: MALE, FEMALE");
  }
}
