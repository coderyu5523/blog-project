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
    public BoardResponse.SaveDTO save(BoardRequest.SaveDTO requestDTO, SessionUser sessionUser) {
        int targetWidth = 800;
        int targetHeight = 600;

        // 배경 이미지
//        String backgroundImgUUID = ImageUtil.imgResizedAndDownloadAndUUID("배경 이미지", requestDTO.getBoardImg().getOriginalFilename(), requestDTO.getBoardImg(), targetWidth, targetHeight);
       User user = userRepository.findById(sessionUser.getId()).get();
       Board board = boardRepository.save(requestDTO.toEntity(user));
        return new BoardResponse.SaveDTO(board);
    }

    public void findAll() {
        List<Board> boardList = boardRepository.findAll();
    }

    public BoardResponse.DetailDTO detail(Integer boardId) {
        Board board = boardRepository.findByIdWithUser(boardId).get();
        return new BoardResponse.DetailDTO(board);
    }

    public List<BoardResponse.SportsListDTO> sportsList() {
       List<Board> boardList = boardRepository.findBySprots().get();
       return boardList.stream().map(board -> new BoardResponse.SportsListDTO(board)).toList();
    }

    public List<BoardResponse.GameListDTO> gameList() {
        List<Board> boardList = boardRepository.findByGame().get();
        return boardList.stream().map(board -> new BoardResponse.GameListDTO(board)).toList();
    }

    public List<BoardResponse.MovieListDTO> movieList() {
        List<Board> boardList = boardRepository.findByMovie().get();
        return boardList.stream().map(board -> new BoardResponse.MovieListDTO(board)).toList();
    }

    public List<BoardResponse.FoodListDTO> foodList() {
        List<Board> boardList = boardRepository.findByFood().get();
        return boardList.stream().map(board -> new BoardResponse.FoodListDTO(board)).toList();
    }
}
