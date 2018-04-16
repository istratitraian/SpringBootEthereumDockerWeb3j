package com.ethereum.web3j.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetCompilers;
import org.web3j.protocol.core.methods.response.EthHashrate;
import rx.Observable;

/**
 * @author I.T.W764
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

  //web3j.admin-client = true
  @Autowired
  private Admin admin;

  @GetMapping("")
  public Request<?, EthAccounts> admin() {
    return admin.ethAccounts();
  }

  @GetMapping("1")
  public EthAccounts admin1() throws IOException {
    return admin.ethAccounts().send();
  }

  @GetMapping("2")
  public EthBlockNumber admin2() throws IOException {
    return admin.ethBlockNumber().send();
//    return admin.ethBlockHashObservable();
  }

  @GetMapping("3")
  public EthGetCompilers admin3() throws IOException {
    return admin.ethGetCompilers().send();
//    return admin.ethCoinbase().send();
//    return admin.ethPendingTransactionHashObservable();
  }

  @GetMapping("4")
  public EthGasPrice admin4() throws IOException {
    return admin.ethGasPrice().send();
  }

  @GetMapping("5")
  public EthHashrate admin5() throws IOException {
    return admin.ethHashrate().send();
  }

}
