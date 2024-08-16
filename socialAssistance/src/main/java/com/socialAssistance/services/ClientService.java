package com.socialAssistance.socialAssistance.services;

import com.socialAssistance.socialAssistance.entities.Client;
import com.socialAssistance.socialAssistance.entities.Requirement;
import com.socialAssistance.socialAssistance.entities.TrackingSystem;
import com.socialAssistance.socialAssistance.repositories.ClientRepository;
import com.socialAssistance.socialAssistance.repositories.RequirementRepository;
import com.socialAssistance.socialAssistance.request.SignUpRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final RequirementRepository requirementRepository;

    public ClientService(ClientRepository clientRepository, RequirementRepository requirementRepository) {
        this.clientRepository = clientRepository;
        this.requirementRepository = requirementRepository;
    }




    public Requirement createRequirement(Long clientId, String name, String lastName, String phone, String address, String requirementMessage) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));

        Requirement requirement = new Requirement();
        requirement.setName(name);
        requirement.setLastName(lastName);
        requirement.setPhone(phone);
        requirement.setAddress(address);
        requirement.setRequirementMessage(requirementMessage);
        requirement.setClient(client);

        return requirementRepository.save(requirement);
    }



    // name, lastName will add
    public void signUpClient(SignUpRequest signUpRequest) {
        if (emailExists(signUpRequest.getEmail())) {
            throw new IllegalArgumentException("Email address already exists.");
        }

        Client client = new Client();
        client.setEmail(signUpRequest.getEmail());
        client.setPassword(signUpRequest.getPassword());

        clientRepository.save(client);
    }



    public List<TrackingSystem> getTrackingSystemsByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow();

        return client.getTrackingSystems();
    }


    public List<Requirement> getClientRequirements(Long clientId) {
        return requirementRepository.findByClientId(clientId);
    }



    public boolean checkClientCredentials(String email, String password) {
        Client client = clientRepository.findByEmail(email);

        if (client != null && client.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean emailExists(String email) {
        return clientRepository.existsByEmail(email);
    }


}
