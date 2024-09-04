// DataController.java
package com.example.hexagonal.interface.controller;

import com.example.hexagonal.application.service.DataService;
import com.example.hexagonal.domain.model.DataModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/filtered-data")
    public List<DataModel> getFilteredData(@RequestParam String param) {
        return dataService.getFilteredData(param);
    }

    @GetMapping("/detail-data")
    public List<DataModel> getDetailData(@RequestParam String type) {
        return dataService.getDetailData(type);
    }
}
