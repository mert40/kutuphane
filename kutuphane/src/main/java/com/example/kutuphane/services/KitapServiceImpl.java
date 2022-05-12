package com.example.kutuphane.services;
import com.example.kutuphane.repositories.IKitapRepo;
import com.example.kutuphane.dto.KitapDTO;
import com.example.kutuphane.entities.Kitap;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "kitapService")
public class KitapServiceImpl implements IKitapService {

    private IKitapRepo kitapRepo;
    private ModelMapper modelMapper;

    @Autowired
    public KitapServiceImpl(IKitapRepo kitapRepo, ModelMapper modelMapper) {
        this.kitapRepo = kitapRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    @Transactional(readOnly = true)
    public KitapDTO idyeGoreGetir(Long id) {
        return modelMapper.map(kitapRepo.getOne(id), KitapDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KitapDTO> tumunuGetir() {
        return modelMapper.map(kitapRepo.findAll(), new TypeToken<List<KitapDTO>>() {
        }.getType());
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public KitapDTO kitapKaydet(KitapDTO kitap) throws Exception {
        if (kitap.getId() != null)
            throw new Exception("Id dolu olamaz");
        Kitap o = new Kitap();
        o.setAd(kitap.getAd());
        o.setBasimEvi(kitap.getBasimEvi());
        o.setBasimYili(kitap.getBasimYili());
        o.setBaskiNo(kitap.getBaskiNo());
        o.setCeviren(kitap.getCeviren());
        o.setYazar(kitap.getYazar());
        return modelMapper.map(kitapRepo.save(o), KitapDTO.class);
    }
    @Override
    public KitapDTO kitapGuncelle(KitapDTO kitap) throws Exception {
        if (kitap.getId() == null)
            throw new Exception("Id boş olamaz");
        Kitap o = kitapRepo.getOne(kitap.getId());
        if (o == null)
            throw new Exception("Kitap bulunamadı");

        o.setAd(kitap.getAd());
        o.setBasimEvi(kitap.getBasimEvi());
        o.setBasimYili(kitap.getBasimYili());
        o.setBaskiNo(kitap.getBaskiNo());
        o.setCeviren(kitap.getCeviren());
        o.setYazar(kitap.getYazar());
        return modelMapper.map(kitapRepo.save(o), KitapDTO.class);
    }
    @Override
    public void kitapSil(Long id) {
        kitapRepo.deleteById(id);
    }
}
