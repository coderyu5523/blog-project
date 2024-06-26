package org.example.blogproject.reply2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.blogproject._core.errors.exception.Exception404;
import org.example.blogproject.reply.Reply;
import org.example.blogproject.reply.ReplyRepository;
import org.example.blogproject.user.SessionUser;
import org.example.blogproject.user.User;
import org.example.blogproject.user.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Reply2Service {
    private final Reply2Repository reply2Repository;
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;

    // 대댓글 작성
    @Transactional
    public Reply2Response.SaveDTO save(Reply2Request.SaveDTO requestDTO, SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Reply reply = replyRepository.findById(requestDTO.getReplyId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Reply2 reply2 = reply2Repository.save(requestDTO.toEntity(reply, user));
        return new Reply2Response.SaveDTO(reply2);
    }

    // 대댓글 삭제
    @Transactional
    public Reply2Response.DeleteDTO delete(Integer id) {
        Reply2 reply2 = reply2Repository.findById(id).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Reply2Response.DeleteDTO responseDTO = new Reply2Response.DeleteDTO(reply2);
        reply2Repository.delete(reply2);
        return responseDTO;
    }
}
