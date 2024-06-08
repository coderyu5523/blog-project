package org.example.blogproject.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.blogproject._core.errors.exception.Exception404;
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
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Board board = boardRepository.save(requestDTO.toEntity(user));
        return new BoardResponse.SaveDTO(board);
    }

    public BoardResponse.MainDTO findAll() {
        List<Board> boardList = boardRepository.findAll();
        BoardResponse.MainDTO mainDTO = new BoardResponse.MainDTO();

        for (Board board : boardList) {
            if ("스포츠".equals(board.getCategory())) {
                mainDTO.getSportsDTOs().add(new BoardResponse.MainDTO.SportsDTO(board));
            } else if ("영화".equals(board.getCategory())) {
                mainDTO.getMovieDTOs().add(new BoardResponse.MainDTO.MovieDTO(board));
            } else if ("게임".equals(board.getCategory())) {
                mainDTO.getGameDTOs().add(new BoardResponse.MainDTO.GameDTO(board));
            } else if ("음식".equals(board.getCategory())) {
                mainDTO.getFoodDTOs().add(new BoardResponse.MainDTO.FoodDTO(board));
            }
        }
        return mainDTO;
    }


    public BoardResponse.DetailDTO detail(Integer boardId, SessionUser sessionUser) {
        Board board = boardRepository.findByIdWithUser(boardId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Boolean isBoardOwner = false;
        if (sessionUser != null && sessionUser.getId() == board.getUser().getId()) {
            isBoardOwner = true;
            return new BoardResponse.DetailDTO(board, isBoardOwner);

        }
        return new BoardResponse.DetailDTO(board, isBoardOwner);
    }

    public List<BoardResponse.SportsListDTO> sportsList() {
        List<Board> boardList = boardRepository.findBySprots().orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return boardList.stream().map(board -> new BoardResponse.SportsListDTO(board)).toList();
    }

    public List<BoardResponse.GameListDTO> gameList() {
        List<Board> boardList = boardRepository.findByGame().orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return boardList.stream().map(board -> new BoardResponse.GameListDTO(board)).toList();
    }

    public List<BoardResponse.MovieListDTO> movieList() {
        List<Board> boardList = boardRepository.findByMovie().orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return boardList.stream().map(board -> new BoardResponse.MovieListDTO(board)).toList();
    }

    public List<BoardResponse.FoodListDTO> foodList() {
        List<Board> boardList = boardRepository.findByFood().orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return boardList.stream().map(board -> new BoardResponse.FoodListDTO(board)).toList();
    }

    public BoardResponse.UpdateFormDTO updateForm(Integer boardId, SessionUser sessionUser) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return new BoardResponse.UpdateFormDTO(board);
    }

    @Transactional
    public BoardResponse.UpdateDTO update(Integer boardId, SessionUser sessionUser, BoardRequest.UpdateDTO requestDTO) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        board.update(requestDTO);
        return new BoardResponse.UpdateDTO(board);

    }

    @Transactional
    public BoardResponse.DeleteDTO delete(Integer boardId, SessionUser sessionUser) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        BoardResponse.DeleteDTO responseDTO = new BoardResponse.DeleteDTO(board);
        boardRepository.delete(board);
        return responseDTO;
    }
}
