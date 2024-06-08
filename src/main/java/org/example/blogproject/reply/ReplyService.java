package org.example.blogproject.reply;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.blogproject._core.errors.exception.Exception404;
import org.example.blogproject.board.Board;
import org.example.blogproject.board.BoardRepository;
import org.example.blogproject.user.SessionUser;
import org.example.blogproject.user.User;
import org.example.blogproject.user.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    // 댓글 작성
    @Transactional
    public ReplyResponse.SaveDTO save(ReplyRequest.SaveDTO requestDTO, SessionUser sessionUser) {
        Board board = boardRepository.findById(requestDTO.getBoardId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Reply reply = replyRepository.save(requestDTO.toEntity(board, user));
        return new ReplyResponse.SaveDTO(reply);
    }
}
