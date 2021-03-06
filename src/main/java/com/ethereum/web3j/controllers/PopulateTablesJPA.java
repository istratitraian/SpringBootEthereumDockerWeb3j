package com.ethereum.web3j.controllers;

import com.ethereum.web3j.SBootEtherDock;
import com.ethereum.web3j.SecurityConfig;
import com.ethereum.web3j.domains.repos.AuthorityRepository;
import com.ethereum.web3j.domains.repos.BetrUserRepository;
import static com.ethereum.web3j.SBootEtherDock.password;
import static com.ethereum.web3j.SBootEtherDock.walletMnemonic;
import com.ethereum.web3j.domains.BetrUser;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.springframework.stereotype.Component;

/**
 * @author I.T.W764
 */
@Component
public class PopulateTablesJPA {

  @Resource(name = "passwordEncoder")
  private PasswordEncoder passwordEncoder;

  @Autowired
  private BetrUserRepository betrUserRepository;

  @Autowired
  private AuthorityRepository authorityRepository;

  @PostConstruct
  public void onApplicationEvent() {
    try {
      authorityRepository.save(SecurityConfig.AUTHORITY_CLIENT);
      authorityRepository.save(SecurityConfig.AUTHORITY_SU_ADMIN);
    } catch (Exception e) {
      System.out.println("ERROR PopulateTablesJPA authority " + e);
    }

    BetrUser user = betrUserRepository.findByEmail("istrati.traian@yahoo.com");

    if (user == null) {

      user = new BetrUser();

//    user.setId(1L);
      user.addAuthority(SecurityConfig.AUTHORITY_CLIENT);
      user.setFirstName("Istrati");
      user.setLastName("Traian");
      user.setEmail("istrati.traian@yahoo.com");
//    user.setUsername("istrati.traian");
      user.setPhoneNumber("0744555666");

      user.setEncryptedPassword(passwordEncoder.encode(password));
      user.setWalletMnemonic(walletMnemonic);

      Credentials userCreds = WalletUtils.loadBip39Credentials(SBootEtherDock.password, SBootEtherDock.walletMnemonic);
      user.setWalletId("77fe1f53-5711-4413-9164-e066b79d7322");
      user.setWalletPrK(userCreds.getEcKeyPair().getPrivateKey().toString());
      user.setWalletAddress(userCreds.getAddress());

      betrUserRepository.save(user);
    }

    BetrUser user1 = betrUserRepository.findByEmail("ion.manolache@gmail.com");
    if (user1 == null) {

      user1 = new BetrUser();

//    user1.setId(2L);
      user1.addAuthority(SecurityConfig.AUTHORITY_CLIENT);
      user1.setFirstName("Ion");
      user1.setLastName("manolache");
      user1.setEmail("ion.manolache@gmail.com");
//    user1.setUsername("ion.manolache");
      user1.setPhoneNumber("0721222333");

      user1.setEncryptedPassword(passwordEncoder.encode(password));
      user1.setWalletMnemonic("very typical vacant pull flee scorpion creek giraffe put oak turn praise");

      Credentials user1Creds = WalletUtils.loadBip39Credentials(SBootEtherDock.password, user1.getWalletMnemonic());
      user1.setWalletId("5150d426-3710-491a-9174-62b4150205f6");
      user1.setWalletPrK(user1Creds.getEcKeyPair().getPrivateKey().toString());
      user1.setWalletAddress(user1Creds.getAddress());

      betrUserRepository.save(user1);

    }

    System.out.println("PopulateTables allAuthorities : " + authorityRepository.findAll());
    System.out.println("PopulateTables allUsers : " + betrUserRepository.findAll());

  }
}
