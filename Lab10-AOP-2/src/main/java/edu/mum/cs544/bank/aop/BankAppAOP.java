package edu.mum.cs544.bank.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class BankAppAOP {
    @Autowired
    private ILogger logger;

    @Before("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void logBankDaoPackage(JoinPoint joinPoint) {
        logger.log(String.format("BEFORE EXECUTE BANK DAO(%s) in method %s",joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName()));
    }

    @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
    public Object logBankServicePackage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(proceedingJoinPoint.getSignature().getName());
        Object returnValue = proceedingJoinPoint.proceed();
        sw.stop();
        long timeExecution = sw.getLastTaskTimeMillis();
        logger.log(String.format("TOTAL TIME EXECUTION OF %s is %s ms",
                proceedingJoinPoint.getSignature().getName(), timeExecution));

        return returnValue;
    }

    @After("execution(* edu.mum.cs544.bank.jms.IJMSSender.sendJMSMessage())")
    public void logAfterSentMessage(JoinPoint joinPoint) {
        logger.log(String.format("Message (%s) was sent!!!", joinPoint.getArgs()[0]));
    }
}
