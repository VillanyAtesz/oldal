package com.github.villany_atesz.oldal.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OneParamResponse<T> {
    private T ertek;
}
