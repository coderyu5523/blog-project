package org.example.blogproject._core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.blogproject._core.errors.exception.Exception401;
import org.example.blogproject.user.SessionUser;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle............");
        HttpSession session = request.getSession();

        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new Exception401("로그인 하셔야 해요");
        }
        return true;
    }
}