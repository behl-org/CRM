package com.example.crm.ResourceManager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "crm_rm")

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ResourceManagerEntity {
    @Id
    @SequenceGenerator(name = "rm_sequence", sequenceName = "rm_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rm_sequence")
    private Long id;
    private String name;
    private String email;
    private String password;

    public ResourceManagerEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
