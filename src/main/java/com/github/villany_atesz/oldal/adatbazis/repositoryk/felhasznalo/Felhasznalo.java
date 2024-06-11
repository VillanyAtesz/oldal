package com.github.villany_atesz.oldal.adatbazis.repositoryk.felhasznalo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Felhasznalo {
    @Id
    private String id;
    private String felhasznalonev;
    private String jelszo;
}
