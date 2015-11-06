/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmastery.dao;

import com.thesoftwareguild.flooringmastery.dto.ProductInventory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class ProductType {
    
    HashMap<String, ProductInventory> hashProduct = new HashMap<>();
    String PRODUCT_FILE = "Data/Products.txt";
    String DELIMITER=",";
    
    public String [] getAllProducts()
    {
        Set<String> keySet = hashProduct.keySet();
        String[] keyArray = new String [keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }
    
    public ProductInventory getProducts(String nameOfProduct)
    {
        return hashProduct.get(nameOfProduct);
    }
    
    public void loadProductFile() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        
        String currentLine;
        String [] currentTokens;
        
        while (sc.hasNextLine())
        {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            ProductInventory newProduct = new ProductInventory();
            
            newProduct.setProductName(currentTokens[0]);
            newProduct.setProductCostPSQ(Double.parseDouble(currentTokens[1]));
            newProduct.setLaborCostPSQ(Double.parseDouble(currentTokens[2]));
            
            hashProduct.put(newProduct.getProductName(), newProduct);
        }
    }
    
}
