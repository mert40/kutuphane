package com.example.kutuphane.services;

import com.example.kutuphane.entities.Kitap;
import com.example.kutuphane.repositories.IKisiRepo;
import com.example.kutuphane.dto.KisiDTO;
import com.example.kutuphane.entities.Kisi;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "kisiService")
public class KisiServiceImpl implements IKisiService {
    IKisiRepo kisiRepo;
    ModelMapper modelMapper;

    @Autowired
    public KisiServiceImpl(IKisiRepo kisiRepo, ModelMapper modelMapper) {
        this.kisiRepo = kisiRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public KisiDTO idyeGoreGetir(Long id) {
        return modelMapper.map(kisiRepo.getOne(id), KisiDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KisiDTO> tumunuGetir() {
        return modelMapper.map(kisiRepo.findAll(), new TypeToken<List<KisiDTO>>() {
        }.getType());
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public KisiDTO kisiKaydet(KisiDTO kisi) throws Exception {
        if (kisi.getId() != null)
            throw new Exception("Id dolu olamaz");
        Kisi o = new Kisi();
        o.setAd(kisi.getAd());
        o.setSoyad(kisi.getSoyad());
        o.setTc(kisi.getTc());
        return modelMapper.map(kisiRepo.save(o), KisiDTO.class);
    }
    @Override
    public KisiDTO kisiGuncelle(KisiDTO kisi) throws Exception {
        if (kisi.getId() == null)
            throw new Exception("Id boş olamaz");
        Kisi k = kisiRepo.getOne(kisi.getId());
        if (k == null)
            throw new Exception("kisi bulunamadı");

        k.setAd(kisi.getAd());
        k.setSoyad(kisi.getSoyad());
        k.setTc(kisi.getTc());
//        k.setKitaplar(modelMapper.map(kisi.getAldigiKitaplar(),new TypeToken<List<Kitap>>(){}.getType()));

        return modelMapper.map(kisiRepo.save(k), KisiDTO.class);
    }
    @Override
    public void kisiSil(Long id) {
        kisiRepo.deleteById(id);
    }
}
