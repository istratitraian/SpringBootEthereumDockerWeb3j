package com.ethereum.web3j;

import com.ethereum.web3j.domains.BetrUser;
import com.ethereum.web3j.domains.repos.BetrUserRepository;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import static org.web3j.crypto.Hash.sha256;
import org.web3j.crypto.MnemonicUtils;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

/**
 * @author I.T.W764
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {

  @Autowired
  private Web3j web3j;

  @Autowired
  private BetrUserRepository betrUserRepository;

  final static String PASS = "pass";

  private String toAddress;

  private Credentials ownerCredentials;

  public WalletController() {

  }

  //init
  @PostConstruct
  private void init() {
    BetrUser user = betrUserRepository.findByUsername("istrati.traian").get();
    BetrUser user1 = betrUserRepository.findByUsername("ion.manolache").get();

    ownerCredentials = WalletUtils.loadBip39Credentials(
            SBootEtherDock.password,
            user.getWalletMnemonic()//SBootEtherDock.walletMnemonic
    );

    Credentials user1Cred = WalletUtils.loadBip39Credentials(
            SBootEtherDock.password,
            user1.getWalletMnemonic()//SBootEtherDock.walletMnemonic
    );
    toAddress = user1Cred.getAddress();
    System.out.println(" --- ");

  }

  @GetMapping("")
  public List<BetrUser> wallet() {
    List<BetrUser> list = new ArrayList<>();
    betrUserRepository.findAll().forEach(list::add);
    return list;
  }

  @GetMapping("/balance/{address}")
  public EthGetBalance getBalanceFromAddress(@PathVariable String address) {
    try {
      return getBalanceTransaction(address);
    } catch (Exception e) {
    }
    return null;
  }

  @GetMapping("/balance")
  public EthGetBalance getBalance() {
    try {
      return getBalanceTransaction(ownerCredentials.getAddress());
    } catch (Exception e) {
    }
    return null;
  }

  @GetMapping("/send")
  public TransactionReceipt sendFunds() throws Exception {
    TransactionReceipt transactionReceipt = sendEther(0.0001, toAddress);
    if (transactionReceipt == null) {
      return null;
    }
    return transactionReceipt;
  }

  @GetMapping("/send/{toAddress}")
  public TransactionReceipt sendFunds(@PathVariable String toAddress) throws Exception {

    TransactionReceipt transactionReceipt = sendEther(0.0001, toAddress);
    if (transactionReceipt == null) {
      return null;
    }
    return transactionReceipt;
  }

  @GetMapping("/send/{userId}/{user1Id}")
  public TransactionReceipt sendFundsFromUserToUser1(@PathVariable Long userId, @PathVariable Long user1Id) throws Exception {
    BetrUser user = betrUserRepository.findById(userId).get();
    BetrUser user1 = betrUserRepository.findById(user1Id).get();

    Credentials userCred = WalletUtils.loadBip39Credentials(
            SBootEtherDock.password,
            user.getWalletMnemonic()//SBootEtherDock.walletMnemonic
    );

    TransactionReceipt transactionReceipt = Transfer.sendFunds(
            web3j, userCred, user1.getWalletAddress(),
            BigDecimal.valueOf(0.0001), Convert.Unit.ETHER)
            .send();
    if (transactionReceipt == null) {

      return null;
    }
    return transactionReceipt;
  }

  class C implements Serializable {

    private static final long serialVersionUID = 3L;
    EthAccounts accounts;
    Credentials credentials;

    public Credentials getCredentials() {
      return credentials;
    }

    public void setCredentials(Credentials credentials) {
      this.credentials = credentials;
    }
    Web3ClientVersion clientVersion;

    public Web3ClientVersion getClientVersion() {
      return clientVersion;
    }

    public void setClientVersion(Web3ClientVersion clientVersion) {
      this.clientVersion = clientVersion;
    }

    public EthAccounts getAccounts() {
      return accounts;
    }

    public void setAccounts(EthAccounts accounts) {
      this.accounts = accounts;
    }

  }

  @GetMapping("/info")
  public C info() throws IOException {// throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException {
    System.out.println(" --- / info() ");
    Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
    System.out.println(" --- web3.version = " + web3ClientVersion.getWeb3ClientVersion());

    System.out.println(" --- web3j : " + web3j.ethAccounts().getJsonrpc());
    System.out.println(" --- web3j : " + web3j.ethAccounts().getMethod());
//    org.web3j.protocol.core.methods.response.EthAccounts ea;

    System.out.println("Wallet owner \n credentials.address : " + ownerCredentials.getAddress()
            + "\n, prK = " + ownerCredentials.getEcKeyPair().getPrivateKey()
            + "\n, pK  = " + ownerCredentials.getEcKeyPair().getPublicKey()
    );
    C c = new C();
    c.setAccounts(web3j.ethAccounts().send());
    c.setClientVersion(web3ClientVersion);
    c.setCredentials(ownerCredentials);
    return c;
  }

  public TransactionReceipt sendEther(double val, String toAddress) {
    try {
      TransactionReceipt transactionReceipt = Transfer.sendFunds(
              web3j, ownerCredentials, toAddress,
              BigDecimal.valueOf(val), Convert.Unit.ETHER)
              .send();
      return transactionReceipt;
    } catch (IOException ex) {
    } catch (CipherException ex) {
    } catch (InterruptedException ex) {
    } catch (Exception ex) {
    }
    return null;
  }

  private static final SecureRandom secureRandom = new SecureRandom();

  @GetMapping("/new")
  public WalletFile generateWallet() {
    try {

      System.out.println("generateWallet start ");

      byte[] initialEntropy = new byte[16];
      secureRandom.nextBytes(initialEntropy);

      String mnemonic = MnemonicUtils.generateMnemonic(initialEntropy);
      System.out.println("generateWallet mnemonic = " + mnemonic);

//
      byte[] seed = MnemonicUtils.generateSeed(mnemonic, SBootEtherDock.password);

      System.out.println("generateWallet seed = " + String.valueOf(seed));
      byte[] sha256 = sha256(seed);

      ECKeyPair ecKeyPair = ECKeyPair.create(sha256);
//      ECKeyPair ecKeyPair = Keys.createEcKeyPair();
      System.out.println("generateWallet privateKey = " + ecKeyPair.getPrivateKey() + ", publicKey = " + ecKeyPair.getPublicKey());

      WalletFile walletFile = Wallet.createStandard(SBootEtherDock.password, ecKeyPair);

      System.out.println("new wallet.id = " + walletFile.getId());
      return walletFile;
    } catch (CipherException ex) {
      System.out.println(" --- ERROR createWallet() : " + ex);
    }
    return null;
  }

  public EthGetBalance getBalanceTransaction(String address) throws Exception {

    try {
      EthGetBalance balance = web3j.ethGetBalance(
              address, DefaultBlockParameterName.LATEST)
              .sendAsync().get();
      return balance;
//      return Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER);
    } catch (InterruptedException | ExecutionException ex) {
    }
    return null;
  }

}
