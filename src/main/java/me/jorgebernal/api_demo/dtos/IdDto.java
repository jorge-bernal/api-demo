package me.jorgebernal.api_demo.dtos;

import me.jorgebernal.api_demo.exceptions.BadRequestException;

public class IdDto {

    private String id;

    public IdDto(String id) {
        this.id = id;
    }

    public IdDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void validate() {
        if (id == null || id.isEmpty()) {
            throw new BadRequestException("Invalid id");
        }
    }
}
