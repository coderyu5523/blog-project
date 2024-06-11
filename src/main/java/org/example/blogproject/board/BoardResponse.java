package org.example.blogproject.board;

import lombok.Data;
import org.example.blogproject._core.utils.CategoryFormat;
import org.example.blogproject._core.utils.DateFormat;
import org.example.blogproject._core.utils.PagingUtil;
import org.example.blogproject.reply.Reply;
import org.example.blogproject.reply2.Reply2;
import org.example.blogproject.user.SessionUser;
import org.example.blogproject.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoardResponse {

    // 메인 페이지
    @Data
    public static class MainDTO {
        private List<GameDTO> gameDTOs = new ArrayList<>();
        private List<SportsDTO> sportsDTOs = new ArrayList<>();
        private List<FoodDTO> foodDTOs = new ArrayList<>();
        private List<MovieDTO> movieDTOs = new ArrayList<>();

        @Data
        public static class GameDTO {
            private int id;
            private String title;
            private String createdAt;

            public GameDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            }
        }

        @Data
        public static class SportsDTO {
            private int id;
            private String title;
            private String createdAt;

            public SportsDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            }
        }

        @Data
        public static class FoodDTO {
            private int id;
            private String title;
            private String createdAt;

            public FoodDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            }
        }

        @Data
        public static class MovieDTO {
            private int id;
            private String title;
            private String createdAt;

            public MovieDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
            }
        }
    }

    // 스포츠 페이지
    @Data
    public static class SportsPageDTO {
        private PagingUtil pagingUtil;
        private List<SportsListDTO> sportsListDTOs = new ArrayList<>();

        public SportsPageDTO(Page<Board> boardList, Pageable pageable) {
            this.pagingUtil = new PagingUtil(boardList, pageable);
            this.sportsListDTOs = boardList.stream().map(SportsListDTO::new).toList();
        }

        @Data
        public static class SportsListDTO {
            private Integer id;
            private String title;
            private String createdAt;
            private String username;
            private String boardImg;

            public SportsListDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
                this.username = board.getUser().getUsername();
                this.boardImg = board.getBoardImg();
            }
        }
    }

    // 게임 페이지
    @Data
    public static class GamePageDTO {
        private PagingUtil pagingUtil;
        private List<GameListDTO> gameListDTOs = new ArrayList<>();

        public GamePageDTO(Page<Board> boardList, Pageable pageable) {
            this.pagingUtil = new PagingUtil(boardList, pageable);
            this.gameListDTOs = boardList.stream().map(GameListDTO::new).toList();
        }

        @Data
        public static class GameListDTO {
            private Integer id;
            private String title;
            private String createdAt;
            private String username;
            private String boardImg;

            public GameListDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
                this.username = board.getUser().getUsername();
                this.boardImg = board.getBoardImg();
            }
        }
    }


    // 음식 페이지
    @Data
    public static class FoodPageDTO {
        private PagingUtil pagingUtil;
        private List<FoodListDTO> foodListDTOs = new ArrayList<>();

        public FoodPageDTO(Page<Board> boardList, Pageable pageable) {
            this.pagingUtil = new PagingUtil(boardList, pageable);
            this.foodListDTOs = boardList.stream().map(FoodListDTO::new).toList();
        }

        @Data
        public static class FoodListDTO {
            private Integer id;
            private String title;
            private String createdAt;
            private String username;
            private String boardImg;

            public FoodListDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
                this.username = board.getUser().getUsername();
                this.boardImg = board.getBoardImg();
            }
        }
    }

    // 영화 페이지
    @Data
    public static class MoviePageDTO {
        private PagingUtil pagingUtil;
        private List<MovieListDTO> movieListDTOs = new ArrayList<>();

        public MoviePageDTO(Page<Board> boardList, Pageable pageable) {
            this.pagingUtil = new PagingUtil(boardList, pageable);
            this.movieListDTOs = boardList.stream().map(MovieListDTO::new).toList();
        }

        @Data
        public static class MovieListDTO {
            private Integer id;
            private String title;
            private String createdAt;
            private String username;
            private String boardImg;

            public MovieListDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
                this.username = board.getUser().getUsername();
                this.boardImg = board.getBoardImg();
            }
        }
    }

    // 게시글 저장 응답
    @Data
    public static class SaveDTO {
        private Integer id;
        private String title;
        private String content;
        private String category;
        private User user;

        public SaveDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.category = board.getCategory();
            this.user = board.getUser();
        }
    }

    // 게시글 상세페이지
    @Data
    public static class DetailDTO {
        private Integer id;
        private String title;
        private String content;
        private String createdAt;
        private String category;
        private String boardImg;
        private User user;
        private Boolean isBoardOwner;
        private List<ReplyDTO> replies;

        public DetailDTO(Board board, Boolean isBoardOwner, List<ReplyDTO> replies, SessionUser sessionUser) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.createdAt = DateFormat.formatTimestampWithTime(board.getCreatedAt());
            this.category = board.getCategory();
            this.boardImg = board.getBoardImg();
            this.user = board.getUser();
            this.isBoardOwner = isBoardOwner;
            this.replies = replies;
        }

        @Data
        public static class UserDTO {
            private Integer id;
            private String username;

            public UserDTO(UserDTO user) {
                this.id = user.getId();
                this.username = user.getUsername();
            }
        }

        @Data
        public static class ReplyDTO {
            private Integer id;
            private String comment;
            private String username;
            private Integer boardId;
            private Boolean isReplyOwner;
            private List<Reply2DTO> reply2List;

            public ReplyDTO(Reply reply, Boolean isReplyOwner, List<Reply2DTO> reply2List) {
                this.id = reply.getId();
                this.comment = reply.getComment();
                this.username = reply.getUser().getUsername();
                this.boardId = reply.getBoard().getId();
                this.isReplyOwner = isReplyOwner;
                this.reply2List = reply2List;
            }
        }

        @Data
        public static class Reply2DTO {
            private Integer reply2Id;
            private String comment;
            private String username;
            private Integer replyId;
            private Boolean isReply2Owner;

            public Reply2DTO(Reply2 reply2, Boolean isReply2Owner) {
                this.reply2Id = reply2.getId();
                this.comment = reply2.getComment();
                this.username = reply2.getUser().getUsername();
                this.replyId = reply2.getReply().getId();
                this.isReply2Owner = isReply2Owner;
            }
        }
    }


    // 게시글 수정 페이지
    @Data
    public static class UpdateFormDTO {
        private Integer id;
        private String title;
        private String content;
        private String category;

        public UpdateFormDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.category = board.getCategory();
        }
    }

    // 게시글 수정 응답
    @Data
    public static class UpdateDTO {
        private Integer id;
        private String title;
        private String content;

        public UpdateDTO(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
        }
    }

    // 게시글 삭제 응답
    @Data
    public static class DeleteDTO {
        private Integer id;
        private String formatCategory;

        public DeleteDTO(Board board) {
            this.id = board.getId();
            this.formatCategory = CategoryFormat.translateCategory(board.getCategory());
        }
    }

    // 전체 검색 페이지
    @Data
    public static class SearchDTO {
        private List<BoardDTO> boards = new ArrayList<>();
        public Long count;

        public SearchDTO(Page<Board> boardList, Long count) {
            this.boards = boardList.map(board -> new BoardDTO(board)).toList();
            this.count = count;
        }

        @Data
        class BoardDTO {
            private Integer id;
            private String title;
            private String createdAt;
            private String username;
            private String boardImg;

            public BoardDTO(Board board) {
                this.id = board.getId();
                this.title = board.getTitle();
                this.createdAt = DateFormat.formatTimestamp(board.getCreatedAt());
                this.username = board.getUser().getUsername();
                this.boardImg = board.getBoardImg();
            }

        }
    }
}
