package com.example.kutuphane.configuration;

import com.example.kutuphane.enums.EnumIslemSonucTipi;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse {
    EnumIslemSonucTipi islemSonucu;
    Object data;
    String hata;
}
