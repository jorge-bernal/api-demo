package me.jorgebernal.api_demo.api_controllers;

import me.jorgebernal.api_demo.ApiTestConfig;
import me.jorgebernal.api_demo.dtos.AuthorCreationDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ApiTestConfig
public class AuthorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateOk() {
        AuthorCreationDto authorCreationDto = new AuthorCreationDto("Jorge", "NIF", "0000000");
        this.webTestClient
                .post().uri(AuthorResource.AUTHORS)
                .body(BodyInserters.fromObject(authorCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class);
    }

    @Test
    void testCreateException() {
        AuthorCreationDto authorCreationDto1 = new AuthorCreationDto(null, "NIF", "0000000");
        this.webTestClient
                .post().uri(AuthorResource.AUTHORS)
                .body(BodyInserters.fromObject(authorCreationDto1))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);

        AuthorCreationDto authorCreationDto2 = new AuthorCreationDto("Jorge", null, "0000000");
        this.webTestClient
                .post().uri(AuthorResource.AUTHORS)
                .body(BodyInserters.fromObject(authorCreationDto2))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);

        AuthorCreationDto authorCreationDto3 = new AuthorCreationDto("Jorge", "NIF", null);
        this.webTestClient
                .post().uri(AuthorResource.AUTHORS)
                .body(BodyInserters.fromObject(authorCreationDto3))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
