package org.example.blogproject.reply2;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.blogproject.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class Reply2Controller {
    private final Reply2Service reply2Service;
    private final HttpSession session;

    // 대댓글 작성
    @PostMapping("/replies2/save")
    public String save(Reply2Request.SaveDTO requestDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        reply2Service.save(requestDTO,sessionUser);

        return null;
    }
}
