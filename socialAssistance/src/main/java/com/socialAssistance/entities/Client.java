package com.socialAssistance.socialAssistance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String email;

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
