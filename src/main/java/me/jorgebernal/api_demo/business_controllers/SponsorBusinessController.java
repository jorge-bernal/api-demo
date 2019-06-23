package me.jorgebernal.api_demo.business_controllers;

import me.jorgebernal.api_demo.daos.SponsorDao;
import me.jorgebernal.api_demo.documents.Sponsor;
import me.jorgebernal.api_demo.dtos.SponsorCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SponsorBusinessController {

    private SponsorDao sponsorDao;

    @Autowired
    public SponsorBusinessController(SponsorDao sponsorDao) {
        this.sponsorDao = sponsorDao;
    }

    public void create(SponsorCreationDto sponsorCreationDto) {
        Sponsor sponsor = new Sponsor(sponsorCreationDto.getName(), sponsorCreationDto.getMoneyPerMonth());
        sponsorDao.save(sponsor);
    }

}
