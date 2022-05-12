package com.example.kutuphane;

import com.example.kutuphane.repositories.IKisiRepo;
import com.example.kutuphane.repositories.IKitapRepo;
import com.example.kutuphane.repositories.IRezervasyonRepo;
import com.example.kutuphane.services.IKisiService;
import com.example.kutuphane.services.IKitapService;
import com.example.kutuphane.services.IRezervasyonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.kutuphane.repositories")

public class KutuphaneApplication {

    private static IKitapRepo kitapRepo;
    private static IKisiRepo kisiRepo;
    private static IRezervasyonRepo rezervasyonRepo;
    private static IRezervasyonService rezervasyonService;
    private static IKitapService kitapService;
    private static IKisiService kisiService;

    @Autowired
    public KutuphaneApplication(IKitapRepo kitapRepo, IKitapService kitapService, IKisiRepo kisiRepo, IKisiService kisiService, IRezervasyonRepo rezervasyonRepo, IRezervasyonService rezervasyonService) {
        this.kisiRepo = kisiRepo;
        this.kisiService = kisiService;
        this.kitapRepo = kitapRepo;
        this.kitapService = kitapService;
        this.rezervasyonRepo= rezervasyonRepo;
        this.rezervasyonService=rezervasyonService;
    }
    public static void main(String[] args) {
        SpringApplication.run(KutuphaneApplication.class, args);
    }
}
