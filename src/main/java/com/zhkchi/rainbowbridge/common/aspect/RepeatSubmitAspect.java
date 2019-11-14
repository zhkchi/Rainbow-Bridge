package com.zhkchi.rainbowbridge.common.aspect;

import com.zhkchi.rainbowbridge.common.annotation.NoRepeatSubmitAnnotation;
import com.zhkchi.rainbowbridge.common.constants.SystemConstant;
import com.zhkchi.rainbowbridge.modules.cache.RedisLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;


/**
 * 防止重复提交，需要在方法上加注解 @NoRepeatSubmitAnnotation
 *
 * @author zhkchi
 */
@Aspect
@Component
public class RepeatSubmitAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(RepeatSubmitAspect.class);

    @Autowired
    private RedisLock redisLock;

    @Pointcut("@annotation(noRepeatSubmit)")
    public void noRepeatSubmitAnnotation(NoRepeatSubmitAnnotation noRepeatSubmit) {
    }

    @Around("@annotation(noRepeatSubmit)")
    public Object around(ProceedingJoinPoint pjp, NoRepeatSubmitAnnotation noRepeatSubmit) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        int lockSeconds = noRepeatSubmit.lockTime();
        // 此处可以用token或者JSessionId
        String token = request.getHeader(SystemConstant.TOKEN);
        String path = request.getServletPath();
        String key = getKey(token, path);
        String clientId = getClientId();
        boolean isSuccess = redisLock.tryLock(key, clientId, lockSeconds);
        if (isSuccess) {
            LOGGER.info("tryLock success, key = [{}], clientId = [{}]", key, clientId);
            // 获取锁成功, 执行进程
            Object result;
            try {
                result = pjp.proceed();
            } finally {
                // 解锁
                //redisLock.releaseLock(key, clientId);
                //LOGGER.info("releaseLock success, key = [{}], clientId = [{}]", key, clientId);
            }
            return result;
        } else {
            // 获取锁失败，认为是重复提交的请求
            LOGGER.error("tryLock fail, key = [{}]", key);
            throw new RuntimeException("重复请求，请稍后再试");
        }
    }

    private String getKey(String token, String path) {
        return token + path;
    }

    private String getClientId() {
        return UUID.randomUUID().toString();
    }

}
