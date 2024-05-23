package com.example.crm.ResourceManager;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.crm.ResourceManager.ResourceNotFoundException;
import org.apache.commons.lang3.StringUtils;

@Service
public class ResourceManagerService {

    private final ResourceManagerRepository resourceManagerRepository;

    @Autowired
    public ResourceManagerService(ResourceManagerRepository resourceManagerRepository) {
        this.resourceManagerRepository = resourceManagerRepository;
    }

    // Get All RM's
    public List<ResourceManagerEntity> getAllResourceManagers() {
        return resourceManagerRepository.findAll();
    }

    // Creates the RM
    public void createResourceManager(ResourceManagerEntity resourceManager) {
        Optional<ResourceManagerEntity> resourceManagerOptional = resourceManagerRepository
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
            // throw new IllegalStateException("Resource manager with id " + rmId + "does
            // not exists");
            throw new ResourceNotFoundException("Resource manager with id " + rmId + " does not exists");
        }
        resourceManagerRepository.deleteById(rmId);
    }

    // Update RM password
    @Transactional
    public void updateResourceManagerPassword(Long rmId, String password) {
        ResourceManagerEntity resourceManager = resourceManagerRepository.findById(rmId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource Manager with id " + rmId + " does not exists"));
        if (StringUtils.isNotEmpty(password) && !Objects.equals(resourceManager.getPassword(), password)) {
            resourceManager.setPassword(password); // Update the password in the object
            resourceManagerRepository.save(resourceManager); // Save the updated object to the database
        }

    }
}
