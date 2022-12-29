package com.satellite_api_master.satellite_management.service_interface;


import java.util.Optional;
import com.satellite_api_master.satellite_management.model.ManagementModel;
import java.util.List;

public interface ManagementInterface {

    public ManagementModel launchSatellite(ManagementModel managementModel);

    public ManagementModel updateData(ManagementModel managementModel);

    public List<ManagementModel> getLaunchData();

    public Optional<ManagementModel> getLaunchDataById(long id);

    public void decommissionSatellite(long id);
}