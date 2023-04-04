package com.lic.springbootinsurancemanagementplateform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lic.springbootinsurancemanagementplateform.dto.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>{

	
}
