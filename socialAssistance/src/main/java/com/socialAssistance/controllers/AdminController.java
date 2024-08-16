package com.socialAssistance.socialAssistance.controllers;

import com.socialAssistance.socialAssistance.entities.Requirement;
import com.socialAssistance.socialAssistance.entities.enums.Status;
import com.socialAssistance.socialAssistance.request.SignUpRequest;
import com.socialAssistance.socialAssistance.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }



    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest) {
        adminService.signUpAdmin(signUpRequest);
        return new ResponseEntity<>("Admin signed up successfully.", HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        boolean isValidUser = adminService.checkAdminCredentials(email, password);

        if (isValidUser) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }





    @GetMapping("/requirements")
    public List<Requirement> getAllRequirements() {
        return adminService.getAllRequirements();
    }


    @GetMapping("/requirements/{requirementId}")
    public Requirement getRequirementById(@PathVariable Long requirementId) {
        return adminService.getRequirementById(requirementId);
    }


    @PostMapping("/requirements/{requirementId}/status")
    public void addRequirementStatus(@PathVariable Long requirementId, @RequestBody String newStatus) {
        adminService.addRequirementStatus(requirementId, newStatus);
    }



}
