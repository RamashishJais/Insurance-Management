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

import com.lic.springbootinsurancemanagementplateform.dto.Client;
import com.lic.springbootinsurancemanagementplateform.dto.ResponseStructure;
import com.lic.springbootinsurancemanagementplateform.exception.IdNotFoundException;
import com.lic.springbootinsurancemanagementplateform.exception.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;
	
	/*
	 * saveMethodClient we need here policyid to connect with client table
	 *
	 */
	@PostMapping("/clients/{policyId}")
	public ResponseStructure<Client> saveClient(@RequestBody Client client,@PathVariable int policyId) {
		
		return clientService.saveClient(client, policyId);
	}
	
	/*
	 * getByIdClient method to get client data
	 */
	@GetMapping("/getClients/{clientId}")
	public ResponseStructure<Client> getClientById(@PathVariable int clientId) {
		
		return clientService.getClientById(clientId);
	}
	/*
	 * update client
	 */
	@PutMapping(value = "/updateClients/{clientId}")
	public ResponseStructure<Client> updateClientById(@RequestBody Client client,@PathVariable int clientId) throws IdNotFoundException{
		
		return clientService.updateClientById(client, clientId);
	}
	
	/*
	 * Delete client
	 */
	@DeleteMapping(value = "/deleteClient/{clientId}")
	public ResponseStructure<Client> deleteClientDataById(@ PathVariable int clientId) throws IdNotFoundException {

		return clientService.deleteClientDataById(clientId);
	}
	
	/*
	 * 
	 * getAllClientDetails
	 */
	@GetMapping(value = "/clientDetails")
	public ResponseStructure<List<Client>> getAllClients() throws IdNotFoundException {
		
		return clientService.getAllClients();
		
	}
}
