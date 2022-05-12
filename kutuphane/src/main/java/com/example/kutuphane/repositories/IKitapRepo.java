package com.example.kutuphane.repositories;

import com.example.kutuphane.entities.Kitap;
import com.example.kutuphane.repositories.base.IBaseEntityRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKitapRepo extends IBaseEntityRepo<Kitap, Long> {

}
