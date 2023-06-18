// package com.app.backend.security;

// import org.springframework.context.MessageSource;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Conditional;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.support.ReloadableResourceBundleMessageSource;
// import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
// import org.springframework.web.servlet.HandlerInterceptor;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Configuration
// public class LangInterceptor implements HandlerInterceptor {

   

//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//         String lang = request.getHeader("Accept-Language");

//         if (lang == "jp") {
//             messageSource("classpath:messages-jp");
//         } else {
//             messageSource("classpath:messages");
//         }

//         return true;
//     }

// }
