package com.voter_api_master.voter_management.repository;


import com.voter_api_master.voter_management.model.ManagementModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepository extends CrudRepository<ManagementModel,Long> {
}