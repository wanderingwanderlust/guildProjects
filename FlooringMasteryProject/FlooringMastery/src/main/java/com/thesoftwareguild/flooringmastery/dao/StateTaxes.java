/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmastery.dao;

import com.thesoftwareguild.flooringmastery.dto.State;
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
public class StateTaxes {
    
    HashMap<String, State> hashState = new HashMap<>();
    
    String STATE_TAX_FILE = "Data/Taxes.txt";
    String  DELIMITER = ",";
    
    public String [] getAllStateNames()
    {
        
        Set<String> keySet = hashState.keySet();
        String [] keyArray = new String [keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }
    
    public Double getTaxRate(String stateName)
    {
        return hashState.get(stateName).getStateTaxRate();
    }
    
    public void loadStateTaxFile() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(STATE_TAX_FILE)));
        
        String currentLine;
        String [] currentTokens;
        
        while (sc.hasNextLine())
        {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            State state = new State();
            
            state.setStateName(currentTokens[0]);
            state.setStateTaxRate(Double.parseDouble(currentTokens[1]));
            
            hashState.put(state.getStateName(), state);
            
            
        }
        
    }
}
