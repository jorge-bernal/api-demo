package me.jorgebernal.api_demo.api_controllers;

import me.jorgebernal.api_demo.ApiTestConfig;
import me.jorgebernal.api_demo.dtos.AuthorCreationDto;
import me.jorgebernal.api_demo.dtos.AuthorDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import me.jorgebernal.api_demo.dtos.PhoneNumberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    @Test
    void testAddPhoneNumberAndGetAuthorsWithPhoneNumbers() {
        List<List<String>> authors = new ArrayList<>();

        authors.add(Arrays.asList("Author1", "NIF", "00000000A"));
        authors.add(Arrays.asList("Author2", "NIF", "00000000B"));

        List<String> ids = new ArrayList<>();

        AuthorCreationDto authorCreationDto;

        authors.forEach(
                author ->
                        ids.add(
                                this.webTestClient
                                        .post().uri(AuthorResource.AUTHORS)
                                        .body(BodyInserters.fromObject(new AuthorCreationDto(author.get(0), author.get(1), author.get(2))))
                                        .exchange()
                                        .expectBody(IdDto.class)
                                        .returnResult().getResponseBody().getId()
                        )
        );

        IntStream.range(0, 3).forEach(
                i -> this.webTestClient
                        .post().uri(AuthorResource.AUTHORS + AuthorResource.ID_ID + AuthorResource.PHONE_NUMBERS, ids.get(0))
                        .body(BodyInserters.fromObject(new PhoneNumberDto(633532277L + i)))
                        .exchange()
        );

        IntStream.range(0, 3).forEach(
                i -> this.webTestClient
                        .post().uri(AuthorResource.AUTHORS + AuthorResource.ID_ID + AuthorResource.PHONE_NUMBERS, ids.get(1))
                        .body(BodyInserters.fromObject(new PhoneNumberDto(688987733L + i)))
                        .exchange()
        );


        authorCreationDto = new AuthorCreationDto("NoPhone", "DNI", "47637284J");
        this.webTestClient
                .post().uri(AuthorResource.AUTHORS)
                .body(BodyInserters.fromObject(authorCreationDto))
                .exchange();

        List<AuthorDto> authorsWithPhone = this.webTestClient
                .get().uri(AuthorResource.AUTHORS + AuthorResource.REGISTERED_PHONE)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AuthorDto.class)
                .returnResult().getResponseBody();

        assertEquals(2, authorsWithPhone.size());

        List<Long> phoneNumbers = new ArrayList<>();
        authorsWithPhone.forEach(authorDto -> authorDto.getPhoneNumbers().forEach(phoneNumbers::add));
        assertEquals(6, phoneNumbers.size());

        assertTrue(phoneNumbers.contains(633532277L));
        assertTrue(phoneNumbers.contains(633532279L));
        assertTrue(phoneNumbers.contains(688987733L));

    }

}
