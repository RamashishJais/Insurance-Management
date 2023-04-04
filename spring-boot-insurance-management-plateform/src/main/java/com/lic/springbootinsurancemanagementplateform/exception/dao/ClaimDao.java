package com.lic.springbootinsurancemanagementplateform.exception.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lic.springbootinsurancemanagementplateform.dto.Claim;
import com.lic.springbootinsurancemanagementplateform.repository.ClaimRepository;

/**
 * 
 * @author
 *
 */

@Repository
public class ClaimDao {

	@Autowired
	private ClaimRepository claimRepository;
	
	/*
	 * save claimdetails
	 */
	public Claim saveClaim(Claim claim) {
	 return claimRepository.save(claim);
	}
	
	/*
	 * getclaimbyid
	 */
	public Claim getClaimById(int claimId) {
		
		Optional<Claim> optional=claimRepository.findById(claimId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	/*
	 * deleteClaimById
	 */
	public void deleteClaimById(int claimId) {
		Claim claim=getClaimById(claimId);
		if(claim!=null) {
			claimRepository.delete(claim);
		}
	}
	/*
	 * updateClaimById
	 */
	public Claim updateClaimById(Claim claim) {
		return claimRepository.save(claim);
	}
	
	/*
	 * displayAllClaim
	 */
	public List<Claim> getAllClaims(){
		return claimRepository.findAll();
	}
}
