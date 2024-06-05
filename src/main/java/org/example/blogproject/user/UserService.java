package org.example.blogproject.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

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
       User user = userRepository.findById(sessionUser.getId()).get();
       return new UserResponse.UserInfoDTO(user);
    }
}
