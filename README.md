# Insurance-Management
Language Used: Core-Java,Jdbc,Spring-Data-Jpa,Sql,with spring boot framework
Database:MySQL with mysql-workbench-application
Teasting-Tool: Post-Man-API
IDE-Tool:STS(spring-tool-suite)
Repository:Github

Description:In this project i have created three classes as mentioned Claim,Client,InsurancePolicy

there is a mapping between (InsurancePolicy to client) and (InsurancePolicy to claim)

I have created all the controller for those three classes now you can find the controller url below


For Client First You have to run your spring boot application right click on your project and click on runspringboot application once the server started then open postman api and paste this 
url and change the port according to your server running port.

Client-Api:

localhost:8081/clients/policyId (localhost:8081/clients/356)  this url will help you to save client but you have to pass the policy id to associate

localhost:8081/getClients/clientid (localhost:8081/getClients/765) pass client id to get particular client

localhost:8081/updateClients/clientid (localhost:8081/updateClients/765) pass client id to update particular client

localhost:8081/deleteClient/clientid (localhost:8081/deleteClient/765) pass client id to delete particular client

localhost:8081/clientDetails it will display all client details

Policy-API:
localhost:8081/policies pass policy details to save data

localhost:8081/policyget/policyid (localhost:8081/policyget/234) to get particular policy details

localhost:8081/policyupdate/policyid (localhost:8081/policyupdate/234) to update particular policy details

localhost:8081/getAllPoliciyDetails  to get All policy details

Claim-API:
localhost:8081/getAllClaims get all claims detaiils

localhost:8081/saveClaim/policyid (localhost:8081/saveClaim/543) here you have to pass policyid to save claim


localhost:8081/getClaimById/claimId (localhost:8081/getClaimById/876) here you have to pass claimid to get particular claim


localhost:8081/updateClaim/claimId (localhost:8081/updateClaim/876) here you have to pass claimid to update particular claim data


localhost:8081/deleteClaim/claimId (localhost:8081/deleteClaim/876) here you have to pass claimid to delete particular claim data
