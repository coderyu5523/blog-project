package org.example.blogproject.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.blogproject.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.HTML;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final HttpSession session;

    @GetMapping("/")
    public String list() {
        return "list";
    }

    @GetMapping("/boards/games")
    public String gameList() {
        return "list/games-list";
    }

    @GetMapping("/boards/sports")
    public String sportsList() {
        return "list/sports-list";
    }

    @GetMapping("/boards/movies")
    public String moviesList() {
        return "list/movies-list";
    }

    @GetMapping("/boards/foods")
    public String foodsList() {
        return "list/foods-list";
    }

    @GetMapping("/boards/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @PostMapping("/boards/save")
    public String save(BoardRequest.SaveDTO requstDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        Board board = boardService.save(requstDTO,sessionUser);

        return "redirect:/boards/"+board.getId();
    }

    @GetMapping("/boards/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request){
       BoardResponse.DetailDTO responseDTO = boardService.detail(id);
       request.setAttribute("DetailDTO", responseDTO);
        return "board/detail";
    }

}
