package com.github.villany_atesz.oldal.tulajdonsag.szerszam_keszlet;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app.szerszam-keszlet")
@Slf4j
@Data
public class SzerszamTipusok {
    private List<SzerszamTipus> szerszamTipus;
}
