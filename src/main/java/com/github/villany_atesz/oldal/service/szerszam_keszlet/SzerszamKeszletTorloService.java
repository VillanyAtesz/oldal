package com.github.villany_atesz.oldal.service.szerszam_keszlet;

import com.github.villany_atesz.oldal.adatbazis.repositoryk.szerszam_keszlet.SzerszamKeszletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SzerszamKeszletTorloService {
    private final SzerszamKeszletRepository szerszamKeszletRepository;

    public void torles(String id) {
        szerszamKeszletRepository.deleteById(id);
    }
}
