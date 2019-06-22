package me.jorgebernal.api_demo.documents;

public class IdentityDocument {

    private String type;

    private String number;

    public IdentityDocument(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public void change(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
