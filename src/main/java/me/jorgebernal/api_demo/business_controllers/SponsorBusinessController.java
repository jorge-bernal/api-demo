package me.jorgebernal.api_demo.business_controllers;

import me.jorgebernal.api_demo.daos.SponsorDao;
import me.jorgebernal.api_demo.documents.Sponsor;
import me.jorgebernal.api_demo.dtos.IdDto;
import me.jorgebernal.api_demo.dtos.SponsorCreationDto;
import me.jorgebernal.api_demo.dtos.SponsorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SponsorBusinessController {

    private SponsorDao sponsorDao;

    @Autowired
    public SponsorBusinessController(SponsorDao sponsorDao) {
        this.sponsorDao = sponsorDao;
    }

    public IdDto create(SponsorCreationDto sponsorCreationDto) {
        Sponsor sponsor = new Sponsor(sponsorCreationDto.getName(), sponsorCreationDto.getMoneyPerMonth());
        sponsorDao.save(sponsor);
        return new IdDto(sponsor.getId());
    }

    public List<SponsorDto> readAll() {
        List<Sponsor> sponsors = this.sponsorDao.findAll();
        return sponsors.stream().map(SponsorDto::new).collect(Collectors.toList());
    }

    public void delete(String id) {
        sponsorDao.deleteById(id);
    }

}
