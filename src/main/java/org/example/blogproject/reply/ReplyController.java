package org.example.blogproject.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final ReplyService replyService;
}
