package com.lic.springbootinsurancemanagementplateform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lic.springbootinsurancemanagementplateform.dto.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
