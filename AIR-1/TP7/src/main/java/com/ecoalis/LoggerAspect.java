package com.ecoalis;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggerAspect {

   final Logger log = Logger.getLogger(LoggerAspect.class.getName());

   @Around("execution(* com.ecoalis.service.impl.MonServiceImpl.*(..))")
   public Object log(ProceedingJoinPoint pjp) throws Throwable {
      String classeEtMethode = pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName();
      
      log.info(classeEtMethode + " - appelee");
      
      Object retVal = pjp.proceed();
      
      log.info(classeEtMethode + " - terminee");
      
      return retVal;
   }

}