package com.example.crm.ResourceManager;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceManagerRepository extends JpaRepository<ResourceManager, Long> {

    Optional<ResourceManager> findResourceManagerByEmail(String email);
}
