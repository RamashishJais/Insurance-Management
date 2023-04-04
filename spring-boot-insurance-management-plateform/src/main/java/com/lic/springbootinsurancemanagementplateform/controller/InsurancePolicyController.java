package com.lic.springbootinsurancemanagementplateform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lic.springbootinsurancemanagementplateform.dto.InsurancePolicy;
import com.lic.springbootinsurancemanagementplateform.dto.ResponseStructure;
import com.lic.springbootinsurancemanagementplateform.exception.IdNotFoundException;
import com.lic.springbootinsurancemanagementplateform.exception.service.InsurancePolicyService;

/**
 * 
 * @author asus
 *
 */

@RestController
public class InsurancePolicyController {

	@Autowired
	InsurancePolicyService insurancePolicyService;

	/*
	 * insurance savecontroller
	 */
	@PostMapping(value = "/policies")
	public ResponseStructure<InsurancePolicy> saveInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {

		return insurancePolicyService.saveInsurancePolicy(insurancePolicy);
	}

	/*
	 * getinsuranceById
	 */
	@GetMapping(value = "/policyget/{policyId}")
	public ResponseStructure<InsurancePolicy> getInsurancePolicyById(@PathVariable int policyId)
			throws IdNotFoundException {

		return insurancePolicyService.getInsurancePolicyById(policyId);
	}

	/*
	 * 
	 */
	@PutMapping(value ="/policyupdate/{policyId}" )
	public ResponseStructure<InsurancePolicy> updateInsurancePolicy(@PathVariable int policyId, @RequestBody InsurancePolicy insurancePolicy) {

		return insurancePolicyService.updateInsurancePolicy(policyId, insurancePolicy);
	}
	
	/*
	 * getAllinsurancePolicy
	 */
	@GetMapping(value = "/getAllPoliciyDetails")
	public ResponseStructure<List<InsurancePolicy>> getAllInsurancePolicies() throws IdNotFoundException {

		return insurancePolicyService.getAllInsurancePolicies();
	}
	
	/*
	 * deleteInsurancePolicyById
	 */
	@DeleteMapping(value = "/deletePolicy/{policyId}")
	public ResponseStructure<InsurancePolicy> deleteInsurancePolicy(@PathVariable int policyId) {

		return insurancePolicyService.deleteInsurancePolicy(policyId);
	}
	
}
