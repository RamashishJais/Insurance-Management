package com.lic.springbootinsurancemanagementplateform.exception.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lic.springbootinsurancemanagementplateform.dto.InsurancePolicy;
import com.lic.springbootinsurancemanagementplateform.repository.InsurancePolicyRepository;

/**
 * 
 * @author asus
 *
 */

@Repository
public class InsurancePolicyDao {

	@Autowired
	InsurancePolicyRepository insurancePolicyRepository;
	
	/*
	 * insurance policy register
	 */
	public InsurancePolicy saveInsurancePolicy(InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}
	
	/*
	 * getinsuranceById
	 */
	public InsurancePolicy getInsurancePolicyById(int policyId) {
		
		Optional<InsurancePolicy> optional=insurancePolicyRepository.findById(policyId);
		
		if(optional.isPresent()) {
			
			return optional.get();
		}
		
		return null;
	}
	/*
	 * getAllinsurancePolicy
	 */
	public List<InsurancePolicy> getAllInsurancePolicies(){
		
		return insurancePolicyRepository.findAll();
	}
	
	/*
	 * updateInsurancePolicyById
	 */
	public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}
	/*
	 * deleteInsurancePolicyById
	 */
	public void deleteInsurancePolicy(int policyId) {
		
		InsurancePolicy insurancePolicy=getInsurancePolicyById(policyId);
		
		if(insurancePolicy!=null) {
			insurancePolicyRepository.delete(insurancePolicy);
		}
	}
}
