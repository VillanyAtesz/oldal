package com.github.villany_atesz.oldal.service.szerszam_keszlet;

import com.github.villany_atesz.oldal.adatbazis.repositoryk.szerszam_keszlet.SzerszamKeszletRepository;
import com.github.villany_atesz.oldal.api.model.szerszam_keszlet.SzerszamKeszletValasz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class SzerszamKeszletLetoltesService {
    private final SzerszamKeszletRepository szerszamKeszletRepository;

    public List<SzerszamKeszletValasz> letolt() {
        return StreamSupport.stream(szerszamKeszletRepository.findAll().spliterator(), false)
            .map(szerszamKeszlet -> SzerszamKeszletValasz.builder()
                .id(szerszamKeszlet.getId())
                .szerszamTipus(szerszamKeszlet.getSzerszamTipus())
                .marka(szerszamKeszlet.getMarka())
                .megnevezes(szerszamKeszlet.getMegnevezes())
                .ar(szerszamKeszlet.getAr())
                .megjegyzes(szerszamKeszlet.getMegjegyzes())
                .build())
            .toList();
    }
}
