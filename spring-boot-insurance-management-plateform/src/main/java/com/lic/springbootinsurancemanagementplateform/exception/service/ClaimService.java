package com.lic.springbootinsurancemanagementplateform.exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.lic.springbootinsurancemanagementplateform.dto.Claim;
import com.lic.springbootinsurancemanagementplateform.dto.InsurancePolicy;
import com.lic.springbootinsurancemanagementplateform.dto.ResponseStructure;
import com.lic.springbootinsurancemanagementplateform.exception.IdNotFoundException;
import com.lic.springbootinsurancemanagementplateform.exception.dao.ClaimDao;
import com.lic.springbootinsurancemanagementplateform.exception.dao.InsurancePolicyDao;

/**
 * 
 * @author asus
 *
 */

@Service
public class ClaimService {

	@Autowired
	private ClaimDao claimDao;

	@Autowired
	private InsurancePolicyDao dao;

	@Autowired
	private ResponseStructure<Claim> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Claim>> responseStructure2;

	/*
	 * saveService method for client
	 */
	public ResponseStructure<Claim> saveClaim(Claim claim, int policyId) throws IdNotFoundException {

		InsurancePolicy insurancePolicy = dao.getInsurancePolicyById(policyId);

		if (insurancePolicy != null) {

			claim.setInsurancePolicy(insurancePolicy);
			claimDao.saveClaim(claim);
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Claimed-Success-Fully");
			responseStructure.setDescription(
					"claimed is saved inside claim table and associated with particular client please check in claim tables for your reference");
			responseStructure.setData(claim);
			return responseStructure;
		} else {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Not Claimed Yet Please check it once");
			responseStructure.setDescription("Please check it once in database or contact with technical team");
			responseStructure.setData(claim);
			return responseStructure;
		}
	}

	/*
	 * getclaimbyid
	 */
	public ResponseStructure<Claim> getClaimById(int claimId) throws IdNotFoundException {

		Claim claim = claimDao.getClaimById(claimId);

		if (claim != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Claimed-Success-Fully");
			responseStructure.setDescription(
					"claimed is saved inside claim table and associated with particular policy please check in claim tables for your reference");
			responseStructure.setData(claim);

		} else {
			throw new IdNotFoundException("please check claim id it is not present");
		}

		return responseStructure;
	}

	/*
	 * updateClaimById
	 */
	public ResponseStructure<Claim> updateClaimById(Claim claim,int claimId) throws IdNotFoundException {

		Claim claim1 = claimDao.getClaimById(claimId);

		if (claim1 != null) {
			
			claim1.setClaimNumber(claim.getClaimNumber());
			claim1.setClaimDate(claim.getClaimDate());
			claim1.setClaimDescription(claim.getClaimDescription());
			claim1.setClaimStatus(claim.getClaimStatus());
			claimDao.updateClaimById(claim1);
			
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Claim-Updated-SuccessFully");
			responseStructure.setDescription("claimed is updated success fully please check once inside claim table for your reference");
			responseStructure.setData(claim1);

		} else {
			throw new IdNotFoundException("please check claim id it is not present");
		}

		return responseStructure;
	}
	
	/*
	 * deleteClaimById
	 */
	public ResponseStructure<Claim> deleteClaimById(int claimId) throws IdNotFoundException {
		
		Claim claim1 = claimDao.getClaimById(claimId);

		if (claim1 != null) {
			
			claimDao.deleteClaimById(claimId);
			
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Claim-Deleted-SuccessFully");
			responseStructure.setDescription("claimed is Deleted success fully please check once inside claim table for your reference");
			responseStructure.setData(claim1);

		} else {
			throw new IdNotFoundException("please check claim id it is not present");
		}

		return responseStructure;
	}
	
	/*
	 * displayAllClaim
	 */
	public ResponseStructure<List<Claim>> getAllClaims(){
		
		List<Claim> claim1=claimDao.getAllClaims();
			
		if(claim1!=null) {
			responseStructure2.setStatusCode(HttpStatus.FOUND.value());
			responseStructure2.setMsg("Claim-Details-Available");
			responseStructure2.setDescription("Now You Can Find All claim details");
			responseStructure2.setData(claim1);
		}else {
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setMsg("Claim-Details-Not-Available");
			responseStructure2.setDescription("Please check claim table");
			responseStructure2.setData(claim1);
		}
		
		return responseStructure2;
	}
}
