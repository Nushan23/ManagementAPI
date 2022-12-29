package com.voter_api_master.voter_management.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "voter_management_table",catalog = "management_db")
public class ManagementModel {

    @Id
    private long voterId;
    private String orbit;
    private String currentLocation;
    private String powerPercentage;
    private String status;
    private Date launchedDate = new Date();
    public ManagementModel(){
        super();
    }

    public ManagementModel(long voterId, String orbit, String currentLocation, String powerPercentage,
                           String status, Date launchedDate) {
        this.voterId = voterId;
        this.orbit = orbit;
        this.currentLocation = currentLocation;
        this.powerPercentage = powerPercentage;
        this.status = status;
        this.launchedDate = launchedDate;
    }


    public long getVoterId() {
        return voterId;
    }

    public void setVoterId(long voterId) {
        this.voterId = voterId;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getPowerPercentage() {
        return powerPercentage;
    }

    public void setPowerPercentage(String powerPercentage) {
        this.powerPercentage = powerPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLaunchedDate() {
        return launchedDate;
    }

    public void setLaunchedDate(Date launchedDate) {
        this.launchedDate = launchedDate;
    }
}
