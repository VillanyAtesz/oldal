package com.github.villany_atesz.oldal.api;

import com.github.villany_atesz.oldal.api.model.szerszam_keszlet.SzerszamKeszletLetrehozas;
import com.github.villany_atesz.oldal.api.model.szerszam_keszlet.SzerszamKeszletValasz;
import com.github.villany_atesz.oldal.service.szerszam_keszlet.SzerszamKeszletLetoltesService;
import com.github.villany_atesz.oldal.service.szerszam_keszlet.SzerszamKeszletLetrehozoService;
import com.github.villany_atesz.oldal.service.szerszam_keszlet.SzerszamKeszletTorloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SzerszamKeszletVezerlo {
    private final SzerszamKeszletLetoltesService szerszamKeszletLetoltesService;
    private final SzerszamKeszletLetrehozoService szerszamKeszletLetrehozoService;
    private final SzerszamKeszletTorloService szerszamKeszletTorloService;

    @PutMapping("/api/szerszam-keszlet")
    List<SzerszamKeszletValasz> letrehoz(@RequestBody SzerszamKeszletLetrehozas adatok) {
        szerszamKeszletLetrehozoService.letrehoz(adatok);

        return letoltes();
    }

    @DeleteMapping("/api/szerszam-keszlet/{id}")
    List<SzerszamKeszletValasz> torles(@PathVariable("id") String id) {
        szerszamKeszletTorloService.torles(id);

        return letoltes();
    }

    @GetMapping("/api/szerszam-keszlet")
    List<SzerszamKeszletValasz> letoltes() {
        return  szerszamKeszletLetoltesService.letolt();
    }
}
