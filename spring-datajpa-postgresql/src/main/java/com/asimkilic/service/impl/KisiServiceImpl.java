package com.asimkilic.service.impl;


import com.asimkilic.dto.KisiDto;
import com.asimkilic.entity.Adres;
import com.asimkilic.entity.Kisi;
import com.asimkilic.repository.AdresRepository;
import com.asimkilic.repository.KisiRepository;
import com.asimkilic.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;


    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        //Assert.isNull(kisiDto.getAdi(),"Ad alanı boş olamaz");
        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        final Kisi kisiDb = kisiRepository.save(kisi);
        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresleri().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);

        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDto.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiList = kisiRepository.findAll();
        List<KisiDto> kisiDtoList = new ArrayList<>();
        kisiList.forEach(kisi -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(kisi.getId());
            kisiDto.setAdi(kisi.getAdi());
            kisiDto.setSoyadi(kisi.getSoyadi());
            kisiDto.setAdresleri(
                    kisi.getAdresleri()
                            .stream()
                            .map(Adres::getAdres)
                            .collect(Collectors.toList()));
            kisiDtoList.add(kisiDto);
        });
        return kisiDtoList;
    }

    @Override
    public Page<Kisi> getAll(Pageable pageable) {
        return null;
    }
}
