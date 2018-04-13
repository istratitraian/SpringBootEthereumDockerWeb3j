package com.ethereum.web3j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web3j.protocol.admin.Admin;

/**
 * @author I.T.W764
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

  //web3j.admin-client = true
  @Autowired
  private Admin admin;

  @ResponseBody
  @GetMapping("")
  public String admin() {
    return "/admin " + admin+", admin.ethAccounts() = "+admin.ethAccounts().getId();
  }

}
