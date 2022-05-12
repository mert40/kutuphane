package com.example.kutuphane.entities;

import com.example.kutuphane.entities.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Rezervasyon extends BaseEntity {
    @ManyToOne
    private Kitap kitap;

    @ManyToOne
    private Kisi kisi;

    private Date alımTarihi;
    private Date bırakmaTarihi;

    @Override
    public String toString() {
        return "Rezarvasyon{" + "alımTarihi='" + this.getAlımTarihi()+ '\'' + ", bırakmaTarihi=" + this.getBırakmaTarihi() + '\'' + ", kisi=" + this.getKisi() + ", kitap= " + this.getKitap()  + '}';
    }
}
