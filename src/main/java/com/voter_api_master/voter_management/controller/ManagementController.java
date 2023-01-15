package com.voter_api_master.voter_management.controller;

import java.util.Optional;
import com.voter_api_master.voter_management.model.ManagementModel;
import com.voter_api_master.voter_management.service_implementation.ManagementImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/management")

@CrossOrigin("*")
public class ManagementController {

    @Autowired
    private ManagementImplementation managementImplementation;

    @PostMapping(value = "registerVoter")
    public ManagementModel saveCatalog(@RequestBody ManagementModel managementModel){
        System.out.println("Voter registered successfully");
        managementImplementation.registerVoter((managementModel));
        return managementModel;
    }

    @GetMapping(value = "getRegisterData")
    public List<ManagementModel> getRegisterData(){
        return  managementImplementation.getRegisteredData();
    }

    @GetMapping(value = "getRegisterDataById/{id}")
    public ManagementModel getRegisterDataById(@PathVariable ("id") Long id){
        Optional<ManagementModel> dataRow = managementImplementation.getRegisteredDataById(id);
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

