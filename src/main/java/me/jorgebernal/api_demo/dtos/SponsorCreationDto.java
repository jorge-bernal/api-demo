package me.jorgebernal.api_demo.dtos;

import me.jorgebernal.api_demo.exceptions.BadRequestException;

public class SponsorCreationDto {

    private String name;

    private Double moneyPerMonth;

    public SponsorCreationDto() {
        //empty for framework.
    }

    public SponsorCreationDto(String name, Double moneyPerMonth) {
        this.name = name;
        this.moneyPerMonth = moneyPerMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoneyPerMonth() {
        return moneyPerMonth;
    }

    public void setMoneyPerMonth(Double moneyPerMonth) {
        this.moneyPerMonth = moneyPerMonth;
    }

    public void validate() {
        if (name == null || moneyPerMonth == null || name.isEmpty() || moneyPerMonth.isNaN() || moneyPerMonth.isInfinite() || moneyPerMonth < 0) {
            throw new BadRequestException("Incomplete SponsorCreationDto");
        }
    }

    @Override
    public String toString() {
        return "SponsorCreationDto{" +
                "name='" + name + '\'' +
                ", moneyPerMonth=" + moneyPerMonth +
                '}';
    }
}
