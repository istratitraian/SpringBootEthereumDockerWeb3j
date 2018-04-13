package com.ethereum.web3j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBootEtherDock {

  public static String walletMnemonic = "kangaroo police entry demand cement then alter drum elevator school favorite usage";//MetaMsk Chrome
  public static String password = "132eqw!@#";

  public static void main(String[] args) {
    SpringApplication.run(SBootEtherDock.class, args);
    if (args.length == 2) {
      walletMnemonic = args[0];
      password = args[1];
    }

  }

}
