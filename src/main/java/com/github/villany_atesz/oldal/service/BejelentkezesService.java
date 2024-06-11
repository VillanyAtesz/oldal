package com.github.villany_atesz.oldal.service;

import com.github.villany_atesz.oldal.adatbazis.repositoryk.felhasznalo.Felhasznalo;
import com.github.villany_atesz.oldal.adatbazis.repositoryk.felhasznalo.FelhasznaloRepository;
import com.github.villany_atesz.oldal.adatbazis.repositoryk.munkamenet.Munkamenet;
import com.github.villany_atesz.oldal.adatbazis.repositoryk.munkamenet.MunkamenetRepository;
import com.github.villany_atesz.oldal.hibakezeles.Hiba;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class BejelentkezesService {
    private final FelhasznaloRepository felhasznaloRepository;
    private final MunkamenetRepository munkamenetRepository;

    public String bejelentkezes(String felhasznalonev, String jelszo) {
        Optional<Felhasznalo> talanFelhasznalo = felhasznaloRepository.findByFelhasznalonevAndJelszo(felhasznalonev, jelszo);
        if (talanFelhasznalo.isEmpty()) {
            throw new Hiba(HttpStatus.UNAUTHORIZED, "Hibás felhasználónév vagy jelszó");
        }

        String munkamenetAzonosito = UUID.randomUUID().toString();
        Munkamenet munkamenet = Munkamenet.builder()
            .id(munkamenetAzonosito)
            .felhasznaloId(talanFelhasznalo.get().getId())
            .lejarat(LocalDateTime.now().plusHours(16).toString())
            .build();
        munkamenetRepository.save(munkamenet);

        log.info("{} sikeresen bejelentkezet.", felhasznalonev);

        return munkamenetAzonosito;
    }
}
