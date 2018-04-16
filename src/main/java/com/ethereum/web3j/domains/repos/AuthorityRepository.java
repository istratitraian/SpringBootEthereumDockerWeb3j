package com.ethereum.web3j.domains.repos;

import com.ethereum.web3j.domains.security.Authority;
import java.util.Collection;

/**
 * @author I.T.W764
 */
public interface AuthorityRepository // extends CrudRepository<Authority, Integer>
{

  // @Cacheable("authority")
  public Authority findByAuthority(String authority);

  void save(Authority authority);

  public Collection<Authority> findAll();
}
