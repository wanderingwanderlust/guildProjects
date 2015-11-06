/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.addressbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class AddressBook {

    private HashMap<Integer, Contact> hashContacts = new HashMap<>();
    String ADDRESS_FILE = "AddressFile.txt";
    String DELIMITER = "::";
    
    public Integer[] getAllContactIds()
    {
        Set<Integer> keySet = hashContacts.keySet();
        Integer[] keyArray = new Integer[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }
    
    public Contact getContact(Integer contactId)
    {
        return hashContacts.get(contactId);
    }
    
    public void createContact(Contact contact)
    {
        hashContacts.put(contact.getContactId(), contact);
    }
    
    public Contact removeContact(Integer contactId)
    {
        return hashContacts.remove(contactId);
    }
    
            
    public void loadContacts() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Contact contact = new Contact();
            contact.setContactId(Integer.parseInt(currentTokens[0]));
            contact.setFirstName(currentTokens[1]);
            contact.setLastName(currentTokens[2]);
            contact.setAddress(currentTokens[3]);
            contact.setCity(currentTokens[4]);
            contact.setState(currentTokens[5]);
            contact.setZip(Integer.parseInt(currentTokens[6]));
            contact.setPhoneNumber(currentTokens[7]);
            
            hashContacts.put(contact.getContactId(), contact);
        }
    }

    public void saveContacts() throws IOException
    {
        PrintWriter save = new PrintWriter(new FileWriter(ADDRESS_FILE));
        Integer[] contactIds = this.getAllContactIds();
        for (int i = 0; i < contactIds.length; i++)
        {
            Contact contact = this.getContact(contactIds[i]);
            save.println(contact.getContactId() + DELIMITER + contact.getFirstName() + DELIMITER + contact.getLastName() + DELIMITER + contact.getAddress() + DELIMITER + contact.getCity() + DELIMITER + contact.getState() + DELIMITER + contact.getZip() + DELIMITER + contact.getPhoneNumber());
            save.flush();
        }
        save.close();
    }
    
}
