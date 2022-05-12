package com.example.kutuphane.services;

import com.example.kutuphane.dto.RezervasyonDTO;
import javax.transaction.Transactional;
import java.util.List;

@Transactional

public interface IRezervasyonService {

    Object idyeGoreGetir(Long id);

    List<RezervasyonDTO> tumunuGetir();

     RezervasyonDTO rezervasyonKaydet(RezervasyonDTO rezervasyonDTO) throws Exception;

    RezervasyonDTO rezervasyonGuncelle(RezervasyonDTO rezervasyonDTO) throws Exception;

    void rezervasyonSil(Long id);

}
