package com.example.crm.Data;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.catalina.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import io.micrometer.common.util.StringUtils;

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

    // Create Data Entry
    public void createDataEntry(DataEntity data) {
        Optional<DataEntity> dataOptional = dataRepository.findDataEntryByPan(data.getPan());
        if (dataOptional.isPresent()) {
            throw new IllegalStateException("data with same Pan already exists");
        }
        dataRepository.save(data);
    }

    // Delete Data Entry
    public void deleteDataEntry(Long userId) {
        boolean exists = dataRepository.existsById(userId);
        if (!exists) {
            throw new ResourceNotFoundException("Data with id " + userId + " doesn't exists");
        }
        dataRepository.deleteById(userId);
    }

    // Update Data Entry
    @Transactional
    public void updateDataEntry(Long dataId, String rmName, String phoneNumber) {
        DataEntity data = dataRepository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Data with id " + dataId + " does not exists"));
        if (StringUtils.isNotEmpty(phoneNumber) && StringUtils.isNotEmpty(rmName)
                && !Objects.equals(data.getPhoneNumber(), phoneNumber) && !Objects.equals(data.getRmName(), rmName)) {
            data.setPhoneNumber(phoneNumber);
            data.setRmName(rmName);
            dataRepository.save(data);
        }
    }

}
