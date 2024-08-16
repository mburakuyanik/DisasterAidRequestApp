package com.socialAssistance.socialAssistance.entities;

import com.socialAssistance.socialAssistance.entities.enums.RequirementType;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "requirements")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Enumerated
//    private RequirementType requirementType;

    private String requirementMessage;

    private String name;

    private String lastName;

    private String phone;

    private String address;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id")
    private Admin admin;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trackingSystem_id")
    private TrackingSystem trackingSystem;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public RequirementType getRequirementType() {
//        return requirementType;
//    }

//    public void setRequirementType(RequirementType requirementType) {
//        this.requirementType = requirementType;
//    }

    public String getRequirementMessage() {
        return requirementMessage;
    }

    public void setRequirementMessage(String requirementMessage) {
        this.requirementMessage = requirementMessage;
    }

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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TrackingSystem getTrackingSystem() {
        return trackingSystem;
    }

    public void setTrackingSystem(TrackingSystem trackingSystem) {
        this.trackingSystem = trackingSystem;
    }


}
