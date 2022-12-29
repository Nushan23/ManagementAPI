package com.satellite_api_master.satellite_management.controller;

import java.util.Optional;
import com.satellite_api_master.satellite_management.model.ManagementModel;
import com.satellite_api_master.satellite_management.service_implementation.ManagementImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin("*")
public class ManagementController {

    @Autowired
    private ManagementImplementation managementImplementation;

    @PostMapping(value = "launchSatellite")
    public ManagementModel saveCatalog(@RequestBody ManagementModel managementModel){
        System.out.println("Satellite launched successfully");
        managementImplementation.launchSatellite((managementModel));
        return managementModel;
    }

    @GetMapping(value = "getLaunchData")
    public List<ManagementModel> getLaunchData(){
        return  managementImplementation.getLaunchData();
    }

    @GetMapping(value = "getLaunchDataById/{id}")
    public ManagementModel getLaunchDataById(@PathVariable ("id") Long id){
        Optional<ManagementModel> dataRow = managementImplementation.getLaunchDataById(id);
        if(dataRow.isPresent()){
            return dataRow.get();
        }
        return null;
    }

    @PutMapping("updateData")
    public ManagementModel updateData(@RequestBody ManagementModel managementModel){
        return managementImplementation.updateData(managementModel);
    }

    @DeleteMapping("decommissionSatellite")
    public String decommissionSatellite(@RequestParam long id){
        managementImplementation.decommissionSatellite(id);
        return "Satellite deleted!";
    }

}

