package com.lic.springbootinsurancemanagementplateform.exception.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lic.springbootinsurancemanagementplateform.dto.Client;
import com.lic.springbootinsurancemanagementplateform.repository.ClientRepository;

/*
 * 
 * @author asus
 *
 */
@Repository
public class ClientDao {

	@Autowired
	ClientRepository clientRepository;
	
	/*
	 * saveMethodClient we need here policyid to connect with client table
	 *
	 */
	public Client saveClient(Client client) {
		
		return clientRepository.save(client);
	}
	/*
	 * getByIdClient method to get client data
	 */
	public Client getClientById(int clientId) {
		
		Optional<Client> optional=clientRepository.findById(clientId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	/*
	 * update client
	 */
	public Client updateClientById(Client client){
		return clientRepository.save(client);
	}
	/*
	 * delete clientDatabyId
	 */
	public void deleteClientDataById(int clientId) {
		
		Client client = getClientById(clientId);
		if(client!=null) {
			clientRepository.delete(client);
		}
	}
	
	/*
	 * getAllClientDetails
	 */
	public List<Client> getAllClients(){
		
		return clientRepository.findAll();
	}
}
