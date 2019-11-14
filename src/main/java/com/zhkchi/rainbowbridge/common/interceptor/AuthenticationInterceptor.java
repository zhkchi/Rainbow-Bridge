package com.zhkchi.rainbowbridge.common.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zhkchi.rainbowbridge.common.annotation.PassAuthentication;
import com.zhkchi.rainbowbridge.common.constants.SystemConstant;
import com.zhkchi.rainbowbridge.modules.sys.entity.SysUserEntity;
import com.zhkchi.rainbowbridge.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author zhkchi
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    SysUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(PassAuthentication.class)) {
            PassAuthentication passToken = method.getAnnotation(PassAuthentication.class);
            if (passToken.required()) {
                return true;
            }
        }

        //从header中得到token
        String token = request.getHeader(SystemConstant.TOKEN);
        if (token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        int userId;
        try {
            userId = Integer.parseInt(JWT.decode(token)
                                         .getAudience()
                                         .get(0));
            request.setAttribute(SystemConstant.USER_ID, userId);
        } catch (JWTDecodeException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        SysUserEntity user = userService.getById(userId);

        if (user == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword()))
                                  .build();
        try {
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("token无效，请重新登录");
        }

        //token 验证通过，用户信息放入request
        request.setAttribute(SystemConstant.SESSION_USER, user);
        return true;
    }
}