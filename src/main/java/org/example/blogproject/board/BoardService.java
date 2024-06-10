package org.example.blogproject.board;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.blogproject._core.errors.exception.Exception404;
import org.example.blogproject._core.utils.ImageUtil;
import org.example.blogproject.reply.Reply;
import org.example.blogproject.reply.ReplyRepository;
import org.example.blogproject.reply2.Reply2;
import org.example.blogproject.reply2.Reply2Repository;
import org.example.blogproject.user.SessionUser;
import org.example.blogproject.user.User;
import org.example.blogproject.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ReplyRepository replyRepository;
    private final Reply2Repository reply2Repository;

    // 게시글 작성
    @Transactional
    public BoardResponse.SaveDTO save(BoardRequest.SaveDTO requestDTO, SessionUser sessionUser) throws IOException {
        String backgroundImgUUID = ImageUtil.imgResizedAndDownloadAndUUID("이미지", requestDTO.getBoardImg().getOriginalFilename(), requestDTO.getBoardImg(), 800, 600);
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Board board = boardRepository.save(requestDTO.toEntity(user, backgroundImgUUID));
        return new BoardResponse.SaveDTO(board);
    }

    // 메인 페이지
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

    // 게시글 상세보기
    @Transactional
    public BoardResponse.DetailDTO detail(Integer boardId, SessionUser sessionUser) {
        Board board = boardRepository.findByIdWithUser(boardId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        List<Reply> replyList = replyRepository.findByBoardId(board.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));

        List<BoardResponse.DetailDTO.ReplyDTO> replyDTOList = new ArrayList<>();

        for (Reply reply : replyList) {
            List<Reply2> reply2List = reply2Repository.findByReplyId(reply.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            List<BoardResponse.DetailDTO.Reply2DTO> reply2DTOList = reply2List.stream().map(reply2 -> new BoardResponse.DetailDTO.Reply2DTO(reply2, sessionUser != null && sessionUser.getId().equals(reply2.getUser().getId()))).toList();
            replyDTOList.add(new BoardResponse.DetailDTO.ReplyDTO(reply, sessionUser != null && sessionUser.getId().equals(reply.getUser().getId()), reply2DTOList));
        }

        Boolean isBoardOwner = sessionUser != null && sessionUser.getId().equals(board.getUser().getId());
        return new BoardResponse.DetailDTO(board, isBoardOwner, replyDTOList, sessionUser);
    }

    // 스포츠 게시판
    public Page<BoardResponse.SportsListDTO> sportsList(String sort, String keyword,Pageable pageable) {
        Sort.Direction direction = "1".equals(sort) ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(direction, "id"));

        if (keyword != null) {
            Page<Board> boardList = boardRepository.findBySprotsWithKeyword(keyword, sortedPageable).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            return boardList.map(board -> new BoardResponse.SportsListDTO(board));
        } else {
            Page<Board> boardList = boardRepository.findBySprots(sortedPageable).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            return boardList.map(board -> new BoardResponse.SportsListDTO(board));
        }
    }

    // 게임 게시판
    public Page<BoardResponse.GameListDTO> gameList(String sort, String keyword, Pageable pageable) {
        Sort.Direction direction = "1".equals(sort) ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(direction, "id"));

        if (keyword != null) {
            Page<Board> boardList = boardRepository.findByGameWithKeyword(keyword, sortedPageable).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            return boardList.map(board -> new BoardResponse.GameListDTO(board));
        } else {
            Page<Board> boardList = boardRepository.findByGame(sortedPageable).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            return boardList.map(board -> new BoardResponse.GameListDTO(board));
        }
    }

    // 영화 게시판
    public Page<BoardResponse.MovieListDTO> movieList(String sort, String keyword,Pageable pageable) {
        Sort.Direction direction = "1".equals(sort) ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(direction, "id"));

        if (keyword != null) {
            Page<Board> boardList = boardRepository.findByMovieWithKeyword(keyword, sortedPageable).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            return boardList.map(board -> new BoardResponse.MovieListDTO(board));
        } else {
            Page<Board> boardList = boardRepository.findByMovie(sortedPageable).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            return boardList.map(board -> new BoardResponse.MovieListDTO(board));
        }
    }

    // 음식 게시판
    public Page<BoardResponse.FoodListDTO> foodList(String sort, String keyword,Pageable pageable) {
        Sort.Direction direction = "1".equals(sort) ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(direction, "id"));

        if (keyword != null) {
            Page<Board> boardList = boardRepository.findByFoodWithKeyword(keyword, sortedPageable).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            return boardList.map(board -> new BoardResponse.FoodListDTO(board));
        } else {
            Page<Board> boardList = boardRepository.findByFood(sortedPageable).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
            return boardList.map(board -> new BoardResponse.FoodListDTO(board));
        }
    }

    // 게시글 수정 페이지
    public BoardResponse.UpdateFormDTO updateForm(Integer boardId, SessionUser sessionUser) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return new BoardResponse.UpdateFormDTO(board);
    }

    // 게시글 수정
    @Transactional
    public BoardResponse.UpdateDTO update(Integer boardId, SessionUser sessionUser, BoardRequest.UpdateDTO requestDTO) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        board.update(requestDTO);
        return new BoardResponse.UpdateDTO(board);
    }

    // 게시글 삭제
    @Transactional
    public BoardResponse.DeleteDTO delete(Integer boardId, SessionUser sessionUser) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        BoardResponse.DeleteDTO responseDTO = new BoardResponse.DeleteDTO(board);
        boardRepository.delete(board);
        return responseDTO;
    }

    // 전체 검색
    public BoardResponse.SearchDTO search(String keyword, String sort,Pageable pageable) {
        Sort.Direction direction = "1".equals(sort) ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(direction, "id"));

        Page<Board> boardList = boardRepository.findByKeyword(keyword,sortedPageable).orElseThrow(() -> new Exception404("검색 결과가 없습니다."));
        Long count = boardRepository.findWithCount(keyword);
        return new BoardResponse.SearchDTO(boardList, count);
    }
}
