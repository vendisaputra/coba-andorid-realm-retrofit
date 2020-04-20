package com.example.coba.domain.dto;

import com.example.coba.domain.Hero;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class GeneralDTO {

    private GeneralDTO() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Hero> listProductFromDTO(List<HeroDTO> heroDTOS) {
        ModelMapper modelMapper = new ModelMapper();
        List<Hero> heroes = new ArrayList<>();

        for (HeroDTO heroDTO : heroDTOS) {
            Hero data = modelMapper.map(heroDTO, Hero.class);

            heroes.add(data);
        }

        return heroes;
    }
}
