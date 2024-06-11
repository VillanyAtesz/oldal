package com.github.villany_atesz.oldal.adatbazis.repositoryk.munkamenet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Munkamenet {
    @Id
    private String id;
    private String felhasznaloId;
    private String lejarat;
}
