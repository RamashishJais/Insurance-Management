package com.lic.springbootinsurancemanagementplateform.exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lic.springbootinsurancemanagementplateform.dto.Client;
import com.lic.springbootinsurancemanagementplateform.dto.InsurancePolicy;
import com.lic.springbootinsurancemanagementplateform.dto.ResponseStructure;
import com.lic.springbootinsurancemanagementplateform.exception.IdNotFoundException;
import com.lic.springbootinsurancemanagementplateform.exception.dao.InsurancePolicyDao;

@Service
public class InsurancePolicyService {

	@Autowired
	private InsurancePolicyDao dao;

	@Autowired
	private ResponseStructure<InsurancePolicy> responseStructure;

	@Autowired
	private ResponseStructure<List<InsurancePolicy>> responseStructure2;

	/*
	 * insurance policyregister
	 */
	public ResponseStructure<InsurancePolicy> saveInsurancePolicy(InsurancePolicy insurancePolicy) {

		InsurancePolicy insurancePolicy2 = dao.saveInsurancePolicy(insurancePolicy);

		if (insurancePolicy2 != null) {

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("insurance-policy-registered");
			responseStructure.setDescription("please check once in database policy is created or not ");
			responseStructure.setData(insurancePolicy2);
			return responseStructure;
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("insurance-policy-not-registered");
			responseStructure.setDescription(
					"because your are not providing proper data in claim object please provide correct data or contact with technical team");
			responseStructure.setData(insurancePolicy2);
			return responseStructure;
		}
	}

	/*
	 * getinsuranceById
	 */
	public ResponseStructure<InsurancePolicy> getInsurancePolicyById(int policyId) throws IdNotFoundException {

		InsurancePolicy insurancePolicy = dao.getInsurancePolicyById(policyId);

		if (insurancePolicy != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Data is available");
			responseStructure.setDescription("You can see all the data for only given policyid");
			responseStructure.setData(insurancePolicy);
			return responseStructure;
		} else {

			throw new IdNotFoundException("Please check your id because it is not vaialable in table");
		}
	}

	/*
	 * deleteInsurancePolicyById
	 */
	public ResponseStructure<InsurancePolicy> deleteInsurancePolicy(int policyId) {

		InsurancePolicy insurancePolicy = dao.getInsurancePolicyById(policyId);

		if (insurancePolicy != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data is Deleted");
			responseStructure.setDescription("data is deleted because id is present");
			dao.deleteInsurancePolicy(policyId);
			responseStructure.setData(insurancePolicy);
			return responseStructure;
		} else {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data is not Deleted");
			responseStructure.setDescription("because given id is not present");
			dao.deleteInsurancePolicy(policyId);
			responseStructure.setData(insurancePolicy);
			return responseStructure;
		}
	}

	/*
	 * 
	 */
	public ResponseStructure<InsurancePolicy> updateInsurancePolicy(int policyId, InsurancePolicy insurancePolicy) {

		InsurancePolicy insurancePolicy1 = dao.getInsurancePolicyById(policyId);

		if (insurancePolicy != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data is Updated");
			responseStructure.setDescription("data is updated because id is present");
			insurancePolicy1.setInsuracnepolicyNumber(insurancePolicy.getInsuracnepolicyNumber());
			insurancePolicy1.setInsurancePolicyCoverageAmount(insurancePolicy.getInsurancePolicyCoverageAmount());
			insurancePolicy1.setInsurancePolicyPremium(insurancePolicy.getInsurancePolicyPremium());
			insurancePolicy1.setInsurancePolicyType(insurancePolicy.getInsurancePolicyType());
			insurancePolicy1.setInsurancePolicyStartDate(insurancePolicy.getInsurancePolicyStartDate());
			insurancePolicy1.setInsurancePolicyEndDate(insurancePolicy.getInsurancePolicyEndDate());
			dao.updateInsurancePolicy(insurancePolicy1);
			responseStructure.setData(insurancePolicy1);
			return responseStructure;
		} else {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data is not updated");
			responseStructure.setDescription("because given id is not present in table");
			responseStructure.setData(insurancePolicy);
			return responseStructure;
		}
	}

	/*
	 * getAllinsurancePolicy
	 */
	public ResponseStructure<List<InsurancePolicy>> getAllInsurancePolicies() throws IdNotFoundException {

		List<InsurancePolicy> insurancePolicies=dao.getAllInsurancePolicies();

		if (insurancePolicies != null) {

			responseStructure2.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure2.setMsg("Policy-Details");
			responseStructure2.setDescription("Now you can see details below");
			responseStructure2.setData(insurancePolicies);

		} else {

			throw new IdNotFoundException("please check your code client table is empty");
		}

		return responseStructure2;
	}
}
