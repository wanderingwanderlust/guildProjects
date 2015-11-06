/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
class AddressBookController {

    ConsoleIO con = new ConsoleIO();
    AddressBook contactsList = new AddressBook();
    int iD = 1;

    void run() {
        boolean keepAlive = true;
        int menuSelection = 0;
        Scanner keyboard = new Scanner(System.in);

        try {
            contactsList.loadContacts();
            while (keepAlive) {
                printMenu();
                menuSelection = con.getUserIntMinMax("Please select from the above choices ", 1, 7);

                switch (menuSelection) {
                    case 1:
                        listContacts();
                        break;
                    case 2:
                        searchContacts();
                        break;
                    case 3:
                        addContact();
                        break;
                    case 4:
                        removeContact();
                        break;
                    case 5:
                        editContact();
                        break;
                    case 6:
                        getTotalContacts();
                        break;
                    case 7:
                        keepAlive = false;
                        break;
                    default:
                        con.printString("Unknown input");

                }
            }
            con.printString("Thank you for using the Contact Menu");
            contactsList.saveContacts();
        }
        catch (FileNotFoundException e) {
            con.printString("Address file was not found.");
        } catch (IOException e) {
            con.printString("Unable to write address file.");
        }
    }

    private void printMenu() {
        con.printString("CONTACTS MENU");
        con.printString("=================================");
        con.printString("1. View All Contacts");
        con.printString("2. Search Contacts");
        con.printString("3. Add Contact");
        con.printString("4. Remove Contact");
        con.printString("5. Edit Contact");
        con.printString("6. View Total Number of Contacts");
        con.printString("7. Exit");

    }

    private void listContacts() {
        con.printString("CONTACTS:");
        con.printString("================================="); 
        Integer[] contactIds = contactsList.getAllContactIds();
        if (contactIds.length == 0)
        {
            con.printString("You have no contacts");
        }
        for (int i = 0; i < contactIds.length; i++) {
            Contact contact = contactsList.getContact(contactIds[i]);
            con.printString("Contact ID #"+ contactIds[i] + ":\n\nName:\n" + contact.getLastName() + ", " + contact.getFirstName()
                    + "\n\nAddress:\n" + contact.getAddress() + "\n" + contact.getCity() + ", "
                    + contact.getState() + " " + contact.getZip() + "\n\nPhone Number: " + contact.getPhoneNumber());
            con.printString("=================================");
        }
        System.out.println();
        
    }

    private void searchContacts() {
        String searchLastName;
        searchLastName = con.getUserString("Please enter a last name to search for: ");
        Integer[] contactIds = contactsList.getAllContactIds();
        if (contactIds.length == 0)
        {
            con.printString("You have no saved contacts to search for");
        }
        for (int i = 0; i < contactIds.length; i++) {
            Contact contact = contactsList.getContact(contactIds[i]);
            if (contact.getLastName().equalsIgnoreCase(searchLastName)) {
                con.printString("Contact ID #" +contactIds[i] + ":\n\nName:\n" + contact.getLastName() + ", " + contact.getFirstName()
                        + "\n\nAddress:\n" + contact.getAddress() + "\n" + contact.getCity() + ", "
                        + contact.getState() + " " + contact.getZip() + "\n\nPhone Number: " + contact.getPhoneNumber());
                con.printString("=================================");
            } else {
                con.printString("No contact with " + searchLastName + " as the last name.");
                System.out.println();
            }
            System.out.println();
        }
    }

    private void addContact() {
        con.printString("Contact #" + iD + ".");
        Integer contactId = iD;
        String firstName = con.getUserString("Please enter first name: ");
        String lastName = con.getUserString("Please enter last name: ");
        String address = con.getUserString("Please enter address: ");
        String city = con.getUserString("Please enter city: ");
        String state = con.getUserString("Please enter state: ");
        int zip = con.getUserInt("Please enter zip code: ");
        String phoneNumber = con.getUserString("Please enter phone number: ");

        Contact contact = new Contact();
        contact.setContactId(contactId);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZip(zip);
        contact.setPhoneNumber(phoneNumber);
        
        iD++;
        
        contactsList.createContact(contact);
        System.out.println();

    }

    private void removeContact() {
        String searchLastName;
        int remove; 
        boolean noContact = false;
        searchLastName = con.getUserString("Please enter a last name to search for: ");
        Integer[] contactIds = contactsList.getAllContactIds();
        for (int i = 0; i < contactIds.length; i++) {
            Contact contact = contactsList.getContact(contactIds[i]);
            if (contact.getLastName().equalsIgnoreCase(searchLastName)) {
                con.printString("Contact ID #" +contactIds[i] + ":\n\nName:\n" + contact.getLastName() + ", " + contact.getFirstName()
                        + "\n\nAddress:\n" + contact.getAddress() + "\n" + contact.getCity() + ", "
                        + contact.getState() + " " + contact.getZip() + "\n\nPhone Number: " + contact.getPhoneNumber());
                con.printString("=================================");
                
                } 
            
            
            else {
                con.printString("No contact with " + searchLastName + " last name.");
                System.out.println();
                noContact = true;
            }
        }
        if (noContact == false)
        {
            remove = con.getUserInt("Please enter the contact ID # of the contact you would like to remove: ");
            contactsList.removeContact(remove);
            con.printString("Contact was successfully removed");
        }
                
    }

    private void getTotalContacts() {
        int totalContacts = contactsList.getAllContactIds().length;
        if (totalContacts == 1)
        {
            System.out.println("You have a total of " + totalContacts + " contact");
        }
        else
        {
            System.out.println("You have a total of " + totalContacts + " contacts");
        }
    }

    private void editContact() {
        String searchLastName;
        int edit; 
        boolean noContact = false;
        searchLastName = con.getUserString("Please enter a last name to search for: ");
        Integer[] contactIds = contactsList.getAllContactIds();
        for (int i = 0; i < contactIds.length; i++) {
            Contact contact = contactsList.getContact(contactIds[i]);
            if (contact.getLastName().equalsIgnoreCase(searchLastName)) {
                con.printString("Contact ID #" +contactIds[i] + ":\n\nName:\n" + contact.getLastName() + ", " + contact.getFirstName()
                        + "\n\nAddress:\n" + contact.getAddress() + "\n" + contact.getCity() + ", "
                        + contact.getState() + " " + contact.getZip() + "\n\nPhone Number: " + contact.getPhoneNumber());
                con.printString("=================================");
                
                } 
            
            
            else {
                con.printString("No contact with " + searchLastName + " last name.");
                System.out.println();
                noContact = true;
            }
        }
        if (noContact == false)
        {
            edit = con.getUserInt("Please enter the contact ID # of the contact you would like to edit: ");
            
            addContact();
            
        }
        
    }
}
