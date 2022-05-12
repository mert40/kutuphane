package com.example.kutuphane.configuration;

import com.example.kutuphane.enums.EnumIslemSonucTipi;

public class Util {
    public static BaseResponse islemSonucGetir(Object o) {
        BaseResponse r = new BaseResponse();
        if (o == null) {//Sadece silme işleminde
            r.setData("Silme işlemi başarılı");
            r.setIslemSonucu(EnumIslemSonucTipi.Basarili);
        } else if (o instanceof Exception) {
            r.setHata(exceptionToString((Exception) o));
            r.setIslemSonucu(EnumIslemSonucTipi.Basarisiz);
            //TODO:Loglanacak burası tüm hata tipleri için handling yapılabilir.
            ((Exception) o).printStackTrace();
        } else {
            r.setData(o);
            r.setIslemSonucu(EnumIslemSonucTipi.Basarili);
        }
        return r;
    }

    private static String exceptionToString(Exception ex) {
        if (ex == null) {
            return "Bilinmeyen bir hata oluştu. Bu hatayı aldığınız senaryoyu lütfen program yöneticisine bildiriniz.";
        } else {
            return ex.getMessage();
        }
    }
}
