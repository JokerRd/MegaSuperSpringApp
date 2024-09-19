package ru.test.backend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogRequestAspect {


//    @Before("@annotation(LogRequest)")
//    public void logExecutionTime(JoinPoint jp){
//        var methodName = jp.getSignature().getName();
//        log.info("Мы вызвали метод {}", methodName);
//    }
//
//    @After("@annotation(LogRequest)")
//    public void logExecutionTimeAfter(JoinPoint jp){
//        var methodName = jp.getSignature().getName();
//        log.info("Мы закончили вызов метода {}", methodName);
//    }

    @Around("@annotation(LogRequest)")
    public Object logExecutionTimeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        var methodName = joinPoint.getSignature().getName();
        log.info("Мы вызвали метод {}", methodName);

        Object proceed = joinPoint.proceed();

        log.info("Мы закончили вызов метода {}", methodName);
        return "Иван";
    }

    @Pointcut("@annotation(LogRequest)")
    public void logRequest() {}

}
