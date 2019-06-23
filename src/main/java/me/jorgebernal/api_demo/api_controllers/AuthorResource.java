package me.jorgebernal.api_demo.api_controllers;

import me.jorgebernal.api_demo.business_controllers.AuthorBusinessController;
import me.jorgebernal.api_demo.dtos.AuthorCreationDto;
import me.jorgebernal.api_demo.dtos.AuthorDto;
import me.jorgebernal.api_demo.dtos.IdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = AuthorResource.AUTHORS)
public class AuthorResource {

    static final String AUTHORS = "/authors";

    private AuthorBusinessController authorBusinessController;

    @Autowired
    public AuthorResource(AuthorBusinessController authorBusinessController) {
        this.authorBusinessController = authorBusinessController;
    }

    @PostMapping
    public IdDto create(@RequestBody AuthorCreationDto authorCreationDto) {
        authorCreationDto.verify();
        return this.authorBusinessController.create(authorCreationDto);
    }

    @GetMapping
    public List<AuthorDto> getAll() {
        return authorBusinessController.getAll();
    }

}
