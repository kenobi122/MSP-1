package com.app.backend.security;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.app.backend.config.JwtProvider;
import com.app.backend.exception.AppException;
import com.app.backend.ulti.BusinessException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component

public class LoginInterceptor implements HandlerInterceptor {
    private final JwtProvider jwtProvider;

    private static final String[] AllowApi = {"^/api/account/login", "^/api/account/register", "^/login?error", "^/error",
            "^/v2/api-docs$", "^/configuration/ui$", "^/swagger-resources$","^/swagger-resources/\\**$",
            "^/swagger-ui.html$", "^/webjars/\\**$","^/swagger-resources/configuration/ui$","^/swagger-ui.html$"};

    public LoginInterceptor(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (AllowApiInterceptor(request)) return true;


        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader.isEmpty() || !authorizationHeader.startsWith("Bearer ")) {

            throw new AppException(BusinessException.IVALID_TOKEN);
        }

        if (authorizationHeader.startsWith("Bearer ")) {
            Jws<Claims> claims = jwtProvider.checkJwt(authorizationHeader.substring(7));
        }

        return true;
    }

    private boolean AllowApiInterceptor(HttpServletRequest request) {

        for (String allowApi : AllowApi) {

            Pattern pattern = Pattern.compile(allowApi);
            String url = request.getRequestURI();

            boolean matches = pattern
                    .matcher(url)
                    .matches();

            if (matches) {
                return true;
            }
        }

        return false;
    }

}
