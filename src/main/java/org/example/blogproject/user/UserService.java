package org.example.blogproject.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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

    @Transactional
    public UserResponse.JoinDTO join(UserRequest.JoinDTO requestDTO) {
        Optional<User> userOP = userRepository.findByUsername(requestDTO.getUsername());

//       if(userOP.isPresent()){
//           if(userOP.isPresent()){
//               throw new Exception400("중복된 유저네임입니다");
//           }
//       }

        User user = userRepository.save(requestDTO.toEntity());
        return new UserResponse.JoinDTO(user);


    }

    @Transactional
    public SessionUser login(UserRequest.LoginDTO requestDTO) {
        User user = userRepository.findByUsernameAndPassword(requestDTO.getUsername(), requestDTO.getPassword()).get();
        return new SessionUser(user);
    }

    public UserResponse.UserInfoDTO userInfo(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        List<Board> boardList = boardRepository.findByUserId(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return new UserResponse.UserInfoDTO(user, boardList);
    }

    public UserResponse.UpdateFormDTO userUpdateForm(SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        return new UserResponse.UpdateFormDTO(user);
    }

    @Transactional
    public UserResponse.UpdateDTO userUpdate(SessionUser sessionUser,UserRequest.UpdateDTO requestDTO) {
       User user = userRepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
       user.update(requestDTO);
       return new UserResponse.UpdateDTO(user);
    }
}
