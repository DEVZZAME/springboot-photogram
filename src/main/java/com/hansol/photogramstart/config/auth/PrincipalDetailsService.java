package com.hansol.photogramstart.config.auth;

import com.hansol.photogramstart.domain.user.User;
import com.hansol.photogramstart.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    //1. 패스워드는 loadUserByUsername가 알아서 체킹 함.
    //2. 리턴이 잘 되면 세션이 생성 됨.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userEntity = userRepository.findByUsername(username);

        if(userEntity == null){
            return null;
        }else{
            return new PrincipalDetails(userEntity);
        }

    }
}
