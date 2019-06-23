package me.jorgebernal.api_demo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Author {

    @Id
    private String id;

    private String name;

    private List<Long> phoneNumbers;

    private IdentityDocument identityDocument;

    public Author() {
        //empty for builder
    }

    public Author(String name, List<Long> phoneNumbers, IdentityDocument identityDocument) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.identityDocument = identityDocument;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
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

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id.equals(author.id);
    }

    public static class Builder {

        private Author author;

        private List<Long> phoneNumbers;

        private Builder() {
            author = new Author();
        }

        public Builder name(String name) {
            author.setName(name);
            return this;
        }

        public Builder phoneNumber(long phoneNumber) {
            if (this.phoneNumbers == null) {
                this.phoneNumbers = new ArrayList<>();
            }
            this.phoneNumbers.add(phoneNumber);
            return this;
        }

        public Builder identityDocument(String type, String number) {
            this.author.setIdentityDocument(new IdentityDocument(type, number));
            return this;
        }

        public Author build() {
            this.author.setPhoneNumbers(this.phoneNumbers);
            return this.author;
        }

    }

}
