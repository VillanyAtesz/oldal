package com.github.villany_atesz.oldal.hibakezeles;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class Hiba extends RuntimeException {
    @Getter
    private final HttpStatus status;

    public Hiba(HttpStatus status, String uzenet) {
        this(status, uzenet, null);
    }

    public Hiba(HttpStatus status, String uzenet, Throwable hibaOk) {
        super(uzenet, hibaOk);
        this.status = status;
    }
}
