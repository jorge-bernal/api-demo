package me.jorgebernal.api_demo.api_controllers;

import me.jorgebernal.api_demo.ApiTestConfig;
import me.jorgebernal.api_demo.dtos.IdDto;
import me.jorgebernal.api_demo.dtos.SponsorCreationDto;
import me.jorgebernal.api_demo.dtos.SponsorDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ApiTestConfig
public class SuggestionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateAndReadAll() {
        SponsorCreationDto sponsorCreationDto = new SponsorCreationDto("SPONSOR-1", 15000.0);
        this.webTestClient
                .post().uri(SponsorResource.SPONSORS)
                .body(BodyInserters.fromObject(sponsorCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class);

        this.webTestClient
                .get().uri(SponsorResource.SPONSORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SponsorDto.class);
    }

    @Test
    void testDeleteExistingId() {
        SponsorCreationDto sponsorCreationDto = new SponsorCreationDto("SPONSOR-1", 15000.0);
        String id = this.webTestClient
                .post().uri(SponsorResource.SPONSORS)
                .body(BodyInserters.fromObject(sponsorCreationDto))
                .exchange()
                .expectBody(IdDto.class)
                .returnResult().getResponseBody().getId();

        this.webTestClient
                .delete().uri(SponsorResource.SPONSORS + SponsorResource.ID_ID, id)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testDeleteNonExistingId() {
        this.webTestClient
                .delete().uri(SponsorResource.SPONSORS + SponsorResource.ID_ID, "doesn't exist")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testSponsorException() {
        SponsorCreationDto sponsorCreationDto = new SponsorCreationDto(null, 15000.0);
        this.webTestClient
                .post().uri(SponsorResource.SPONSORS)
                .body(BodyInserters.fromObject(sponsorCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }


}
