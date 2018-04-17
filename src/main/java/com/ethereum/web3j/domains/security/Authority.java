package com.ethereum.web3j.domains.security;

import com.ethereum.web3j.domains.BetrUser;
import com.ethereum.web3j.domains.abs.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;

/**
 * @author I.T.W764
 */
@Entity
@Table(name = "authorities")
public class Authority extends AbstractDomain {

  private static final long serialVersionUID = 1L;

//  @Column(unique = true)
  private String authority;

  @JsonIgnore
  @JoinTable(name = "users_x_authorities", joinColumns = {
    @JoinColumn(name = "authorities_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "users_id", referencedColumnName = "id")})
  @ManyToMany
  private Set<BetrUser> userSet = new HashSet<>();

  public Authority() {
  }

  public Authority(String authority) {
    this.authority = authority;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String role) {
    this.authority = role;
  }

  public Set<BetrUser> getUserSet() {
    return userSet;
  }

  public void setUserSet(Set<BetrUser> userSet) {
    this.userSet = userSet;
  }

  @Transient
  public void addBetrUser(BetrUser user) {
    this.userSet.add(user);
//    user.addAuthority(this);
  }

  @Transient
  public void removeBetrUser(BetrUser user) {
    this.userSet.remove(user);
//    user.removeAuthority(this);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.authority);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Authority other = (Authority) obj;
    return hashCode() == other.hashCode();
  }

  @Override
  public String toString() {
    return "Authority{" + authority + '}';
  }

}
