package com.lic.springbootinsurancemanagementplateform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lic.springbootinsurancemanagementplateform.dto.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
