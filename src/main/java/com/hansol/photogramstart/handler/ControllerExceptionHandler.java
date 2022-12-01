package com.hansol.photogramstart.handler;

import com.hansol.photogramstart.handler.ex.CustomValidationException;
import com.hansol.photogramstart.util.Script;
import com.hansol.photogramstart.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController //Data return
@ControllerAdvice //모든 Exception을 가로챔
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {
        return Script.back(e.getErrorMap().toString());
//        return new CMRespDto<Map<String, String>>(-1, e.getMessage(), e.getErrorMap());
    }
}
