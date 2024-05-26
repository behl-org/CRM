package com.example.crm.Data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    @Bean(name = "twoBean")
    CommandLineRunner commandLineRunner(
            DataRepository repository) {
        return args -> {
            DataEntity rootUser = new DataEntity(
                    "rm name",
                    "PAN",
                    "user NAme",
                    "8581581");

            repository.save(rootUser);
        };
    }
}