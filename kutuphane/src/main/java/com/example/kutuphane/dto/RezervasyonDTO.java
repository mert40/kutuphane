package com.example.kutuphane.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class RezervasyonDTO extends BaseDTO {

    private Long Id;
    private KisiDTO kisi;
    private KitapDTO kitap;
    private Date alımTarihi;
    private Date bırakmaTarihi;


}
