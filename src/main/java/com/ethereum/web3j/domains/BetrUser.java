package com.ethereum.web3j.domains;

import com.ethereum.web3j.domains.abs.AbstractDomainDateCreated;
import com.ethereum.web3j.domains.security.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import org.springframework.data.annotation.Transient;

/**
 * @author I.T.W764
 */
//@Entity
//@Table(name = "betr_users")
public class BetrUser extends AbstractDomainDateCreated {

  private static final long serialVersionUID = 2L;

  private String walletMnemonics;
  private String walletId;
  private String walletPrK;
  private String walletAddress;

  private String username;
  private String encryptedPassword;
  private Boolean enabled = true;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private Integer failedLoginAttempts = 0;

  @JsonIgnore
//  @JoinTable(name = "users_x_authorities",
//          joinColumns = @JoinColumn(name = "user"),
//          inverseJoinColumns = @JoinColumn(name = "authority"))
//  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Authority> authorities = new HashSet<>();

  public BetrUser() {
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEncryptedPassword() {
    return encryptedPassword;
  }

  public void setEncryptedPassword(String encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
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

//  @Transient
  public void addAuthority(Authority auth) {
    this.authorities.add(auth);
//    auth.addBetrUser(this);
  }

//  @Transient
  public void removeAuthority(Authority auth) {
    this.authorities.remove(auth);
//    auth.removeBetrUser(this);
  }

  @Override
  public String toString() {
    return "BetrUser{ ID=" + getId() + ", walletAddress=" + walletAddress + ", username=" + username + '}';
  }

}
