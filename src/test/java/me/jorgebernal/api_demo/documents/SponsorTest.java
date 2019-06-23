package me.jorgebernal.api_demo.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SponsorTest {

    Sponsor sponsor;

    @BeforeEach
    void before() {
        sponsor = new Sponsor("SP-AA11", 1.0);
        sponsor.setMoneyPerMonth(2000.0);
        sponsor.setName("CocaCola");
    }

    @Test
    void constructorAndSetters() {
        assertEquals(2000.0, (double) sponsor.getMoneyPerMonth());
        assertEquals("CocaCola", sponsor.getName());
        assertNotNull(sponsor.getContractStart());
    }
}
