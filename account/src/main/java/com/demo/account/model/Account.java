package com.demo.account.model;

import com.demo.account.constants.HibernateConstants;

import org.hibernate.annotations.Type;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNT")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "account_type")
  private String accountType;

  @Type(type = HibernateConstants.DATE_TYPE)
  @Column(name = "open_date")
  private ZonedDateTime openDate;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id", updatable = false, nullable = false)
  private Customer customer;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "branch")
  private String branch;

  @Column(name = "minor_indicator")
  private String minorIndicator;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Account account = (Account) o;

    return id.equals(account.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
