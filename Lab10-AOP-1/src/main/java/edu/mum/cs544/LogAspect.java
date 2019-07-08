package edu.mum.cs544;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.logging.Logger;


@Aspect
@Component
public class LogAspect {

    private static Logger logger = Logger.getLogger(LogAspect.class.getName());

    @After("execution(* EmailSender.sendEmail(..))")
    public void logAfterSendEmail(JoinPoint jp) {
        Object[] args = jp.getArgs();
        // a) String message = String.format("method=%s",jp.getSignature().getName());
        // b)
        String message = String.format("method=%s address=%s message=%s",jp.getSignature().getName(), args[0], args[1]);
        // c)
        IEmailSender emailSender = (IEmailSender) jp.getTarget();
        message += "\n" + "outgoing mail server = " + emailSender.getOutgoingMailServer();
        System.out.println(message);
        logger.info(message);
    }

    @Around("execution(* EmailSender.sendEmail(..))")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(proceedingJoinPoint.getSignature().getName());
        Object retVal = proceedingJoinPoint.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println("Total time execute: " + totalTime + " ms");
        logger.info("Total time execute: " + totalTime + " ms");
        return retVal;
    }

}
