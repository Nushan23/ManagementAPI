package com.satellite_api_master.satellite_management.repository;


import com.satellite_api_master.satellite_management.model.ManagementModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepository extends CrudRepository<ManagementModel,Long> {
}