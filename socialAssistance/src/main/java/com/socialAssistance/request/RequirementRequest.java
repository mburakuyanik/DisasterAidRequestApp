package com.socialAssistance.socialAssistance.request;

public class RequirementRequest {

    private String name;

    private String lastName;

    private String phone;

    private String address;

    private String requirementMessage;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequirementMessage() {
        return requirementMessage;
    }

    public void setRequirementMessage(String requirementMessage) {
        this.requirementMessage = requirementMessage;
    }
}

