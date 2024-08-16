package com.socialAssistance.socialAssistance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String charity;

    private String email;

    private Long phone;

    private String password;



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TrackingSystem> trackingSystems = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Requirement> requirements = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharity() {
        return charity;
    }

    public void setCharity(String charity) {
        this.charity = charity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TrackingSystem> getTrackingSystems() {
        return trackingSystems;
    }

    public void setTrackingSystems(List<TrackingSystem> trackingSystems) {
        this.trackingSystems = trackingSystems;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }
}
