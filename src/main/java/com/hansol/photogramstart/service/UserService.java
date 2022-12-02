package com.hansol.photogramstart.service;

import com.hansol.photogramstart.domain.user.User;
import com.hansol.photogramstart.domain.user.UserRepository;
import com.hansol.photogramstart.handler.ex.CustomValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User 회원수정(Long id, User user) {
        //1. 영속화
        User userEntity = userRepository.findById(id).orElseThrow(()->{
            return new CustomValidationException("찾을 수 없는 id입니다.");
        });

        //2. 영속화된 Object 수정 - 더티체킹(업데이트 완료)
        userEntity.setName(user.getName());

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setGender(user.getGender());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        return userEntity;
    }//더티체킹이 일어나서 업데이트가 완료됨.
}
