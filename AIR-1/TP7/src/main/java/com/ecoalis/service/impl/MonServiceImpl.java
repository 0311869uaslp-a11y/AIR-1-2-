package com.ecoalis.service.impl;

import java.util.logging.Logger;

import com.ecoalis.service.MonService;

public class MonServiceImpl implements MonService {

   final Logger log = Logger.getLogger(MonServiceImpl.class.getName());

   public void doSomething() {
      log.info("je suis dans MonServiceImpl");
   }
}