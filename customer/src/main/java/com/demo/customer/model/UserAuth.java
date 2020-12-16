package com.demo.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USER_AUTH")
public class UserAuth {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "USER_ID", updatable = false, nullable = false, unique = true)
  private Customer user;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ROLE_ID", updatable = false, nullable = false)
  private Role role;

  @Column(name = "PASSWD")
  private String passwd;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserAuth customer = (UserAuth) o;

    return id.equals(customer.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

}
