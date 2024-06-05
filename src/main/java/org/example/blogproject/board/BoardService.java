package org.example.blogproject.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save(BoardRequest.SaveDTO requestDTO) throws IOException {
        int targetWidth = 800;
        int targetHeight = 600;

        // 배경 이미지
//        String backgroundImgUUID = ImageUtil.imgResizedAndDownloadAndUUID("배경 이미지", requestDTO.getBoardImg().getOriginalFilename(), requestDTO.getBoardImg(), targetWidth, targetHeight);

        boardRepository.save(requestDTO.toEntity());
    }

    public void findAll() {
        List<Board> boardList = boardRepository.findAll();
    }

    public BoardResponse.DetailDTO detail(Integer boardId) {
        Board board = boardRepository.findByIdWithUser(boardId).get();
        return new BoardResponse.DetailDTO(board);
    }
}
