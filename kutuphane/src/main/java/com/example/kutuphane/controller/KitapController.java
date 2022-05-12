package com.example.kutuphane.controller;

import com.example.kutuphane.configuration.BaseResponse;
import com.example.kutuphane.configuration.Util;
import com.example.kutuphane.dto.KitapDTO;
import com.example.kutuphane.entities.abstracts.BaseEntity;
import com.example.kutuphane.services.IKitapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RequestMapping("api/kitap")
@RestController

public class KitapController extends BaseEntity {


    private  IKitapService kitapService;
    @Autowired
    public KitapController(IKitapService kitapService) { this.kitapService = kitapService;
    }
    @RequestMapping("idye-gore-getir/{id}")
    public BaseResponse idyeGoreGetir(@PathVariable("id") Long id) {

        return Util.islemSonucGetir(kitapService.idyeGoreGetir(id));
    }
    @RequestMapping(value = "kaydet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse kaydet(@RequestBody KitapDTO k) {

        try {
            return Util.islemSonucGetir(kitapService.kitapKaydet(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "guncelle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse guncelle(@RequestBody KitapDTO k) {

        try {
            return Util.islemSonucGetir(kitapService.kitapGuncelle(k));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable("id") Long id) {
        kitapService.kitapSil(id);
        return Util.islemSonucGetir(null);
    }
}


