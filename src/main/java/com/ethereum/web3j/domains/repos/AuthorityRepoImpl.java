package com.ethereum.web3j.domains.repos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ethereum.web3j.domains.security.Authority;
import java.util.Collection;

@Repository
public class AuthorityRepoImpl implements AuthorityRepository {

  private final Map<String, Authority> auths = new HashMap<>();

  @Override
  public Authority findByAuthority(String authority) {
    return auths.get(authority);
  }

  @Override
  public void save(Authority authority) {
    auths.put(authority.getAuthority(), authority);
  }

  @Override
  public Collection<Authority> findAll() {
    return auths.values();
  }

}
