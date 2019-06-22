package me.jorgebernal.api_demo.documents;

public class Sponsor {

    private final String id;

    private String name;

    private Integer antiquityMonths;

    private Double moneyPerMonth;

    public Sponsor(String id) {
        this.id = id;
    }

    public Sponsor(String id, String name, Integer antiquityMonths, Double moneyPerMonth) {
        this.id = id;
        this.name = name;
        this.antiquityMonths = antiquityMonths;
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

    public Integer getAntiquityMonths() {
        return antiquityMonths;
    }

    public void setAntiquityMonths(Integer antiquityMonths) {
        this.antiquityMonths = antiquityMonths;
    }

    public Double getMoneyPerMonth() {
        return moneyPerMonth;
    }

    public void setMoneyPerMonth(Double moneyPerMonth) {
        this.moneyPerMonth = moneyPerMonth;
    }
}
