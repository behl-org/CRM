package com.example.crm.Data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    // List All Data Entries
    public List<DataEntity> getAllUsersData() {
        return dataRepository.findAll();
    }

    // Get Single Data Entry
    public Optional<DataEntity> getDataById(Long dataId) {
        return dataRepository.findById(dataId);
    }

}
