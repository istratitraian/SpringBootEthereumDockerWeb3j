package com.ethereum.web3j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.ethereum.web3j", "com.ethereum.web3j.domains.repos", "com.ethereum.web3j.controllers"})
@SpringBootApplication
public class SBootEtherDock//
        extends SpringBootServletInitializer//
{

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SBootEtherDock.class);
  }

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
