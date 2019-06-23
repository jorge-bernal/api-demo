package me.jorgebernal.api_demo.dtos;

import me.jorgebernal.api_demo.documents.Author;

import java.util.List;

public class AuthorDto {

    private String id;

    private String name;

    private List<Long> phoneNumbers;

    private String identityDocumentType;

    private String identityDocumentNumber;

    public AuthorDto() {
        //empty for
    }

    public AuthorDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.phoneNumbers = author.getPhoneNumbers();
        this.identityDocumentType = author.getIdentityDocument().getType();
        this.identityDocumentNumber = author.getIdentityDocument().getNumber();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Long> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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
}
