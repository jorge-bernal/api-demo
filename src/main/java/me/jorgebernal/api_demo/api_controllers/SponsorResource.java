package me.jorgebernal.api_demo.api_controllers;


import me.jorgebernal.api_demo.business_controllers.SponsorBusinessController;
import me.jorgebernal.api_demo.dtos.IdDto;
import me.jorgebernal.api_demo.dtos.SponsorCreationDto;
import me.jorgebernal.api_demo.dtos.SponsorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SponsorResource.SPONSORS)
public class SponsorResource {

    public static final String SPONSORS = "/sponsors";

    private SponsorBusinessController sponsorBusinessController;

    @Autowired
    public SponsorResource(SponsorBusinessController sponsorBusinessController) {
        this.sponsorBusinessController = sponsorBusinessController;
    }

    @PostMapping
    public IdDto create(@RequestBody SponsorCreationDto sponsorCreationDto) {
        sponsorCreationDto.validate();
        return this.sponsorBusinessController.create(sponsorCreationDto);
    }


    @GetMapping
    public List<SponsorDto> readAll() {
        return this.sponsorBusinessController.readAll();
    }

}
