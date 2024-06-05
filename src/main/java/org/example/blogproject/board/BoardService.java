package org.example.blogproject.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.blogproject.user.SessionUser;
import org.example.blogproject.user.User;
import org.example.blogproject.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public Board save(BoardRequest.SaveDTO requestDTO, SessionUser sessionUser) {
        int targetWidth = 800;
        int targetHeight = 600;

        // 배경 이미지
//        String backgroundImgUUID = ImageUtil.imgResizedAndDownloadAndUUID("배경 이미지", requestDTO.getBoardImg().getOriginalFilename(), requestDTO.getBoardImg(), targetWidth, targetHeight);
       User user = userRepository.findById(sessionUser.getId()).get();
       Board board = boardRepository.save(requestDTO.toEntity(user));
        return board;
    }

    public void findAll() {
        List<Board> boardList = boardRepository.findAll();
    }

    public BoardResponse.DetailDTO detail(Integer boardId) {
        Board board = boardRepository.findByIdWithUser(boardId).get();
        return new BoardResponse.DetailDTO(board);
    }
}
