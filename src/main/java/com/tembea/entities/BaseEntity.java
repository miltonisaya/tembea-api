package com.tembea.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "uuid")
  private UUID uuid;

}
