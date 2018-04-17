package com.ethereum.web3j.domains.repos;

import com.ethereum.web3j.domains.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author I.T.W764
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

  // @Cacheable("authority")
  public Authority findByAuthority(String authority);

//  void save(Authority authority);
//
//  public Collection<Authority> findAll();
}
