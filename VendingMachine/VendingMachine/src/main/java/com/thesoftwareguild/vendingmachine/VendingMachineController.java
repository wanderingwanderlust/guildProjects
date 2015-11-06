/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.vendingmachine;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.regex.*;

/**
 *
 * @author apprentice
 */
class VendingMachineController {

    ConsoleIO con = new ConsoleIO();
    Inventory inventory = new Inventory();
    ChangeMaker changeMaker = new ChangeMaker();
    double money;
    void run() {
        boolean keepAlive = true;
        
        String userSelection;

        try {
            inventory.loadInventory();
            while (keepAlive = true) {
                displayItems();
                money = enterMoney();
                buyingItem();
            }

            con.printString("Thank you, enjoy");
            inventory.saveInventory();
        } catch (FileNotFoundException e) {
            con.printString("Inventory file was not found.");
        } catch (IOException e) {
            con.printString("Unable to write inventory file.");
        }
    }


    public double enterMoney() {
        double enteredMoney;
        con.printString("To make a selection from the above list of items please insert money");
        enteredMoney = con.getUserDouble("Enter the amount you would like to insert");
        con.printString("---------------------------------");
        con.printString("|Current Balance: " + enteredMoney);
        con.printString("---------------------------------");
        if(enteredMoney < 0){
            con.printString("You can't hack this vending maching");
            con.printString("System is shutting down to prevent hack");
            System.exit(0);
        }
        return enteredMoney;
    }

    public void displayItems()  {
        con.printString("=================================");
        con.printString("VENDING MACHINE ITEMS:");
        con.printString("=================================");
        
        
        
        
        String[] itemIds = inventory.getAllItemIds();
        if (itemIds.length == 0) {
            con.printString("There are no items in the vending machine");
        }
        for (int i = 0; i < itemIds.length; i++) {
            Item item = inventory.getItem(itemIds[i]);
            if (item.getCount() > 0) {
                if (item.getItemId().substring(0, 1).equalsIgnoreCase("a")) {
                    for (int j = 0; j < 6; j++) {
                        if (Integer.parseInt(item.getItemId().substring(1, 2)) == j) {
                            con.printString("ID:" + item.getItemId() + "\t|"
                                    + "Cost: " + item.getCost()+ "\t|"
                                    + item.getName());

                        }
                    }
                }
            }
        }
        for (int i = 0; i < itemIds.length; i++) {
            Item item = inventory.getItem(itemIds[i]);
            if (item.getCount() > 0) {
                if (item.getItemId().substring(0, 1).equalsIgnoreCase("b")) {
                    for (int j = 0; j < 6; j++) {
                        if (Integer.parseInt(item.getItemId().substring(1, 2)) == j) {
                            con.printString("ID:" + item.getItemId() + "\t|"
                                    + "Cost: " + item.getCost() + "\t|"
                                    + item.getName());

                        }
                    }
                }
            }
        }
        for (int i = 0; i < itemIds.length; i++) {
            Item item = inventory.getItem(itemIds[i]);
            if (item.getCount() > 0) {
                if (item.getItemId().substring(0, 1).equalsIgnoreCase("c")) {
                    for (int j = 0; j < 6; j++) {
                        if (Integer.parseInt(item.getItemId().substring(1, 2)) == j) {
                            con.printString("ID:" + item.getItemId() + "\t|"
                                    + "Cost: " + item.getCost() + "\t|"
                                    + item.getName());

                        }
                    }
                }
            }
        }
        for (int i = 0; i < itemIds.length; i++) {
            Item item = inventory.getItem(itemIds[i]);
            if (item.getCount() > 0) {
                if (item.getItemId().substring(0, 1).equalsIgnoreCase("d")) {
                    for (int j = 0; j < 6; j++) {
                        if (Integer.parseInt(item.getItemId().substring(1, 2)) == j) {
                            con.printString("ID:" + item.getItemId() + "\t|"
                                    + "Cost: " + item.getCost() + "\t|"
                                    + item.getName());

                        }
                    }
                }
            }
        }
        

            con.printString("==================================================");
        con.printString("");
    }
    
    public void buyingItem() throws IOException{
        String itemChoice = "";
        String refund = "";
        
        boolean exitVending = true;
        while (!itemChoice.matches("(?i)[A-D][1-6]")){
           
        con.printString("==========================================================");    
        itemChoice = con.getUserString("Please Select the ID for the snack you would like to purchase. ");
        con.printString("=========================================================="); 
         while(!itemChoice.substring(0,1).equalsIgnoreCase("a")&& !itemChoice.substring(0,1).equalsIgnoreCase("b")
                  && !itemChoice.substring(0,1).equalsIgnoreCase("c")&& !itemChoice.substring(0,1).equalsIgnoreCase("d")){        
            con.printString("Invalid Choice");
            itemChoice = con.getUserString("Please Select the ID for the snack you would like to purchase. ");
         }
        
        
            
            String userChoice =itemChoice.toUpperCase();
            Item order = new Item();
            order = inventory.getItem(userChoice);
            con.printString("---------------------------------");
            con.printString("You have selected " + order.getName());
            con.printString("---------------------------------");
            con.printString("Item Costs: "+ order.getCost());
            con.printString("---------------------------------");
            while(exitVending)
            if(money >= order.getCost()){
            Double change = changeMaker.costDifference(money, order.getCost());
            changeMaker.makeChange(change);
            refund = changeMaker.makeChange(change);
            con.printString("---------------------------------");
            con.printString("Thank for for purchasing "+ order.getName());
            con.printString("---------------------------------");
            con.printString("Change to be given back: "+ change);
            con.printString("---------------------------------");
            con.printString("Vending "+ order.getName());
            con.printString("---------------------------------");
            con.printString("Dispensing Change: "+ change+ "\n" +
                    refund);
            con.printString("---------------------------------");
            Integer newCount = order.getCount() -1;
            con.printString("---------------------------------");
            order.setCount(newCount);
            con.printString("***********************************************");
            con.printString("There are now "+ newCount +" "+ order.getName() + "'s remaining.");
            con.printString("***********************************************");
            inventory.saveInventory();
            exitVending = false;
            } else { 
                con.printString("---------------------------------");
                con.printString("You do not have enough money to purchase "+ order.getName());
                con.printString("---------------------------------");
                Double newMoney = con.getUserDouble("Please enter more money or type 0 to return change. ");
                con.printString("---------------------------------");
                if(newMoney == 0.0){
                refund = changeMaker.makeChange(money);
                con.printString("Dispensing Change: "+ money + "\n"+
                        refund);
                exitVending = false;
                } else{
                Double newBalance = money + newMoney;
                money = newBalance;
                con.printString("CurrentBalance "+ money); 
                con.printString("---------------------------------");
    }
            
    }
}
}
}
    
  
