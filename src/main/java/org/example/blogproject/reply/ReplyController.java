package org.example.blogproject.reply;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.blogproject.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/boards/" + responseDTO.getBoardId();
    }

    // 댓글 삭제
    @PostMapping("/replies/{id}/delete")
    public String delete(@PathVariable Integer id) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        ReplyResponse.DeleteDTO responseDTO = replyService.delete(sessionUser, id);
        return "redirect:/boards/"+responseDTO.getBoardId();
    }
}
