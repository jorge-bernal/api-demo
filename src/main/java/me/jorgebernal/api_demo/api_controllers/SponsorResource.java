package me.jorgebernal.api_demo.api_controllers;


import me.jorgebernal.api_demo.business_controllers.SponsorBusinessController;
import me.jorgebernal.api_demo.dtos.SponsorCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void create(@RequestBody SponsorCreationDto sponsorCreationDto) {
        sponsorCreationDto.validate();
        this.sponsorBusinessController.create(sponsorCreationDto);
    }
}
