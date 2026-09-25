package pruebaturismo.Util;

import pruebaturismo.Annotations.LogAction;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* *(..)) && @annotation(logAction)")
    public Object logUserAction(ProceedingJoinPoint joinPoint, LogAction logAction) throws Throwable {
        Object result = null;
        Throwable throwable = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable t) {
            throwable = t;
        }

        logger.info("[{}] {} - {} {} ({})", LocalDateTime.now(), logAction.action(),
                getHttpMethodFromRequest(), getEndpointFromRequest(), logAction.description());

        if (throwable != null) {
            throw throwable;
        }
        return result;
    }

    private String getEndpointFromRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return request.getRequestURI();
        }
        return "N/A";
    }

    private String getHttpMethodFromRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return request.getMethod();
        }
        return "N/A";
    }
}
