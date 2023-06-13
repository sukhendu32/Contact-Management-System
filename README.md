# Contact-Management-System

Database uses - Mysql
Configration needed in application.properties to establish the connection.
spring.datasource.username=root
spring.datasource.password=root

This a simple REST-API for managing contact :

## Endpoints

### get all Contacts
- Method: GET
- URL: `http://localhost:"+port+"/contactManagementSystem/contacts`
- Description : Retrieve a List of all contacts.

### register a Contacts
- Method: POST
- URL: `http://localhost:"+port+"/contactManagementSystem/register`
- Description :Register a new contacts only if the PhoneNumber provides is Unique and Name, PhoneNumber field is present

### Delete a Contacts
- Method: Delete
- URL: `http://localhost:"+port+"/contactManagementSystem/contacts/{contactId}`
- Description :Delete a contact from the database with the help of contsctId(Primary Key) only if contactKey is present.


###Test cases also provides for
- testcontactCreation - Checks if a contact is registered with the help of primary key which is auto-generated.
- testDeleteContact - Detete a contact with the help of contactId and check it with the help of status code.
- testGetAllUsers - Checks if the list returened is not-empty(assuming some contact are present already) and checks for the status code. 




