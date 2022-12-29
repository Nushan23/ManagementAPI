package com.voter_api_master.voter_management.service_interface;


import java.util.Optional;
import com.voter_api_master.voter_management.model.ManagementModel;
import java.util.List;

public interface ManagementInterface {

    public ManagementModel launchVoter(ManagementModel managementModel);

    public ManagementModel updateData(ManagementModel managementModel);

    public List<ManagementModel> getLaunchData();

    public Optional<ManagementModel> getLaunchDataById(long id);

    public void decommissionVoter(long id);
}