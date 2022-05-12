package com.example.kutuphane.services;
import com.example.kutuphane.dto.KisiDTO;
import javax.transaction.Transactional;
import java.util.List;

@Transactional

public interface IKisiService {

    KisiDTO idyeGoreGetir(Long id);

    List<KisiDTO> tumunuGetir();

    KisiDTO kisiKaydet(KisiDTO kisi) throws Exception;

    KisiDTO kisiGuncelle(KisiDTO kisi) throws Exception;

    void kisiSil(Long id);

}

