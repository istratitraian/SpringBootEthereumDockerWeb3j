package com.ethereum.web3j.domains.repos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.ethereum.web3j.domains.BetrUser;
import org.springframework.stereotype.Repository;

@Repository
public class BetrUserRepoImpl implements BetrUserRepository {

  private final Map<String, Optional<BetrUser>> users = new HashMap<>();
  private final Map<Long, Optional<BetrUser>> usersIds = new HashMap<>();

  public BetrUserRepoImpl() {
    System.out.println("BetrUserRepoImpl");
  }

  @Override
  public Optional<BetrUser> findByUsername(String username) {
    return users.get(username);
  }

  @Override
  public void save(BetrUser user) {
    users.put(user.getUsername(), Optional.of(user));
    usersIds.put(user.getId(), Optional.of(user));
  }

  @Override
  public Collection<Optional<BetrUser>> findAll() {
    return users.values();
  }

  @Override
  public Optional<BetrUser> findById(Long id) {
    return usersIds.get(id);
  }

}
