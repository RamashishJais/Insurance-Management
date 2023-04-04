package com.lic.springbootinsurancemanagementplateform.exception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lic.springbootinsurancemanagementplateform.dto.Client;
import com.lic.springbootinsurancemanagementplateform.dto.InsurancePolicy;
import com.lic.springbootinsurancemanagementplateform.dto.ResponseStructure;
import com.lic.springbootinsurancemanagementplateform.exception.IdNotFoundException;
import com.lic.springbootinsurancemanagementplateform.exception.dao.ClientDao;
import com.lic.springbootinsurancemanagementplateform.exception.dao.InsurancePolicyDao;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private InsurancePolicyDao insurancePolicyDao;

	@Autowired
	private ResponseStructure<Client> responseStructure;

	@Autowired
	private ResponseStructure<List<Client>> responseStructure2;

	/*
	 * saveMethodClient we need here policyid to connect with client table
	 *
	 */
	public ResponseStructure<Client> saveClient(Client client, int policyId) {

		InsurancePolicy insurancePolicy = insurancePolicyDao.getInsurancePolicyById(policyId);

		if (insurancePolicy != null) {

			client.setInsurancePolicy(insurancePolicy);
			clientDao.saveClient(client);

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Saved");
			responseStructure.setDescription(
					"Data is saved now please check association of policy with client in a client table ");
			responseStructure.setData(client);
			return responseStructure;
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Data-is-not-saved");
			responseStructure.setDescription(
					"please check your data correctly what you passed or restart your server and again pass the data");
			responseStructure.setData(client);
			return responseStructure;
		}
	}

	/*
	 * getByIdClient method to get client data
	 */
	public ResponseStructure<Client> getClientById(int clientId) {

		Client client = clientDao.getClientById(clientId);

		if (client != null) {

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Available");
			responseStructure.setDescription("Now you can see data below");
			responseStructure.setData(client);
			return responseStructure;
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Data-is-not-available");
			responseStructure.setDescription(
					"please check your client id correctly what you passed or restart your server and again pass the data");
			responseStructure.setData(client);
			return responseStructure;
		}
	}

	/*
	 * update client
	 */
	public ResponseStructure<Client> updateClientById(Client client, int clientId) throws IdNotFoundException {

		Client client1 = clientDao.getClientById(clientId);

		if (client1 != null) {

			client1.setClientName(client.getClientName());
			client1.setClientAddress(client.getClientAddress());
			client1.setClientContactInformation(client.getClientContactInformation());
			client1.setClientDateOfBirth(client.getClientDateOfBirth());
			clientDao.updateClientById(client1);

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Updated....");
			responseStructure.setDescription("Now you can see data below....");
			responseStructure.setData(client1);

		} else {

			throw new IdNotFoundException("Id is not found please check it");
		}

		return responseStructure;
	}

	/*
	 * Delete client
	 */
	public ResponseStructure<Client> deleteClientDataById(int clientId) throws IdNotFoundException {

		Client client = clientDao.getClientById(clientId);

		if (client != null) {

			clientDao.deleteClientDataById(clientId);

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Deleted");
			responseStructure.setDescription("Now you can see data below");
			responseStructure.setData(client);

		} else {

			throw new IdNotFoundException("please check your id it is not vaialable");
		}

		return responseStructure;
	}

	/*
	 * 
	 * getAllClientDetails
	 */
	public ResponseStructure<List<Client>> getAllClients() throws IdNotFoundException {

		List<Client> client = clientDao.getAllClients();
		
		if (client != null) {

			responseStructure2.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure2.setMsg("Client-Details");
			responseStructure2.setDescription("Now you can see details below");
			responseStructure2.setData(client);

		} else {

			throw new IdNotFoundException("please check your code client table is empty");
		}

		return responseStructure2;

	}
}
