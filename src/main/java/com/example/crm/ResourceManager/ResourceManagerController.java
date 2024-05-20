package com.example.crm.ResourceManager;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/resources")
public class ResourceManagerController {

    @Autowired
    private ResourceManagerService resourceManagerService;

    public ResourceManagerController(ResourceManagerService resourceManagerService) {
        this.resourceManagerService = resourceManagerService;
    }

    @GetMapping
    public List<ResourceManager> getAllResourceManagers() {
        return resourceManagerService.getAllResourceManagers();
    }

    @PostMapping(path = "/add")
    public void createResourceManager(@RequestBody ResourceManager resourceManager) {
        resourceManagerService.createResourceManager(resourceManager);

    }

    @DeleteMapping(path = "/delete/{rmId}")
    public void deleteResourceManager(@PathVariable("rmId") Long rmId) {
        resourceManagerService.deleteResourceManager(rmId);
    }

    @PutMapping(path = "update/{rmId}")
    public void updateResourceManagerPassword(
            @PathVariable("rmId") Long rmId,
            @RequestParam(required = false) String password) {
        resourceManagerService.updateResourceManagerPassword(rmId, password);
    }

}
