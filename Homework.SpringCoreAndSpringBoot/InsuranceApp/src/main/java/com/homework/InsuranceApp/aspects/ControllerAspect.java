package com.homework.InsuranceApp.aspects;

import com.homework.InsuranceApp.model.User;
import com.homework.InsuranceApp.model.interfaces.Insurance;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.swing.text.TableView;

@Aspect
@Component
@Slf4j

public class ControllerAspect {
    @Pointcut("execution(public * * (..))")
    private void anyPublicMethod(){

    }

    @Pointcut("within(com.homework.InsuranceApp.controller.*)")
    private void anyControllerMethod(){

    }

    @Before("anyPublicMethod() && anyControllerMethod() && execution(* createUser*(..)) && args(user,..)")
    private void logCreateUser(User user){log.info("Received request to createUser user: "+user.toString());}

    @Before("anyPublicMethod() && anyControllerMethod() && (execution(* createCarInsurance*(..)) || execution(* createHouseInsurance*(..))) && args(insurance,..)")
    private void logCreateInsurance(Insurance insurance){log.info("Received request to createInsurance insurance: "+insurance.toString());}

    @Around("anyControllerMethod()")
    public Object logControllerMethod(ProceedingJoinPoint proceedingJoinPoint){
        log.info("Controller method invoiced: "+proceedingJoinPoint.getSignature().getName());

        try{
            return proceedingJoinPoint.proceed();
        }catch (Throwable e){
            throw new RuntimeException(e);
        }finally {
            log.info("Method executed.");
        }
    }

    @Around("execution(public double getInsurancePrice(..))")
    public Object logInsurancePrice(ProceedingJoinPoint proceedingJoinPoint){
        log.info("Insurance price calculator method invoiced: "+proceedingJoinPoint.getSignature().getName());

        try{
            Insurance insurance = (Insurance) proceedingJoinPoint.getArgs()[0];
            log.info(String.format("Insurance price of %s : %.2f",insurance,insurance.getPrice()));


            return proceedingJoinPoint.proceed();
        }catch (Throwable e){
            throw new RuntimeException(e);
        }finally {
            log.info("Insurance price method executed.");
        }
    }



}
