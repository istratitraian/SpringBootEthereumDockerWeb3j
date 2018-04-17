package com.ethereum.web3j.domains.repos;

import com.ethereum.web3j.domains.BetrUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author I.T.W764
 */
public interface BetrUserRepository extends JpaRepository<BetrUser, Long> {

  BetrUser findByEmail(String email);
}
