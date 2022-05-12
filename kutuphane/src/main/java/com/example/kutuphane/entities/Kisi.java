package com.example.kutuphane.entities;

import com.example.kutuphane.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Kisi extends BaseEntity {
    private String ad;
    private String soyad;
    private String tc;

    @ManyToOne
    private Rezervasyon rezervasyon;

    @ManyToMany(mappedBy = "kisi")
    @JsonIgnore
    private List<Kitap> kitaplar;

    @Override
    public String toString() {
        return "Kisi{" + "ad='" + this.getAd() + '\'' + ", soyad=" + this.getSoyad() + '\'' + ", tc=" + this.getTc() + ", Kitap= " + getKitapAdlari() + '}';
    }

    private String getKitapAdlari() {

        String adlar = "";
        for (Kitap k : kitaplar) {
            adlar = adlar + k.getAd() + ",";
        }

        return adlar.substring(0, adlar.length() - 1);
    }
}
