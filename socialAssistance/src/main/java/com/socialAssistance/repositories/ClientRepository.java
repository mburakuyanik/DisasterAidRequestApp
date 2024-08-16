package com.socialAssistance.socialAssistance.repositories;

import com.socialAssistance.socialAssistance.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByEmail(String email);

    Client findByEmail(String email);

}
