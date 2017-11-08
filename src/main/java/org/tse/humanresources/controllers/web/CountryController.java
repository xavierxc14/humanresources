package org.tse.humanresources.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tse.humanresources.model.Country;
import org.tse.humanresources.model.Region;
import org.tse.humanresources.repositories.CountryRepository;
import org.tse.humanresources.repositories.RegionRepository;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public String list(Model model) {
        Iterable<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        return "countries/list";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Country country = countryRepository.findOne(id);
        List<Region> regions = regionRepository.findAll();
        model.addAttribute("country", country);
        model.addAttribute("regions", regions);
        return "countries/form";
    }

    @PostMapping("save")
    public String save(Country country) {
        countryRepository.save(country);
        return "redirect:/countries";
    }

}
