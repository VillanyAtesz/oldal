package com.github.villany_atesz.oldal.eszkozok;

import com.github.villany_atesz.oldal.hibakezeles.Hiba;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class Validacio {
    public static <T> void benneVanAListaban(T ertek, List<T> list, String tulajdonsag) {
        nemNull(ertek, tulajdonsag);

        if (!list.contains(ertek)) {
            throw new Hiba(HttpStatus.BAD_REQUEST, ertek + " nincs benne a listaban: " + list);
        }
    }

    public static void nemNull(Object ertek, String tulajdonsag) {
        if (ertek == null) {
            throw new Hiba(HttpStatus.BAD_REQUEST, tulajdonsag + " nem lehet null.");
        }
    }

    public static void nemUres(String ertek, String tulajdonsag) {
        if(isBlank(ertek)){
            throw new Hiba(HttpStatus.BAD_REQUEST, tulajdonsag + " nem lehet ures.");
        }
    }
}
