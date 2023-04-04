package com.lic.springbootinsurancemanagementplateform.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurancepolicy")
public class InsurancePolicy {

	@Id
	@Column(name = "policyid")
	private int insuracnePolicyId;
	@Column(name = "policynumber")
	private String insuracnepolicyNumber;
	@Column(name = "policytype")
	private String insurancePolicyType;
	@Column(name = "policycoverageamount")
	private long insurancePolicyCoverageAmount;
	@Column(name = "policypremium")
	private String insurancePolicyPremium;
	@Column(name = "policystartdate")
	private String insurancePolicyStartDate;
	@Column(name = "policyenddate")
	private String insurancePolicyEndDate;

	@OneToMany(mappedBy = "insurancePolicy",cascade = CascadeType.ALL)
	private List<Client> clients;

	@OneToOne(mappedBy = "insurancePolicy")
	private Claim claim;

	public int getInsuracnePolicyId() {
		return insuracnePolicyId;
	}

	public void setInsuracnePolicyId(int insuracnePolicyId) {
		this.insuracnePolicyId = insuracnePolicyId;
	}

	public String getInsuracnepolicyNumber() {
		return insuracnepolicyNumber;
	}

	public void setInsuracnepolicyNumber(String insuracnepolicyNumber) {
		this.insuracnepolicyNumber = insuracnepolicyNumber;
	}

	public String getInsurancePolicyType() {
		return insurancePolicyType;
	}

	public void setInsurancePolicyType(String insurancePolicyType) {
		this.insurancePolicyType = insurancePolicyType;
	}

	public long getInsurancePolicyCoverageAmount() {
		return insurancePolicyCoverageAmount;
	}

	public void setInsurancePolicyCoverageAmount(long insurancePolicyCoverageAmount) {
		this.insurancePolicyCoverageAmount = insurancePolicyCoverageAmount;
	}

	public String getInsurancePolicyPremium() {
		return insurancePolicyPremium;
	}

	public void setInsurancePolicyPremium(String insurancePolicyPremium) {
		this.insurancePolicyPremium = insurancePolicyPremium;
	}

	public String getInsurancePolicyStartDate() {
		return insurancePolicyStartDate;
	}

	public void setInsurancePolicyStartDate(String insurancePolicyStartDate) {
		this.insurancePolicyStartDate = insurancePolicyStartDate;
	}

	public String getInsurancePolicyEndDate() {
		return insurancePolicyEndDate;
	}

	public void setInsurancePolicyEndDate(String insurancePolicyEndDate) {
		this.insurancePolicyEndDate = insurancePolicyEndDate;
	}

}
