package me.jorgebernal.api_demo.api_controllers;

import me.jorgebernal.api_demo.ApiTestConfig;
import me.jorgebernal.api_demo.dtos.AuthorCreationDto;
import me.jorgebernal.api_demo.dtos.BookDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ApiTestConfig
public class BookReouseceIT {

    @Autowired
    private WebTestClient webTestClient;

    private AuthorCreationDto authorCreationDto;
    private BookDto bookDto;

    @BeforeEach
    void before() {
        authorCreationDto = new AuthorCreationDto("Jorge", "NIF", "0000000");
        bookDto = new BookDto();
        bookDto.setName("Name of The Wind");
        bookDto.setPrice(29.99);
    }

    @Test
    void testNoFoundExceptionCreateBookWithNoAuthor() {

        bookDto.setAuthorId("doesn't exist");

        webTestClient
                .post().uri(BookResource.BOOKS)
                .body(BodyInserters.fromObject(bookDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testCreate() {
        String authorId = webTestClient
                .post().uri(AuthorResource.AUTHORS)
                .body(BodyInserters.fromObject(authorCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class)
                .returnResult().getResponseBody().getId();

        bookDto.setAuthorId(authorId);

        webTestClient
                .post().uri(BookResource.BOOKS)
                .body(BodyInserters.fromObject(bookDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IdDto.class);
    }

    @Test
    void testBadRequestExceptionCreate() {

        bookDto.setName(null);

        webTestClient
                .post().uri(BookResource.BOOKS)
                .body(BodyInserters.fromObject(bookDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);

    }
}
