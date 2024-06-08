package org.example.blogproject.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.blogproject._core.utils.ApiUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    // 회원가입 페이지
    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    // 로그인 페이지
    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    // 일반, OAuth 로그인 선택 페이지
    @GetMapping("/join-section")
    public String joinSection() {
        return "user/join-section";
    }

    // 로그인
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {
        SessionUser sessionUser = userService.login(requestDTO);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }

    // 회원가입
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {
        UserResponse.JoinDTO responseDTO = userService.join(requestDTO);

        return "redirect:/login-form";
    }

    // 마이페이지
    @GetMapping("/users/info")
    public String userInfo(HttpServletRequest request) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.UserInfoDTO responseDTO = userService.userInfo(sessionUser);
        request.setAttribute("UserInfoDTO", responseDTO);
        return "user/profile";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    // 회원정보 수정 페이지
    @GetMapping("/users/update-form")
    public String updateForm(HttpServletRequest request) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.UpdateFormDTO responseDTO = userService.userUpdateForm(sessionUser);
        request.setAttribute("UpdateFormDTO", responseDTO);
        return "user/update-form";
    }

    // 회원정보 수정
    @PostMapping("/users/update")
    public String update(UserRequest.UpdateDTO requestDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.UpdateDTO responseDTO = userService.userUpdate(sessionUser, requestDTO);
        return "redirect:/user-info";
    }

    // 아이디 중복체크
    @GetMapping("/api/username-same-check")
    public @ResponseBody ApiUtil<Boolean> usernameSameCheck(@RequestParam String username) {
        return new ApiUtil<>(userService.usernameCheck(username));
    }
}
