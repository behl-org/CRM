package com.example.crm.ResourceManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceManagerConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            ResourceManagerRepository repository) {
        return args -> {
            ResourceManager rootUser = new ResourceManager(
                    "root",
                    "root@gmail.com",
                    "passsword");

            repository.save(rootUser);
        };
    }
}
