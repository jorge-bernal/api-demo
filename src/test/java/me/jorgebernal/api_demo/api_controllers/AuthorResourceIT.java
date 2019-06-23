package me.jorgebernal.api_demo.api_controllers;

import me.jorgebernal.api_demo.ApiTestConfig;
import me.jorgebernal.api_demo.dtos.AuthorCreationDto;
import me.jorgebernal.api_demo.dtos.AuthorDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    void testGetNoContent() {
        AuthorCreationDto authorCreationDto = new AuthorCreationDto("Jorge", "NIF", "0000000");

        this.webTestClient
                .get().uri(AuthorResource.AUTHORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AuthorDto.class);
    }

    @Test
    void testGetContent() {
        AuthorCreationDto authorCreationDto = new AuthorCreationDto("Jorge", "NIF", "0000000");
        this.webTestClient
                .post().uri(AuthorResource.AUTHORS)
                .body(BodyInserters.fromObject(authorCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class);

        AuthorDto authorDto = this.webTestClient
                .get().uri(AuthorResource.AUTHORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AuthorDto.class)
                .returnResult().getResponseBody().get(0);

        assertEquals("Jorge", authorDto.getName());
        assertEquals("NIF", authorDto.getIdentityDocumentType());
        assertEquals("0000000", authorDto.getIdentityDocumentNumber());

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
