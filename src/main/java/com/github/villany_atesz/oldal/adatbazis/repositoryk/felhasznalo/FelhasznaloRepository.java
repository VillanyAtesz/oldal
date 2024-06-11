package com.github.villany_atesz.oldal.adatbazis.repositoryk.felhasznalo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FelhasznaloRepository extends CrudRepository<Felhasznalo, String> {
    Optional<Felhasznalo> findByFelhasznalonevAndJelszo(String felhasznalonev, String jelszo);
}
