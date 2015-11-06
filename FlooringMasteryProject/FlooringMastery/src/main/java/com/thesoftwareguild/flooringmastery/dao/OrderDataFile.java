/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmastery.dao;

import com.thesoftwareguild.flooringmastery.dto.Order;
import com.thesoftwareguild.flooringmastery.ui.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class OrderDataFile {
    ConsoleIO con = new ConsoleIO();
    
    public HashMap<Integer, Order> hashOrders = new HashMap();
    //to load and remove files we need to do a substring of the file name only taking in the MMDDYYYY
    String DELIMITER = ",";
    String ORDER_NUMBER_FILE = "Data/OrderNumber.txt";
    String CONFIG_FILE = "Data/config.txt";
    
    public HashMap<Integer, Order> removeHash = new HashMap<>();
    
    public HashMap<Integer, Order> editHash = new HashMap<>();
            
    public Integer [] getAllOrderDates(){
    Set<Integer> keySet = hashOrders.keySet();
    Integer[] keyArray = new Integer [keySet.size()];
    keyArray = keySet.toArray(keyArray);
    return keyArray;
    }
    
    
    public void createOrder(Order order)
    {
        hashOrders.put(order.getOrderNumber(), order);
    }
    
    public Order findOrderDate(Integer date)
    {
        return hashOrders.get(date);
    }
    public Order findOrder(Integer orderNumber)
    {
        return hashOrders.get(orderNumber);
    }
    
 

        public Order removeOrder(Integer orderNumber){
        //in order to remove we must access this function by accessing our map
        
        return hashOrders.remove(orderNumber);
        
        
   
    }

    
public int loadOrderNumberFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDER_NUMBER_FILE)));
        int orderNumber = 0;
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            orderNumber = Integer.parseInt(currentTokens[0]);

        }
        return orderNumber;
    }        
        
        
        
    
    
    
public void savingCurrentOrder() throws IOException {
        String orderDate = "";
        String blankDate = "";
        Integer maxOrderNumber = 0;
        Integer nextOrderNumber = 0;
        
        //helps orderNumber file
        Set<Integer> keys = hashOrders.keySet();
        
        //creates the maximum number allowing our system to continously use the highest number not used
        for (Integer orderNum : keys) {
            if (maxOrderNumber < orderNum) {
                maxOrderNumber = orderNum;
                nextOrderNumber = maxOrderNumber + 1;
            }
            else
            {
                nextOrderNumber = 1;
            }
        }
        FileWriter saveOrderNumber = new FileWriter("Data/OrderNumber.txt", false);
        saveOrderNumber.write(nextOrderNumber + DELIMITER);
        saveOrderNumber.flush();
        saveOrderNumber.close();
    
    //in order for our remove function to save the removed files we needed to loop into removehash and find all the numbers that have been put inside
        Set<Integer> remove = removeHash.keySet();
        for (Integer r : remove) {
            removeHash.get(r);
            hashOrders.remove(r);
            // we then remove all those numbers from our hasorder so when we save it doesn't print the removed order    
            //basically blanks the file since we are reputting the hashmap back in
        }
        
    // this will loop looking for all the removed order numbers and places it into our saved file
            for (Integer r : remove) {
                blankDate = removeHash.get(r).getOrderDate();
                FileWriter blank = new FileWriter("Data/Order/Orders_" + blankDate + ".txt", false);
                Order overWrite = removeHash.get(r);
                blank.write("");
                blank.flush();
                blank.close(); 
            }
        
        for (Integer k : keys) {
           
                orderDate = hashOrders.get(k).getOrderDate();
                
                FileWriter save = new FileWriter("Data/Order/Orders_" + orderDate + ".txt", false);
                
                for (Integer key : keys) {
                    if (orderDate.equals(hashOrders.get(key).getOrderDate()))        
                    {
                        
                            Order orderEntry = hashOrders.get(key);
                            save.write(orderEntry.getOrderNumber() + DELIMITER 
                                    + orderEntry.getCustomerName() + DELIMITER
                                    + orderEntry.getState() + DELIMITER
                                    + orderEntry.getTaxRate() + DELIMITER
                                    + orderEntry.getProductType() + DELIMITER
                                    + orderEntry.getArea() + DELIMITER
                                    + orderEntry.getCostPSF() + DELIMITER
                                    + orderEntry.getLaborCostPSF() + DELIMITER
                                    + orderEntry.getMaterialCost() + DELIMITER
                                    + orderEntry.getLaborCost() + DELIMITER
                                    + orderEntry.getTax() + DELIMITER
                                    + orderEntry.getTotalCostOfOrder() + DELIMITER +"\n");
                            save.flush();
                   } 
                    
               }
                save.close();
                
        }
        con.printString("All files have been Saved Successfully");
        for(Integer r : remove){
            removeHash.remove(r);
        }
        
        //empptying hash to 0 since we have saved it should no longer exist there..  same as above
        Set<Integer> edit = editHash.keySet();
        for (Integer ed : remove) {
            editHash.remove(ed);
          
        }
        
    }
    
    
    
  public void loadOrderFile(String orderDate) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Data/Order/Orders_" + orderDate + ".txt")));

        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            try {
            Order orderEntry = new Order();
            orderEntry.setOrderDate(orderDate);
            
            orderEntry.setOrderNumber(Integer.parseInt(currentTokens[0]));
            orderEntry.setCustomerName(currentTokens[1]);
            orderEntry.setState(currentTokens[2]);
            orderEntry.setTaxRate(Double.parseDouble(currentTokens[3]));
            orderEntry.setProductType(currentTokens[4]);
            orderEntry.setArea(Double.parseDouble(currentTokens[5]));
            orderEntry.setCostPSF(Double.parseDouble(currentTokens[6]));
            orderEntry.setLaborCostPSF(Double.parseDouble(currentTokens[7]));
            orderEntry.setMaterialCost(Double.parseDouble(currentTokens[8]));
            orderEntry.setLaborCost(Double.parseDouble(currentTokens[9]));
            orderEntry.setTax(Double.parseDouble(currentTokens[10]));
            orderEntry.setTotalCostOfOrder(Double.parseDouble(currentTokens[11]));
            // we need to add a try catch to make sure if the user adds nothgin an empty string is created
           
            hashOrders.put(orderEntry.getOrderNumber(), orderEntry);
             } catch (NumberFormatException  ne) {
                //not sure why
            }
        }
    }
    
    
    
    // this makes sure the date is inputted properly
    
    public boolean isDateValid(String inDate)
    {
        if (inDate == null){
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat("MMddyyyy");
        if(inDate.trim().length() != df.toPattern().length())
        {
            return false;
        } 
        
        df.setLenient(false);
        
        try{
            df.parse(inDate.trim());
            
        } catch (ParseException pe){
            return false;
        }
        return true;
        
    }  
    
    
    public String loadConfigFile() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(CONFIG_FILE)));
        String productionMode = "";
        String currentLine;
        String [] currentTokens;
        
        while (sc.hasNextLine())
        {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            //Config userConfig = new Config();
           
            productionMode = currentTokens[0];
            
            //hashConfig.put(userConfig.getUserMode(), userConfig);
            
            
        }
        
        return productionMode;
        
    }
    
    
    
    
}
