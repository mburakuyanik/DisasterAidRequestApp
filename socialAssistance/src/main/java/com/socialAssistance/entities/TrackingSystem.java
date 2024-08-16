package com.socialAssistance.socialAssistance.entities;

import com.socialAssistance.socialAssistance.entities.enums.Status;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@ToString
@Table(name = "trackingSystems")
public class TrackingSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String status;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id")
    private Admin admin;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_id")
    private Requirement requirement;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }
}
