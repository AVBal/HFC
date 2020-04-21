package com.flowers.flower.services;

import com.flowers.flower.dao.FamilyRepository;
import com.flowers.flower.entities.Family;
import com.flowers.flower.entities.dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyService {

    private FamilyRepository repository;

    @Autowired
    public FamilyService(FamilyRepository repository) {
        this.repository = repository;
    }

    public List<FamilyDTO> findAll() {
        List<Family> families = new ArrayList<>();
        repository.findAll().forEach(families::add);

        List<FamilyDTO> familyDTOList = new ArrayList<>();
        for (Family family : families) {
            familyDTOList.add(new FamilyDTO(
                    family.getId(),
                    family.getName(),
                    family.getCareFeature().getCareFeatures()
            ));
        }
        return familyDTOList;
    }

    public List<FamilyDTO> findByCare(String care) {
        return findAll().stream()
                .filter(family -> family.getCareFeatures().toLowerCase().equals(care.toLowerCase()))
                .collect(Collectors.toList());
    }
}
