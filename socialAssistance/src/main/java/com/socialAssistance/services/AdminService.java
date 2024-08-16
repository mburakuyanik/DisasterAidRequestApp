package com.socialAssistance.socialAssistance.services;

import com.socialAssistance.socialAssistance.entities.Admin;
import com.socialAssistance.socialAssistance.entities.Client;
import com.socialAssistance.socialAssistance.entities.Requirement;
import com.socialAssistance.socialAssistance.entities.TrackingSystem;
import com.socialAssistance.socialAssistance.entities.enums.Status;
import com.socialAssistance.socialAssistance.repositories.AdminRepository;
import com.socialAssistance.socialAssistance.repositories.RequirementRepository;
import com.socialAssistance.socialAssistance.repositories.TrackingSystemRepository;
import com.socialAssistance.socialAssistance.request.SignUpRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    private final RequirementRepository requirementRepository;

    private final TrackingSystemRepository trackingSystemRepository;


    public AdminService(AdminRepository adminRepository, RequirementRepository requirementRepository, TrackingSystemRepository trackingSystemRepository) {
        this.adminRepository = adminRepository;
        this.requirementRepository = requirementRepository;
        this.trackingSystemRepository = trackingSystemRepository;
    }



    public void signUpAdmin(SignUpRequest signUpRequest) {
        if (emailExists(signUpRequest.getEmail())) {
            throw new IllegalArgumentException("Email address already exists.");
        }

        Admin admin = new Admin();
        admin.setEmail(signUpRequest.getEmail());
        admin.setPassword(signUpRequest.getPassword());

        adminRepository.save(admin);
    }



    // Requirements

    public List<Requirement> getAllRequirements() {
        return requirementRepository.findAll();
    }


    public Requirement getRequirementById(Long requirementId) {
        return requirementRepository.findById(requirementId).orElseThrow();
    }


    public void addRequirementStatus(Long requirementId, String newStatus) {
        Requirement requirement = requirementRepository.findById(requirementId).orElseThrow();

        TrackingSystem trackingSystem = requirement.getTrackingSystem();
        trackingSystem.setStatus(newStatus);
        trackingSystemRepository.save(trackingSystem);
    }


    public boolean emailExists(String email) {
        return adminRepository.existsByEmail(email);
    }


    public boolean checkAdminCredentials(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);

        if (admin != null && admin.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }


}
