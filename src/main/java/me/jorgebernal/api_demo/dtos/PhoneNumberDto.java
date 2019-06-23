package me.jorgebernal.api_demo.dtos;

import me.jorgebernal.api_demo.exceptions.BadRequestException;

public class PhoneNumberDto {

    private Long phoneNumber;

    public PhoneNumberDto() {
    }

    public PhoneNumberDto(Long phoneNumber) {
        System.out.println("My number is" + phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void verify() {
        if (phoneNumber == null || phoneNumber < 100000000) {
            throw new BadRequestException("Invalid phone number");
        }
    }


}
