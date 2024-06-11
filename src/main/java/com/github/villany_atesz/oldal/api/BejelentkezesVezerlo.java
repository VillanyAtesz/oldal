package com.github.villany_atesz.oldal.api;

import com.github.villany_atesz.oldal.adatbazis.repositoryk.munkamenet.MunkamenetRepository;
import com.github.villany_atesz.oldal.api.model.OneParamResponse;
import com.github.villany_atesz.oldal.api.model.index.BejelentkezesKerelem;
import com.github.villany_atesz.oldal.service.BejelentkezesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BejelentkezesVezerlo {
    private final BejelentkezesService bejelentkezesService;
    private final MunkamenetRepository munkamenetRepository;

    @PostMapping("/bejelentkezes")
    OneParamResponse<String> bejelentkezes(@RequestBody BejelentkezesKerelem kerelem) {
        log.info("{} be szeretne jelentkezni.", kerelem.getFelhasznalonev());

        return new OneParamResponse<>(bejelentkezesService.bejelentkezes(kerelem.getFelhasznalonev(), kerelem.getJelszo()));
    }

    @GetMapping("/kijelentkezes")
    void kijelentkezes(@CookieValue("munkamenet_azonosito") String munkamenetAzonosito){
        munkamenetRepository.deleteById(munkamenetAzonosito);
    }
}
