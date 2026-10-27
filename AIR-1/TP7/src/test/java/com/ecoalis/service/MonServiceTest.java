package com.ecoalis.service;

import java.util.logging.Logger;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecoalis.service.impl.MonServiceImpl;

public class MonServiceTest extends TestCase {

   final Logger log = Logger.getLogger(MonServiceTest.class.getName());

   public void testMonService() {
      log.info("Construction directe de la classe de service");
      
      MonService service = new MonServiceImpl();
      service.doSomething();
      
      log.info("Recuperation a partir du contexte Spring");
      ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
      MonService service2 = (MonService) ctx.getBean("monService");
      service2.doSomething();
   }
}