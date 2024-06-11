package com.github.villany_atesz.oldal.api;

import com.github.villany_atesz.oldal.tulajdonsag.szerszam_keszlet.SzerszamTipus;
import com.github.villany_atesz.oldal.tulajdonsag.szerszam_keszlet.SzerszamTipusok;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
class TulajdonsagVezerlo {
    private final SzerszamTipusok szerszamTipusok;

    @GetMapping("/szerszam-tipusok")
    List<SzerszamTipus> szerszamTipusok() {
        return szerszamTipusok.getSzerszamTipus();
    }
}
