package com.example.crm.Data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataEntity, Long> {

    Optional<DataEntity> findDataEntryByPan(String pan);
}
