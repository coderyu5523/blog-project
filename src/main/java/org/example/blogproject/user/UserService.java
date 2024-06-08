package org.example.blogproject.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.blogproject._core.errors.exception.Exception400;
import org.example.blogproject._core.errors.exception.Exception404;
import org.example.blogproject.board.Board;
import org.example.blogproject.board.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    // 아이디 중복체크
    public Boolean usernameCheck(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    // 회원가입
    @Transactional
    public UserResponse.JoinDTO join(UserRequest.JoinDTO requestDTO) {
        if (userRepository.findByUsername(requestDTO.getUsername()).isPresent()) {
            throw new Exception400("이미 존재하는 아이디입니다.");
        }
        User user = userRepository.save(requestDTO.toEntity());
        return new UserResponse.JoinDTO(user);
    }


    // 로그인
    @Transactional
    public SessionUser login(UserRequest.LoginDTO requestDTO) {
        User user = userRepository.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return new SessionUser(user);
    }

    // 마이페이지
    public UserResponse.UserInfoDTO userInfo(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        List<Board> boardList = boardRepository.findByUserId(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return new UserResponse.UserInfoDTO(user, boardList);
    }

    // 회원정보 수정 페이지
    public UserResponse.UpdateFormDTO userUpdateForm(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return new UserResponse.UpdateFormDTO(user);
    }

    // 회원정보 수정
    @Transactional
    public UserResponse.UpdateDTO userUpdate(SessionUser sessionUser, UserRequest.UpdateDTO requestDTO) {
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        user.update(requestDTO);
        return new UserResponse.UpdateDTO(user);
    }
}
