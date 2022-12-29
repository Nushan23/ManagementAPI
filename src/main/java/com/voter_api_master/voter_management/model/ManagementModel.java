package com.voter_api_master.voter_management.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "voter_management_table",catalog = "management_db")
public class ManagementModel {

    @Id
    private long voterId;
    private String status;
    private Date registeredDate = new Date();
    public ManagementModel(){
        super();
    }

    public ManagementModel(long voterId,
                           String status, Date registeredDate) {
        this.voterId = voterId;
        this.status = status;
        this.registeredDate = registeredDate;
    }


    public long getVoterId() {
        return voterId;
    }

    public void setVoterId(long voterId) {
        this.voterId = voterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
