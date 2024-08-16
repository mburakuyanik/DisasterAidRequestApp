package com.socialAssistance.socialAssistance.repositories;

import com.socialAssistance.socialAssistance.entities.Admin;
import com.socialAssistance.socialAssistance.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    boolean existsByEmail(String email);

    Admin findByEmail(String email);

}
