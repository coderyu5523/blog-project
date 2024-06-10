package org.example.blogproject.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.blogproject.user.SessionUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String gameList(@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "keyword", required = false) String keyword, HttpServletRequest request, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BoardResponse.GameListDTO> responseDTO = boardService.gameList(sort, keyword, pageable);
        request.setAttribute("GameListDTO", responseDTO);
        return "list/games-list";
    }

    // 스포츠 게시판
    @GetMapping("/boards/sports")
    public String sportsList(@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "keyword", required = false) String keyword, HttpServletRequest request, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BoardResponse.SportsListDTO> responseDTO = boardService.sportsList(sort, keyword, pageable);
        request.setAttribute("SportsListDTO", responseDTO);
        return "list/sports-list";
    }

    // 영화 게시판
    @GetMapping("/boards/movies")
    public String moviesList(@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "keyword", required = false) String keyword, HttpServletRequest request, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BoardResponse.MovieListDTO> responseDTO = boardService.movieList(sort, keyword, pageable);
        request.setAttribute("MovieListDTO", responseDTO);
        return "list/movies-list";
    }

    // 음식 게시판
    @GetMapping("/boards/foods")
    public String foodsList(@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "keyword", required = false) String keyword, HttpServletRequest request, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BoardResponse.FoodListDTO> responseDTO = boardService.foodList(sort, keyword, pageable);
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
    public String update(@PathVariable Integer id, BoardRequest.UpdateDTO requestDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        BoardResponse.UpdateDTO responseDTO = boardService.update(id, sessionUser, requestDTO);
        return "redirect:/boards/" + responseDTO.getId();
    }

    // 게시글 삭제
    @PostMapping("/boards/{id}/delete")
    public String delete(@PathVariable Integer id) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        BoardResponse.DeleteDTO responseDTO = boardService.delete(id, sessionUser);
        return "redirect:/boards/" + responseDTO.getFormatCategory();
    }

    // 게시글 전체 검색
    @GetMapping("boards/search")
    public String search(@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "keyword", required = false) String keyword, HttpServletRequest request, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        BoardResponse.SearchDTO responseDTO = boardService.search(keyword, sort,pageable);
        request.setAttribute("SearchDTO", responseDTO);
        return "list/search-list";
    }

}
