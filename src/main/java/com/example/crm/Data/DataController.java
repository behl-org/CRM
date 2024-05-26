package com.example.crm.Data;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
