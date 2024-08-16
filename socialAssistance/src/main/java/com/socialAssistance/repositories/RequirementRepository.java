package com.socialAssistance.socialAssistance.repositories;

import com.socialAssistance.socialAssistance.entities.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {

    List<Requirement> findByClientId(Long clientId);
}
