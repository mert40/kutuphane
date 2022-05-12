package com.example.kutuphane.repositories;

import com.example.kutuphane.entities.Kisi;
import com.example.kutuphane.repositories.base.IBaseEntityRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IKisiRepo extends IBaseEntityRepo<Kisi, Long> {

    List<Kisi> findAllByAdAndSoyad(String ad, String soyad);

}
