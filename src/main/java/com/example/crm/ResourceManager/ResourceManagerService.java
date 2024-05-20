package com.example.crm.ResourceManager;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResourceManagerService {

    private final ResourceManagerRepository resourceManagerRepository;

    @Autowired
    public ResourceManagerService(ResourceManagerRepository resourceManagerRepository) {
        this.resourceManagerRepository = resourceManagerRepository;
    }

    // Get All RM's
    public List<ResourceManager> getAllResourceManagers() {
        return resourceManagerRepository.findAll();
    }

    // Creates the RM
    public void createResourceManager(ResourceManager resourceManager) {
        Optional<ResourceManager> resourceManagerOptional = resourceManagerRepository
                .findResourceManagerByEmail(resourceManager.getEmail());
        if (resourceManagerOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        resourceManagerRepository.save(resourceManager);
    }

    // Delete the RM
    public void deleteResourceManager(Long rmId) {
        boolean exists = resourceManagerRepository.existsById(rmId);
        if (!exists) {
            throw new IllegalStateException("Resource manager with id " + rmId + "does not exists");
        }
        resourceManagerRepository.deleteById(rmId);
    }

    // Update RM password
    @Transactional
    public void updateResourceManagerPassword(Long rmId, String password) {
        ResourceManager resourceManager = resourceManagerRepository.findById(rmId)
                .orElseThrow(() -> new IllegalStateException(
                        "Resource Manager with id" + rmId + " does not exists"));
        if (password != null &&
                password.length() > 0 && !Objects.equals(resourceManager.getPassword(), password)) {
            resourceManager.setPassword(password);
        }

    }
}
