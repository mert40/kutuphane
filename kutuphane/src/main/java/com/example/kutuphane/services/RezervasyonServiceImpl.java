package com.example.kutuphane.services;

import com.example.kutuphane.entities.Kisi;
import com.example.kutuphane.entities.Kitap;
import com.example.kutuphane.entities.Rezervasyon;
import com.example.kutuphane.repositories.IKisiRepo;
import com.example.kutuphane.repositories.IKitapRepo;
import com.example.kutuphane.repositories.IRezervasyonRepo;
import com.example.kutuphane.dto.RezervasyonDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service(value = "rezervasyonService")
public class RezervasyonServiceImpl implements IRezervasyonService {
    IRezervasyonRepo rezervasyonRepo;
    IKisiRepo kisiRepo;
    IKitapRepo kitapRepo;
    ModelMapper modelMapper;

    @Autowired
    public RezervasyonServiceImpl(IRezervasyonRepo rezervasyonRepo, IKisiRepo kisiRepo, IKitapRepo kitapRepo, ModelMapper modelMapper) {
        this.rezervasyonRepo = rezervasyonRepo;
        this.kisiRepo = kisiRepo;
        this.kitapRepo=kitapRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    @Transactional(readOnly = true)
    public RezervasyonDTO idyeGoreGetir(Long id) { return modelMapper.map(rezervasyonRepo.getOne(id), RezervasyonDTO.class);
    }
    @Override
    @Transactional(readOnly = true)
    public List<RezervasyonDTO> tumunuGetir() {
        return modelMapper.map(rezervasyonRepo.findAll(), new TypeToken<List<RezervasyonDTO>>() {
        }.getType());
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RezervasyonDTO rezervasyonKaydet(RezervasyonDTO rezervasyonDTO) throws Exception {
        if (rezervasyonDTO.getId() != null)
            throw new Exception("Id dolu olamaz");

        Rezervasyon rezervasyon = new Rezervasyon();

        rezervasyon.setKisi(modelMapper.map(rezervasyonDTO.getKisi(),Kisi.class));
        rezervasyon.setKitap(modelMapper.map(rezervasyonDTO.getKitap(),Kitap.class));

        rezervasyon.setAlımTarihi(rezervasyonDTO.getAlımTarihi());
        rezervasyon.setBırakmaTarihi(rezervasyonDTO.getBırakmaTarihi());

        return modelMapper.map(rezervasyonRepo.save(rezervasyon), RezervasyonDTO.class);
    }
    @Override
    public RezervasyonDTO rezervasyonGuncelle(RezervasyonDTO rezervasyonDTO) throws Exception {
        if (rezervasyonDTO.getId() == null)
            throw new Exception("Id boş olamaz");
        Rezervasyon r = rezervasyonRepo.getOne(rezervasyonDTO.getId());
        if (r == null)
            throw new Exception("rezervasyon bulunamadı");

        r.setKisi(modelMapper.map(rezervasyonDTO.getKisi(),Kisi.class));
        r.setKitap(modelMapper.map(rezervasyonDTO.getKitap(),Kitap.class));

        r.setAlımTarihi(rezervasyonDTO.getAlımTarihi());
        r.setBırakmaTarihi(rezervasyonDTO.getBırakmaTarihi());

        return modelMapper.map(rezervasyonRepo.save(r), RezervasyonDTO.class);
    }
    @Override
    public void rezervasyonSil(Long id) { rezervasyonRepo.deleteById(id);
    }
}