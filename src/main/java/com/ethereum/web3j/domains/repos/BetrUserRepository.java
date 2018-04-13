package com.ethereum.web3j.domains.repos;

import com.ethereum.web3j.domains.BetrUser;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * @author I.T.W764
 */
public interface BetrUserRepository extends CrudRepository<BetrUser, Long> {

  Optional<BetrUser> findByUsername(String username);
}
