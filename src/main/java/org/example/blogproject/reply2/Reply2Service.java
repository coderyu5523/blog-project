package org.example.blogproject.reply2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.blogproject._core.errors.exception.Exception404;
import org.example.blogproject.board.Board;
import org.example.blogproject.board.BoardRepository;
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
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(Reply2Request.SaveDTO requestDTO, SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
//        Board board = boardRepository.findById(requestDTO.getBoardId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Reply reply = replyRepository.findById(requestDTO.getReplyId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));

        reply2Repository.save(requestDTO.toEntity(reply,  user));

    }
}
