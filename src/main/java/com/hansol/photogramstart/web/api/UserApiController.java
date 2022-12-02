package com.hansol.photogramstart.web.api;

import com.hansol.photogramstart.config.auth.PrincipalDetails;
import com.hansol.photogramstart.domain.user.User;
import com.hansol.photogramstart.service.UserService;
import com.hansol.photogramstart.web.dto.CMRespDto;
import com.hansol.photogramstart.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable Long id,
                               @Valid UserUpdateDto userUpdateDto,
                               @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);
        return new CMRespDto<>(1, "회원수정 완료", userEntity);
    }

}
