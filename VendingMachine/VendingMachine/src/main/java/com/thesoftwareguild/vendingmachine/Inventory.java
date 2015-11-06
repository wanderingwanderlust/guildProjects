/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.vendingmachine;

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
public class Inventory {
    
    public HashMap<String, Item> hashInventory = new HashMap<>();
    String INVENTORY_FILE = "Inventory/InventoryFile.txt";
    String DELIMITER = "::";
    int newItemId;
    
    public String[] getAllItemIds()
    {
        Set<String> keySet = hashInventory.keySet();
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }
    
    public Item getItem(String itemId)
    {
        return hashInventory.get(itemId);
    }
    
    public void loadInventory() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Item item = new Item();
            item.setItemId(currentTokens[0]);
            item.setName(currentTokens[1]);
            item.setCost(Double.parseDouble(currentTokens[2]));
            item.setCount(Integer.parseInt(currentTokens[3]));
       
            
            hashInventory.put(item.getItemId(), item);
        }
    }
    public void saveInventory() throws IOException
    {
        PrintWriter save = new PrintWriter(new FileWriter(INVENTORY_FILE));
        String[] itemIds = this.getAllItemIds();
        for (int i = 0; i < itemIds.length; i++)
        {
            Item item = this.getItem(itemIds[i]);
            save.println(item.getItemId() + DELIMITER + item.getName() + DELIMITER + item.getCost() + DELIMITER + item.getCount());
            save.flush();
        }
        save.close();
    }
}
