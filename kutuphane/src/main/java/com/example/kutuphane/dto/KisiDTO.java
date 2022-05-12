package com.example.kutuphane.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class KisiDTO {

    public List<KitapDTO> aldigiKitaplar;
    private Long Id;
    private String ad;
    private String soyad;
    private String tc;



}



