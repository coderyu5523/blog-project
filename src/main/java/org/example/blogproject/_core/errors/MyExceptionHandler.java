package org.example.blogproject._core.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.example.blogproject._core.errors.exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception400.class)
    public String ex400(Exception400 e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        request.setAttribute("status", 400);

        return "error";
    }

    @ExceptionHandler(Exception401.class)
    public String ex401(Exception401 e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        request.setAttribute("status", 401);

        return "error";
    }

    @ExceptionHandler(Exception403.class)
    public String ex403(RuntimeException e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        request.setAttribute("status", 403);

        return "error";
    }

    @ExceptionHandler(Exception404.class)
    public String ex404(RuntimeException e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        request.setAttribute("status", 404);

        return "error";
    }

    @ExceptionHandler(Exception500.class)
    public String ex500(RuntimeException e, HttpServletRequest request) {
        request.setAttribute("msg", e.getMessage());
        request.setAttribute("status", 500);

        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String unknwonException(Exception e, HttpServletRequest request) {
        request.setAttribute("msg", "관리자에게 문의하세요");
        request.setAttribute("status", 500);

        return "error";
    }
}