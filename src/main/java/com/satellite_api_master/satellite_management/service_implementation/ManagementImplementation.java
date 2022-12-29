package com.satellite_api_master.satellite_management.service_implementation;


import java.util.Optional;
import com.satellite_api_master.satellite_management.model.ManagementModel;
import com.satellite_api_master.satellite_management.repository.ManagementRepository;
import com.satellite_api_master.satellite_management.service_interface.ManagementInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementImplementation implements ManagementInterface {

    @Autowired
    private ManagementRepository managementRepository;
    @Override
    public ManagementModel launchSatellite(ManagementModel managementModel) {
        return managementRepository.save(managementModel);
    }

    @Override
    public ManagementModel updateData(ManagementModel managementModel) {
        ManagementModel existingManagementModel = managementRepository.findById(managementModel.getSatelliteId()).orElse(null);
        existingManagementModel.setOrbit(managementModel.getOrbit());
        existingManagementModel.setCurrentLocation(managementModel.getCurrentLocation());
        existingManagementModel.setPowerPercentage(managementModel.getPowerPercentage());
        existingManagementModel.setStatus(managementModel.getStatus());
        existingManagementModel.setLaunchedDate(managementModel.getLaunchedDate());
        return managementRepository.save(existingManagementModel);

    }

    @Override
    public List<ManagementModel> getLaunchData() {
        return (List<ManagementModel>) managementRepository.findAll();
    }

    @Override
    public Optional<ManagementModel> getLaunchDataById(long id) {
        return (Optional<ManagementModel>) managementRepository.findById(id);
    }

    @Override
    public void decommissionSatellite(long id) {
        managementRepository.deleteById(id);

    }
}
