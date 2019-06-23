package me.jorgebernal.api_demo.business_controllers;

import me.jorgebernal.api_demo.daos.AuthorDao;
import me.jorgebernal.api_demo.documents.Author;
import me.jorgebernal.api_demo.dtos.AuthorCreationDto;
import me.jorgebernal.api_demo.dtos.AuthorDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import me.jorgebernal.api_demo.dtos.PhoneNumberDto;
import me.jorgebernal.api_demo.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthorBusinessController {

    private AuthorDao authorDao;

    @Autowired
    public AuthorBusinessController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public IdDto create(AuthorCreationDto authorCreationDto) {
        Author author = Author.builder().name(authorCreationDto.getName())
                .identityDocument(authorCreationDto.getIdentityDocumentType()
                        , authorCreationDto.getIdentityDocumentNumber()).build();
        authorDao.save(author);
        return new IdDto(author.getId());
    }

    public List<AuthorDto> getAll() {
        List<Author> authors = authorDao.findAll();
        return authors.stream().map(AuthorDto::new).collect(Collectors.toList());
    }

    public IdDto addPhoneNumber(String id, PhoneNumberDto phoneNumberDto) {
        Author author = authorDao.findById(id).orElseThrow(() -> new NotFoundException("Author with id: " + id + "doesn't exist"));
        author.addPhoneNumber(phoneNumberDto.getPhoneNumber());
        authorDao.save(author);
        return new IdDto(author.getId());
    }
}
