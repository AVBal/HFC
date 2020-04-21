package com.flowers.flower.controllers;

import com.flowers.flower.entities.dto.FlowerDTO;
import com.flowers.flower.forms.SearchForm;
import com.flowers.flower.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FlowerController {

    private final FlowerService service;

    @Autowired
    public FlowerController(FlowerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getFlowersPage(Model model) {
        model.addAttribute("flowers", service.findAll());
        return "get-flowers";
    }

    @GetMapping("/showSearch")
    public String showSearch(Model model) {
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "search";
    }

    @GetMapping("/search")
    public String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        List<FlowerDTO> flowerDTOList;
        switch (searchForm.getSearchType()) {
            case ("По имени"):
                flowerDTOList = service.findByName(searchForm.getText());
                break;
            case ("По семейству"):
                flowerDTOList = service.findByFamily(searchForm.getText());
                break;
            case ("По цвету"):
                flowerDTOList = service.findByColor(searchForm.getText());
                break;
            case ("По цене"):
                flowerDTOList = service.findByPrice(Double.parseDouble(searchForm.getText()));
                break;
            case ("По способу ухода"):
                flowerDTOList = service.findByCareFeature(searchForm.getText());
                break;
            default:
                flowerDTOList = new ArrayList<>();
                break;
        }
        model.addAttribute("flowers", flowerDTOList);
        return "search";
    }
}
