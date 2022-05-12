package com.example.kutuphane.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class KitapDTO extends BaseDTO {

    private Long Id;
    private String ad;
    private String basimYili;
    private String baskiNo;
    private String ceviren;
    private String yazar;
    private String basimEvi;

}
