package org.example.blogproject.reply;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.blogproject._core.errors.exception.Exception401;
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
        if (sessionUser == null) throw new Exception401("로그인이 필요합니다.");
        Board board = boardRepository.findById(requestDTO.getBoardId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Reply reply = replyRepository.save(requestDTO.toEntity(board, user));
        return new ReplyResponse.SaveDTO(reply);
    }

    // 댓글 삭제
    @Transactional
    public ReplyResponse.DeleteDTO delete(SessionUser sessionUser, Integer replyId) {
        if (sessionUser == null) throw new Exception401("로그인이 필요합니다.");
        Reply reply = replyRepository.findById(replyId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        ReplyResponse.DeleteDTO responseDTO = new ReplyResponse.DeleteDTO(reply);
        replyRepository.delete(reply);
        return responseDTO;
    }
}
