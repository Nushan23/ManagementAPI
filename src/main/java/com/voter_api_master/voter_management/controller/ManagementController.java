package com.voter_api_master.voter_management.controller;

import java.util.Optional;
import com.voter_api_master.voter_management.model.ManagementModel;
import com.voter_api_master.voter_management.service_implementation.ManagementImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin("*")
public class ManagementController {

    @Autowired
    private ManagementImplementation managementImplementation;

    @PostMapping(value = "launchVoter")
    public ManagementModel saveCatalog(@RequestBody ManagementModel managementModel){
        System.out.println("Voter launched successfully");
        managementImplementation.launchVoter((managementModel));
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

    @DeleteMapping("decommissionVoter")
    public String decommissionVoter(@RequestParam long id){
        managementImplementation.decommissionVoter(id);
        return "Voter deleted!";
    }

}

