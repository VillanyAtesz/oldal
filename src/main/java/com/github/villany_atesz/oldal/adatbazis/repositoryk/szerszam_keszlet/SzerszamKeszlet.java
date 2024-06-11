package com.github.villany_atesz.oldal.adatbazis.repositoryk.szerszam_keszlet;

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
public class SzerszamKeszlet {
    @Id
    private String id;
    private String szerszamTipus;
    private String marka;
    private String megnevezes;
    private Integer ar;
    private String megjegyzes;
}
