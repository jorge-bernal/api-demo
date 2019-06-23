package me.jorgebernal.api_demo.dtos;

import me.jorgebernal.api_demo.documents.Sponsor;

import java.time.LocalDateTime;

public class SponsorDto {

    private String id;

    private String name;

    private LocalDateTime contractStart;

    private Double moneyPerMonth;

    public SponsorDto() {

    }

    public SponsorDto(Sponsor sponsor) {
        this.id = sponsor.getId();
        this.name = sponsor.getName();
        this.contractStart = sponsor.getContractStart();
        this.moneyPerMonth = sponsor.getMoneyPerMonth();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getContractStart() {
        return contractStart;
    }

    public void setContractStart(LocalDateTime contractStart) {
        this.contractStart = contractStart;
    }

    public Double getMoneyPerMonth() {
        return moneyPerMonth;
    }

    public void setMoneyPerMonth(Double moneyPerMonth) {
        this.moneyPerMonth = moneyPerMonth;
    }
}
