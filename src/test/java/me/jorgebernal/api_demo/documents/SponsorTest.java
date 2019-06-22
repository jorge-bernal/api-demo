package me.jorgebernal.api_demo.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SponsorTest {

    Sponsor sponsor;

    @BeforeEach
    void before() {
        sponsor = new Sponsor("SP-AA1");
        sponsor.setAntiquityMonths(10);
        sponsor.setMoneyPerMonth(2000.0);
        sponsor.setName("CocaCola");
    }

    @Test
    void constructorAndSetters() {
        assertEquals("SP-AA1", sponsor.getId());
        assertEquals(10, (int) sponsor.getAntiquityMonths());
        assertEquals(2000.0, (double) sponsor.getMoneyPerMonth());
        assertEquals("CocaCola", sponsor.getName());
    }
}
