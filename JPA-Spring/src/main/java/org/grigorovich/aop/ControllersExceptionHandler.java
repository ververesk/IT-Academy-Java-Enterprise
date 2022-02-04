package org.grigorovich.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
@AfterReturning — advice, который будет выполнен после успешного выполнения целевого метода.
@AfterThrowing — advice, который будет срабатывать при ошибке, то есть при падении исключения из метода.
 */
@Aspect
@Component
public class ControllersExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllersExceptionHandler.class);

    @Pointcut("execution(* org.grigorovich.controllers.*.*(..))")
    public void methodExecuting() {
    }

    @AfterReturning(value = "methodExecuting()", returning = "returningValue")
    public void recordSuccessfulExecution(JoinPoint joinPoint, Object returningValue) {
        if (returningValue != null) {
            logger.info("!!!!!!!!!!!!!!!!!!!!!!!!" +
                            "Successfully completed controller's method: {}, class {}, execution result {} ",
                    joinPoint.getSignature().getName(),
                    joinPoint.getSourceLocation().getWithinType().getName(), returningValue);
        } else {
            logger.info("!!!!!!!!!!!!!!!!!!!" +
                            "Successfully completed controller's method: {}, class {}",
                    joinPoint.getSignature().getName(),
                    joinPoint.getSourceLocation().getWithinType().getName());
        }
    }

    @AfterThrowing(value = "methodExecuting()", throwing = "exception")
    public void recordFailedExecution(JoinPoint joinPoint, Exception exception) {
        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!" +
                        "controller's method: {}, class {}, was aborted with an exception {}",
                joinPoint.getSignature().getName(),
                joinPoint.getSourceLocation().getWithinType().getName(), exception);

    }
}

