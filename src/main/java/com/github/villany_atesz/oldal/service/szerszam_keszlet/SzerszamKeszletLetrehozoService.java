package com.github.villany_atesz.oldal.service.szerszam_keszlet;

import com.github.villany_atesz.oldal.adatbazis.repositoryk.szerszam_keszlet.SzerszamKeszlet;
import com.github.villany_atesz.oldal.adatbazis.repositoryk.szerszam_keszlet.SzerszamKeszletRepository;
import com.github.villany_atesz.oldal.api.model.szerszam_keszlet.SzerszamKeszletLetrehozas;
import com.github.villany_atesz.oldal.eszkozok.Validacio;
import com.github.villany_atesz.oldal.tulajdonsag.szerszam_keszlet.SzerszamTipusok;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SzerszamKeszletLetrehozoService {
    private final SzerszamTipusok szerszamTipusok;
    private final SzerszamKeszletRepository szerszamKeszletRepository;

    public void letrehoz(SzerszamKeszletLetrehozas adatok) {
        Validacio.benneVanAListaban(adatok.getSzerszamTipus(), szerszamTipusok.getSzerszamTipus().stream().map(szerszamTipus -> szerszamTipus.getId()).toList(), "szerszamTipus");
        Validacio.nemNull(adatok.getMarka(), "marka");
        Validacio.nemUres(adatok.getMegnevezes(), "megnevezes");
        Validacio.nemNull(adatok.getAr(), "ar");
        Validacio.nemNull(adatok.getMegjegyzes(), "megjegyzes");

        SzerszamKeszlet szerszamKeszlet = SzerszamKeszlet.builder()
            .id(UUID.randomUUID().toString())
            .szerszamTipus(adatok.getSzerszamTipus())
            .marka(adatok.getMarka())
            .megnevezes(adatok.getMegnevezes())
            .ar(adatok.getAr())
            .megjegyzes(adatok.getMegjegyzes())
            .build();
        szerszamKeszletRepository.save(szerszamKeszlet);
    }
}
