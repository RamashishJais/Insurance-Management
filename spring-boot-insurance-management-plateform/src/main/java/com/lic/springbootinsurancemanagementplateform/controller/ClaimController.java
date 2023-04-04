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

import com.lic.springbootinsurancemanagementplateform.dto.Claim;
import com.lic.springbootinsurancemanagementplateform.dto.ResponseStructure;
import com.lic.springbootinsurancemanagementplateform.exception.IdNotFoundException;
import com.lic.springbootinsurancemanagementplateform.exception.service.ClaimService;

@RestController
public class ClaimController {

	@Autowired
	ClaimService claimService;
	
	/*
	*saveService method for client
	*/
	@PostMapping(value = "/saveClaim/{policyId}")
	public ResponseStructure<Claim> saveClaim(@RequestBody Claim claim,@PathVariable int policyId) throws IdNotFoundException {
		
		return claimService.saveClaim(claim,policyId);
	}
	
	/*
	 * getclaimbyid
	 */
	@GetMapping(value = "/getClaimById/{claimId}")
	public ResponseStructure<Claim> getClaimById(@PathVariable int claimId) throws IdNotFoundException {
		
		return claimService.getClaimById(claimId);
	}
	
	/*
	 * updateClaimById
	 */
	@PutMapping(value = "/updateClaim/{claimId}")
	public ResponseStructure<Claim> updateClaimById(@RequestBody Claim claim,@PathVariable int claimId) throws IdNotFoundException {
		
		return claimService.updateClaimById(claim, claimId);
	}
	
	/*
	 * deleteClaimById
	 */
	@DeleteMapping(value = "/deleteClaim/{claimId}")
	public ResponseStructure<Claim> deleteClaimById(@PathVariable int claimId) throws IdNotFoundException {
		
		return claimService.deleteClaimById(claimId);
	}
	
	/*
	 * displayAllClaim
	 */
	@GetMapping(value = "/getAllClaims")
	public ResponseStructure<List<Claim>> getAllClaims(){
		
		return claimService.getAllClaims();
	}
}
