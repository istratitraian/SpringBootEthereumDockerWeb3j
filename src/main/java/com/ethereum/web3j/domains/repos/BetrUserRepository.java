package com.ethereum.web3j.domains.repos;

import java.util.Collection;
import java.util.Optional;

import com.ethereum.web3j.domains.BetrUser;

/**
 * @author I.T.W764
 */
public interface BetrUserRepository
// extends CrudRepository<BetrUser, Long>
{

	Optional<BetrUser> findByUsername(String username);

	void save(BetrUser user);

	Collection<Optional<BetrUser>> findAll();

	Optional<BetrUser> findById(Long id);

}
