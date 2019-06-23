package me.jorgebernal.api_demo.business_controllers;

import me.jorgebernal.api_demo.daos.AuthorDao;
import me.jorgebernal.api_demo.documents.Author;
import me.jorgebernal.api_demo.dtos.AuthorCreationDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

}
