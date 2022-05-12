package com.example.kutuphane.controller;

import com.example.kutuphane.configuration.BaseResponse;
import com.example.kutuphane.configuration.Util;
import com.example.kutuphane.dto.RezervasyonDTO;
import com.example.kutuphane.entities.abstracts.BaseEntity;
import com.example.kutuphane.services.IRezervasyonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/rezervasyon")
@RestController
public class RezervasyonController extends BaseEntity {

    private IRezervasyonService rezervasyonService;
    @Autowired
    public RezervasyonController(IRezervasyonService rezervasyonService) { this.rezervasyonService = rezervasyonService;
    }
    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(rezervasyonService.idyeGoreGetir(id));
    }
    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody RezervasyonDTO r) {

        try {
            return Util.islemSonucGetir(rezervasyonService.rezervasyonKaydet(r));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody RezervasyonDTO k) {

        try {
            return Util.islemSonucGetir(rezervasyonService.rezervasyonGuncelle(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        rezervasyonService.rezervasyonSil(id);
        return Util.islemSonucGetir(null);
    }
}