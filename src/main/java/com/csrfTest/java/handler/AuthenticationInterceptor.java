package com.csrfTest.java.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("member") == null) {
            response.sendRedirect("/"); // No logged-in user found, so redirect to login page.
            return false;
        }
        response.setHeader("Set-Cookie", "JSESSIONID=" + request.getRequestedSessionId() + "; SameSite=None; Secure");
        return true;
    }
}