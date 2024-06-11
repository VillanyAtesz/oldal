package com.github.villany_atesz.oldal.api.model.szerszam_keszlet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SzerszamKeszletValasz {
    private String id;
    private String szerszamTipus;
    private String marka;
    private String megnevezes;
    private Integer ar;
    private String megjegyzes;
}
