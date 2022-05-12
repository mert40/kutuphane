package com.example.kutuphane.services;
import com.example.kutuphane.dto.KitapDTO;
import javax.transaction.Transactional;
import java.util.List;

@Transactional

public interface IKitapService {

    KitapDTO idyeGoreGetir(Long id);

    List<KitapDTO> tumunuGetir();

    KitapDTO kitapKaydet(KitapDTO kitap) throws Exception;

    KitapDTO kitapGuncelle(KitapDTO kitap) throws Exception;

    void kitapSil(Long id);

}
