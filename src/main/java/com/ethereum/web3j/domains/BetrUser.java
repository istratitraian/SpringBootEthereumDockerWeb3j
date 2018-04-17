package com.ethereum.web3j.domains;

import com.ethereum.web3j.domains.abs.AbstractDomainDateCreated;
import com.ethereum.web3j.domains.security.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;

/**
 * @author I.T.W764
 */
@Entity
@Table(name = "users")
public class BetrUser extends AbstractDomainDateCreated {

  private static final long serialVersionUID = 2L;
  @Column(name = "wm")
  private String walletMnemonics;
  @Column(name = "wid")
  private String walletId;
  @Column(name = "wprk")
  private String walletPrK;
  @Column(name = "wa")
  private String walletAddress;

//  private String username;
  @Column(name = "pass")
  private String encryptedPassword;
  @Column(name = "enabled")
  private Short enabled;
//  private Boolean enabled = true;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phoneNumber;
  @Column(name = "fails")
  private Integer failedLoginAttempts = 0;

  @JsonIgnore
//  @JoinTable(name = "users_x_authorities",
//          joinColumns = @JoinColumn(name = "user"),
//          inverseJoinColumns = @JoinColumn(name = "authority"))
//  @ManyToMany(fetch = FetchType.EAGER)
  @ManyToMany(mappedBy = "userSet")
  private Set<Authority> authorities = new HashSet<>();

  public BetrUser() {
  }

  public BetrUser(Integer id) {
    this.id = id;
  }

  public String getWalletAddress() {
    return walletAddress;
  }

  public void setWalletAddress(String walletAddress) {
    this.walletAddress = walletAddress;
  }

  public String getWalletId() {
    return walletId;
  }

  public void setWalletId(String walletId) {
    this.walletId = walletId;
  }

  public String getWalletPrK() {
    return walletPrK;
  }

  public void setWalletPrK(String walletPrK) {
    this.walletPrK = walletPrK;
  }

  public String getWalletMnemonic() {
    return walletMnemonics;
  }

  public void setWalletMnemonic(String walletMnemonics) {
    this.walletMnemonics = walletMnemonics;
  }

//  public String getUsername() {
//    return username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }
  public String getEncryptedPassword() {
    return encryptedPassword;
  }

  public void setEncryptedPassword(String encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
  }

  public String getWalletMnemonics() {
    return walletMnemonics;
  }

  public void setWalletMnemonics(String walletMnemonics) {
    this.walletMnemonics = walletMnemonics;
  }

  public Short getEnabled() {
    return enabled;
  }

//  public Boolean getEnabled() {
//    return enabled;
//  }
//
//  public void setEnabled(Boolean enabled) {
//    this.enabled = enabled;
//  }
  public void setEnabled(Short enabled) {
    this.enabled = enabled;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Integer getFailedLoginAttempts() {
    return failedLoginAttempts;
  }

  public void setFailedLoginAttempts(Integer failedLoginAttempts) {
    this.failedLoginAttempts = failedLoginAttempts;
  }

  public void addLoginFailAttempt() {
    failedLoginAttempts++;
  }

  public Set<Authority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Set<Authority> auth) {
    this.authorities = auth;
  }

  @Transient
  public void addAuthority(Authority auth) {
    this.authorities.add(auth);
//    auth.addBetrUser(this);
  }

  @Transient
  public void removeAuthority(Authority auth) {
    this.authorities.remove(auth);
//    auth.removeBetrUser(this);
  }

  @Override
  public String toString() {
    return "BetrUser{ ID=" + getId() + ", walletAddress=" + walletAddress + ", email=" + email + '}';
  }

}
