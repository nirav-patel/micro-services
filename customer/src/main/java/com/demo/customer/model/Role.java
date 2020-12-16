package com.demo.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ROLE")
public class Role {

  @Id
  @Column(name = "ROLE_ID", nullable = false)
  private String id;

  @Column(name = "ROLE_NAME", nullable = false, unique = true)
  private String name;

  @Column(name = "ROLE_CODE", nullable = false, unique = true)
  private String code;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Role role = (Role) o;

    return id.equals(role.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
