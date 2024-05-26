package com.example.crm.Data;

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
@RequestMapping(path = "api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/user")
    public List<DataEntity> getAllUsersData() {
        return dataService.getAllUsersData();
    }

    @GetMapping("/user/{dataId}")
    public Optional<DataEntity> getDataById(@PathVariable Long dataId) {
        return dataService.getDataById(dataId);
    }

    @PostMapping(path = "/add")
    public void createDataEntry(@RequestBody DataEntity data) {
        dataService.createDataEntry(data);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void deleteDataEntry(@PathVariable("userId") long userId) {
        dataService.deleteDataEntry(userId);
    }

    @PutMapping(path = "update/{userId}")
    public void updateDataEntry(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String phoneNumber, String rmName) {
        dataService.updateDataEntry(userId, rmName, phoneNumber);
    }

}
