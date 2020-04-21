package com.flowers.flower.services;

import com.flowers.flower.dao.FlowerRepository;
import com.flowers.flower.entities.Flower;
import com.flowers.flower.entities.dto.FamilyDTO;
import com.flowers.flower.entities.dto.FlowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FlowerService {

    private FlowerRepository repository;

    private FamilyService familyService;

    @Autowired
    public FlowerService(FlowerRepository repository, FamilyService familyService) {
        this.repository = repository;
        this.familyService = familyService;
    }

    public List<FlowerDTO> findAll() {
        List<Flower> flowers = new ArrayList<>();
        repository.findAll().forEach(flowers::add);

        List<FlowerDTO> flowerDTOList = new ArrayList<>();
        for (Flower flower : flowers) {
            flowerDTOList.add(new FlowerDTO(
                    flower.getId(),
                    flower.getName(),
                    flower.getFamily().getName(),
                    flower.getPhotoPath(),
                    flower.getColor(),
                    flower.getPrice(),
                    flower.getFamily().getCareFeature().getCareFeatures()
            ));
        }

        return flowerDTOList;
    }

    public List<FlowerDTO> findByName(String name) {
        return findAll().stream()
                .filter(flower -> flower.getName().toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<FlowerDTO> findByFamily(String family) {
        return findAll().stream()
                .filter(flower -> flower.getFamily().toLowerCase().equals(family.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<FlowerDTO> findByColor(String color) {
        return findAll().stream()
                .filter(flower -> flower.getColor().toLowerCase().equals(color.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<FlowerDTO> findByPrice(double price) {
        return findAll().stream()
                .filter(flower -> flower.getPrice() <= price)
                .collect(Collectors.toList());
    }

    public List<FlowerDTO> findByCareFeature(String care) {
        Set<String> families = familyService.findByCare(care).stream()
                .map(FamilyDTO::getName)
                .collect(Collectors.toSet());
        return findAll().stream()
                .filter(flower -> families.contains(flower.getFamily()))
                .collect(Collectors.toList());
    }
}
