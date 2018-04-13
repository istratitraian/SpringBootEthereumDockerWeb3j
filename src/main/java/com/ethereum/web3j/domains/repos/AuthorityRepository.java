package com.ethereum.web3j.domains.repos;

import com.ethereum.web3j.domains.security.Authority;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author I.T.W764
 */
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

  @Cacheable("authority")
  public Authority findByAuthority(String authority);

}
