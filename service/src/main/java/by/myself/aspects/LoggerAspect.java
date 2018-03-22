package by.myself.aspects;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
@Log4j
public class LoggerAspect {

    @Pointcut("@within(by.myself.annotation.Loggable)")
    public void services() {
    }

    @Before("services()")
    public void loggingServiceMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        if (arguments.length > 0) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(arguments).forEach(a -> sb.append(a).append(", "));
            String formattedArguments = sb.toString();
            log.info("----------------------------------------------------------------");
            log.info(className + ": " + methodName + "(" + formattedArguments.substring(0, formattedArguments.length() - 2) + ")");
            log.info("----------------------------------------------------------------");
        } else {
            log.info("----------------------------------------------------------------");
            log.info(className + ": " + methodName + "()");
            log.info("----------------------------------------------------------------");
        }
    }
}