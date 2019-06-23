package me.jorgebernal.api_demo.dtos;

import me.jorgebernal.api_demo.exceptions.BadRequestException;

public class AuthorCreationDto {

    private String name;

    private String identityDocumentType;

    private String identityDocumentNumber;

    public AuthorCreationDto() {
        //empty for framework
    }

    public AuthorCreationDto(String name, String identityDocumentType, String identityDocumentNumber) {
        this.name = name;
        this.identityDocumentType = identityDocumentType;
        this.identityDocumentNumber = identityDocumentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityDocumentType() {
        return identityDocumentType;
    }

    public void setIdentityDocumentType(String identityDocumentType) {
        this.identityDocumentType = identityDocumentType;
    }

    public String getIdentityDocumentNumber() {
        return identityDocumentNumber;
    }

    public void setIdentityDocumentNumber(String identityDocumentNumber) {
        this.identityDocumentNumber = identityDocumentNumber;
    }

    public void verify() {
        if (this.name == null || this.identityDocumentNumber == null
                || this.identityDocumentType == null
                || this.name.isEmpty()
                || this.identityDocumentType.isEmpty()
                || this.identityDocumentNumber.isEmpty()) {
            throw new BadRequestException("Incomplete AuthorCreationDto");
        }
    }
}
