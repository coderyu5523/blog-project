package org.example.blogproject.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.blogproject.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final HttpSession session;

    // 메인 페이지
    @GetMapping("/")
    public String list(HttpServletRequest request) {
        BoardResponse.MainDTO responseDTO = boardService.findAll();
        request.setAttribute("MainDTO", responseDTO);
        return "index";
    }

    // 게임 게시판
    @GetMapping("/boards/games")
    public String gameList(HttpServletRequest request) {
        List<BoardResponse.GameListDTO> responseDTO = boardService.gameList();
        request.setAttribute("GameListDTO", responseDTO);
        return "list/games-list";
    }

    // 스포츠 게시판
    @GetMapping("/boards/sports")
    public String sportsList(HttpServletRequest request) {
        List<BoardResponse.SportsListDTO> responseDTO = boardService.sportsList();
        request.setAttribute("SportsListDTO", responseDTO);
        return "list/sports-list";
    }

    // 영화 게시판
    @GetMapping("/boards/movies")
    public String moviesList(HttpServletRequest request) {
        List<BoardResponse.MovieListDTO> responseDTO = boardService.movieList();
        request.setAttribute("MovieListDTO", responseDTO);
        return "list/movies-list";
    }

    // 음식 게시판
    @GetMapping("/boards/foods")
    public String foodsList(HttpServletRequest request) {
        List<BoardResponse.FoodListDTO> responseDTO = boardService.foodList();
        request.setAttribute("FoodListDTO", responseDTO);
        return "list/foods-list";
    }

    // 게시글 작성 페이지
    @GetMapping("/boards/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    // 게시글 작성
    @PostMapping("/boards/save")
    public String save(BoardRequest.SaveDTO requstDTO) throws IOException {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        BoardResponse.SaveDTO responseDTO = boardService.save(requstDTO, sessionUser);
        return "redirect:/boards/" + responseDTO.getId();
    }

    // 게시글 상세보기
    @GetMapping("/boards/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        BoardResponse.DetailDTO responseDTO = boardService.detail(id, sessionUser);
        request.setAttribute("DetailDTO", responseDTO);
        return "board/detail";
    }

    // 게시글 수정 페이지
    @GetMapping("/boards/{id}/update-form")
    public String updateForm(@PathVariable Integer id, HttpServletRequest request) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        BoardResponse.UpdateFormDTO responseDTO = boardService.updateForm(id, sessionUser);
        request.setAttribute("UpdateFormDTO", responseDTO);
        return "board/update-form";
    }

    // 게시글 수정
    @PostMapping("/boards/{id}/update")
    public String update(@PathVariable Integer id, HttpServletRequest request, BoardRequest.UpdateDTO requestDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        BoardResponse.UpdateDTO responseDTO = boardService.update(id, sessionUser, requestDTO);
        return "redirect:/boards/" + responseDTO.getId();
    }

    // 게시글 삭제
    @PostMapping("/boards/{id}/delete")
    public String delete(@PathVariable Integer id) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        BoardResponse.DeleteDTO responseDTO = boardService.delete(id, sessionUser);
        return "redirect:/boards/"+responseDTO.getFormatCategory();
    }

}
