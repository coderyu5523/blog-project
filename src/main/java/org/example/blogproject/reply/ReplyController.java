package org.example.blogproject.reply;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.blogproject.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final ReplyService replyService;
    private final HttpSession session;

    // 댓글 작성
    @PostMapping("/replies/save")
    public String save(ReplyRequest.SaveDTO requestDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        ReplyResponse.SaveDTO responseDTO = replyService.save(requestDTO, sessionUser);
        return "redirect:/boards/"+responseDTO.getBoardId();
    }
}
