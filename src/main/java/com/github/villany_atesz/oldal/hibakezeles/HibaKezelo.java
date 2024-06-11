package com.github.villany_atesz.oldal.hibakezeles;

import com.github.villany_atesz.oldal.Application;
import com.github.villany_atesz.oldal.api.model.OneParamResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = Application.class)
@Slf4j
public class HibaKezelo {
    @ExceptionHandler(Hiba.class)
    ResponseEntity<OneParamResponse<String>> hiba(Hiba hiba) {
        log.warn("Hiba történt:", hiba);

        return new ResponseEntity<>(new OneParamResponse<>(hiba.getMessage()), hiba.getStatus());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<OneParamResponse<String>> nemVartHiba(Exception hiba) {
        log.error("Hiba történt:", hiba);

        return new ResponseEntity<>(new OneParamResponse<>(hiba.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
