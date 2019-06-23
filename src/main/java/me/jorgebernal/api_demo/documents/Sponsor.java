package me.jorgebernal.api_demo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Sponsor {

    @Id
    private String id;

    private String name;

    private LocalDateTime contractStart;

    private Double moneyPerMonth;


    public Sponsor(String name, Double moneyPerMonth) {
        this.name = name;
        this.contractStart = LocalDateTime.now();
        this.moneyPerMonth = moneyPerMonth;
    }

    public String getId() {
        return id;
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