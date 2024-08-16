package com.socialAssistance.socialAssistance.controllers;

import com.socialAssistance.socialAssistance.entities.Client;
import com.socialAssistance.socialAssistance.entities.Requirement;
import com.socialAssistance.socialAssistance.entities.TrackingSystem;
import com.socialAssistance.socialAssistance.request.RequirementRequest;
import com.socialAssistance.socialAssistance.request.SignUpRequest;
import com.socialAssistance.socialAssistance.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }




    @PostMapping("/{clientId}/createRequirements")
    public Requirement createRequirement(@PathVariable Long clientId, @RequestBody RequirementRequest request) {
        return clientService.createRequirement(clientId, request.getName(), request.getLastName(),
                request.getPhone(), request.getAddress(), request.getRequirementMessage());
    }




    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest) {
        clientService.signUpClient(signUpRequest);
        return new ResponseEntity<>("Client signed up successfully.", HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        boolean isValidUser = clientService.checkClientCredentials(email, password);

        if (isValidUser) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


    @GetMapping("/{clientId}/trackingSystems")
    public List<TrackingSystem> showTrackingSystem(@PathVariable Long clientId) {
        return clientService.getTrackingSystemsByClientId(clientId);
    }




    @GetMapping("/{clientId}/requirements")
    public List<Requirement> getClientRequirements(@PathVariable Long clientId) {
        return clientService.getClientRequirements(clientId);
    }

}
