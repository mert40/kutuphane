package com.example.kutuphane.entities;

import com.example.kutuphane.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Kitap extends BaseEntity {

    private String ad;
    private String basimYili;
    private String baskiNo;
    private String ceviren;
    private String yazar;
    private String basimEvi;

    @OneToMany(mappedBy = "kitap")
    private List<Rezervasyon> rezervasyon;

    @ManyToMany
    @JsonIgnore
    private List<Kisi> kisi;



    @Override
    public String toString() {
        return "Kitap{" + "ad='" + this.getAd() + '\'' + ", basimYili=" + this.getBasimYili() + '\'' + ", baskiNo=" + this.getBaskiNo() + ", ceviren= " + this.getCeviren() + ", yazar= " + this.getYazar() + ", basımEvi= " + this.getBasimEvi() + '}';
    }
}