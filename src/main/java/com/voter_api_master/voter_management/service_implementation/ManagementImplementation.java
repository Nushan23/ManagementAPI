package com.voter_api_master.voter_management.service_implementation;


import java.util.Optional;
import com.voter_api_master.voter_management.model.ManagementModel;
import com.voter_api_master.voter_management.repository.ManagementRepository;
import com.voter_api_master.voter_management.service_interface.ManagementInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementImplementation implements ManagementInterface {

    @Autowired
    private ManagementRepository managementRepository;
    @Override
    public ManagementModel registerVoter(ManagementModel managementModel) {
        return managementRepository.save(managementModel);
    }

    @Override
    public ManagementModel updateData(ManagementModel managementModel) {
        ManagementModel existingManagementModel = managementRepository.findById(managementModel.getVoterId()).orElse(null);
        existingManagementModel.setStatus(managementModel.getStatus());
        existingManagementModel.setRegisteredDate(managementModel.getRegisteredDate());
        return managementRepository.save(existingManagementModel);

    }

    @Override
    public List<ManagementModel> getRegisteredData() {
        return (List<ManagementModel>) managementRepository.findAll();
    }

    @Override
    public Optional<ManagementModel> getRegisteredDataById(long id) {
        return (Optional<ManagementModel>) managementRepository.findById(id);
    }

    @Override
    public void decommissionVoter(long id) {
        managementRepository.deleteById(id);

    }
}
