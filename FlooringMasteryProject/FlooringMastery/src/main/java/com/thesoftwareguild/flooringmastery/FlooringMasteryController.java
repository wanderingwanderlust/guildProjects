/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmastery;

import com.thesoftwareguild.flooringmastery.dao.ProductType;
import com.thesoftwareguild.flooringmastery.dao.StateTaxes;
import com.thesoftwareguild.flooringmastery.dao.OrderDataFile;
import com.thesoftwareguild.flooringmastery.dto.Order;
import com.thesoftwareguild.flooringmastery.ui.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
class FlooringMasteryController {

    Scanner sc = new Scanner(System.in);
    ConsoleIO con = new ConsoleIO();
    OrderDataFile orderList = new OrderDataFile();
    StateTaxes taxes = new StateTaxes();
    ProductType productList = new ProductType();
    OrderCalculator calc = new OrderCalculator();

    void run() {
        boolean keepAlive = true;
        int menuSelection = 0;
        int orderNumber = 1;
        String productionMode = "";
        
        {
            try {
                taxes.loadStateTaxFile();
                productList.loadProductFile();
                orderNumber = orderList.loadOrderNumberFile();
                productionMode = orderList.loadConfigFile();
                while (keepAlive) {
                    printMenu();
                    menuSelection = con.getUserIntMinMax("Please select from the above choices ", 1, 6);

                    switch (menuSelection) {
                        case 1:
                            displayOrders();
                            //this will display orders
                            break;
                        case 2:
                            addOrder(orderNumber);
                            orderNumber++;
                            //this will allow user to add an order
                            break;
                        case 3:
                            editOrder();
                            //this will allow user to edit an order
                            break;
                        case 4:
                            removeOrder();
                            //this will allow user to remove and order
                            break;
                        case 5:
                            if(!productionMode.equalsIgnoreCase("prod")){
                            con.printString("We are in TEST MODE files cannot be saved.");
                            con.printString("Please go to config.txt and Switch to PRODUCTION MODE (Prod) to save.");
                                    
                        } else{
                            saveCurrentWork();
                            //this will allow user to save order or order changes to file
                                }
                            break;
                        case 6:
                            keepAlive = quit();
                            //this exits program will prompt if work has been saved
                          
                            break;
                        default:
                            con.printString("Invalid Input");
                    }

                }
                con.printString("Thanks for choosing SWC Corp. for all your flooring needs");

            } catch (FileNotFoundException e) {
                con.printString("File was not found");
            } catch (IOException e) {
                con.printString("Unable to write order file");
            }
        }
    }

    private void printMenu() {
        con.printString("******************************************************");
        con.printString("\tSWC Corp. Flooring Products Menu");
        con.printString("======================================================");
        con.printString("*");
        con.printString("*");
        con.printString("* 1. Display Orders");
        con.printString("* 2. Add an Order");
        con.printString("* 3. Edit an Order");
        con.printString("* 4. Remove an Order");
        con.printString("* 5. Save Current Work");
        con.printString("* 6. Quit");
        con.printString("*");
        con.printString("******************************************************");
    }

    private void addOrder(int orderNumber) {
        //temp order number assignemnt

        String orderDate = "13132015";
        String productType = "";
        String productTypeTest = "";

        con.printString("*****************Add Order*******************");
        con.printString("*********************************************");
        con.printString("\tSWC Corp. Flooring Order Form");
        con.printString("=============================================");

        Integer[] orderByDate = orderList.getAllOrderDates();

//        for (int i = 0; i < orderByDate.length; i++) {
//            Order newOrder = orderList.findOrderDate(orderByDate[i]);
        //below we are just doing a test case were we are cycling thru all the orders grabbing the order numbers and testing
        //to see if the order number already assigned to an existing order is used, once we find an unused order number it will be
        //assigned as the order number
//            if (newOrder.getOrderNumber() == orderNumber) {
//                orderNumber++;
//            }
//        }
        con.printString("Order Number: " + orderNumber);

        String customerName = con.getUserString("Please enter your name: ");
        if(customerName.contains(",")){
        customerName = customerName.replace(",", " ");   
        }
        con.printString("************************************");

        while (!orderList.isDateValid(orderDate)) {
            orderDate = con.getUserString("Please tell us the date of your order(MMDDYYYY): ");
            //dateTestBoolean = false;
        }

        con.printString("************************************");

        String state = con.getUserStringToCaps("Please tell us the state we will be shipping to:\n"
                + "* OH\n"
                + ""
                + "* PA\n"
                + ""
                + "* MI\n"
                + ""
                + "* IN\n"
                + "");
        if (state.equalsIgnoreCase("oh") || state.equalsIgnoreCase("pa") || state.equalsIgnoreCase("mi") || state.equalsIgnoreCase("in")) {
            con.printString("************************************");

            //whileloop goes here
            while (!productType.equalsIgnoreCase("carpet") && !productType.equalsIgnoreCase("laminate")
                    && !productType.equalsIgnoreCase("tile") && !productType.equalsIgnoreCase("wood")) {

                productType = con.getUserString("Please tell us the type of product you will be purchasing\n"
                        + "\n"
                        + "|-----------------------------------------------|\n"
                        + "|* Carpet   |  Material Cost = $2.25 per/sqf    |\n"
                        + "|-----------------------------------------------|\n"
                        + "|* Laminate |  Material Cost = $1.75 per/sqf    |\n"
                        + "|-----------------------------------------------|\n"
                        + "|* Tile     |  Material Cost = $3.50 per/sqf    |\n"
                        + "|-----------------------------------------------|\n"
                        + "|* Wood     |  Material Cost = $4.75 per/sqf    |\n"
                        + "|-----------------------------------------------|\n"
                        + "\n"
                        + "Please enter the name of the product you would like to select: ");

                productTypeTest = productType.toLowerCase();
                if (productTypeTest.equals("carpet")) {
                    productType = "Carpet";
                } else if (productTypeTest.equals("laminate")) {
                    productType = "Laminate";
                } else if (productTypeTest.equals("tile")) {
                    productType = "Tile";
                } else if (productTypeTest.equals("wood")) {
                    productType = "Wood";
                }
            }
            //conditionals will go here to make sure user is selecting correct types while correcting capitalization mistakes
            con.printString("************************************");

            Double area = con.getUserDoubleMinMax("Please tell us the total area of material needed: ", 0, 999999999);
            con.printString("\n");
            con.printString("=============================================");
            con.printString("==============Confirmation Page==============");
            con.printString("=============================================");
            con.printString("|Date: " + "\t\t\t" + orderDate);
            con.printString("|--------------------------------------------");
            con.printString("|Customer name: " + "\t" + customerName);
            con.printString("|--------------------------------------------");
            con.printString("|State: " + "\t\t" + "   " + state);
            con.printString("|--------------------------------------------");
            con.printString("|Product: " + "\t\t" + productType);
            con.printString("|Project Area: " + "\t\t" + area);
            con.printString("|Cost per Sq Foot: \t$" + productList.getProducts(productType).getProductCostPSQ());
            con.printString("|Labor per square foot: \t$" + productList.getProducts(productType).getLaborCostPSQ());
            con.printString("|Labor Cost: \t\t$" + calc.laborCost(area, productList.getProducts(productType).getLaborCostPSQ()));
            con.printString("|Material cost: \t$" + calc.materialCost(area, productList.getProducts(productType).getProductCostPSQ()));
            con.printString("|State Tax Rate: \t" + taxes.getTaxRate(state) + "%");
            con.printString("|Total: \t\t$" + calc.total(area, productList.getProducts(productType).getLaborCostPSQ(), productList.getProducts(productType).getProductCostPSQ(), taxes.getTaxRate(state)));
            con.printString("=============================================");
            String userConfirm = con.getUserString("Please Confirm if the above information is correct.(Y/N)");
            if (userConfirm.equalsIgnoreCase("y")) {

                Order order = new Order();
                order.setOrderNumber(orderNumber);
                order.setOrderDate(orderDate);
                order.setCustomerName(customerName);
                order.setState(state);
                order.setProductType(productType);
                order.setArea(area);
                order.setCostPSF(productList.getProducts(productType).getProductCostPSQ());
                order.setLaborCostPSF(productList.getProducts(productType).getLaborCostPSQ());
                order.setTaxRate(taxes.getTaxRate(state));
                order.setMaterialCost(calc.materialCost(area, productList.getProducts(productType).getProductCostPSQ()));
                order.setLaborCost(calc.laborCost(area, productList.getProducts(productType).getLaborCostPSQ()));
                order.setTax(calc.tax(area, productList.getProducts(productType).getLaborCostPSQ(), productList.getProducts(productType).getProductCostPSQ(), taxes.getTaxRate(state)));
                order.setTotalCostOfOrder(calc.total(area, productList.getProducts(productType).getLaborCostPSQ(), productList.getProducts(productType).getProductCostPSQ(), taxes.getTaxRate(state)));

                //make wordage concise and add review before printing receipt
                //make receipt look like a real receipt
                //yay
                orderList.createOrder(order);
                con.printString("\n");
                con.printString("************************************************");
                con.printString("=============Customer Receipt===================");
                con.printString("************************************************");
                con.printString("|Order #: " + order.getOrderNumber() + "\t" + "\t" + "Date: " + order.getOrderDate());
                con.printString("|Customer Name: " + "\t" + order.getCustomerName());
                con.printString("|State: " + "\t\t" + order.getState());
                con.printString("|Product: " + "\t\t" + order.getProductType());
                con.printString("|Project Area: " + "\t\t" + order.getArea());
                con.printString("|Cost per Sq Foot: \t$" + order.getCostPSF());
                con.printString("|Labor per Sq Foot: \t$" + +order.getLaborCostPSF());
                con.printString("|Labor Cost: \t\t$" + order.getLaborCost());
                con.printString("|Material cost: \t$" + order.getMaterialCost());
                con.printString("|Tax: " + "\t\t\t$" + calc.tax(order.getArea(), order.getCostPSF(), order.getLaborCostPSF(), order.getTaxRate()));
                con.printString("|Total: \t\t$" + order.getTotalCostOfOrder());
                con.printString("************************************************");
                con.printString("*******Please Keep Date and Order Number********");
                con.printString("===============End of Receipt===================");
                con.printString("************************************************\n");
            } else {
                con.printString("=============================================");
                con.printString("You have told us there is an error in your order.");
                con.printString("Please create a new order.");
                con.printString("=============================================");

            }

        } else {
            con.printString("=============================================");
            con.printString("Sorry we currently do not provide services to " + state + ".");
            con.printString("Please attempt to add an order with a valid state.");
            con.printString("=============================================");
        }

    }

    private void displayOrders() {

        String userDate;
        con.printString("**************Display Order******************");
        con.printString("*********************************************");
        userDate = con.getUserString("Tell us the date you would like us to display orders for: ");
        boolean hasOrderDate =false;
        try {
            orderList.loadOrderFile(userDate);
            //potential blowup immenient
            Set<Integer> keys = orderList.removeHash.keySet();
            for (Integer k : keys) {
                orderList.removeHash.get(k);
                orderList.hashOrders.remove(k);
            }

            Set<Integer> editKeys = orderList.editHash.keySet();
            for (Integer i : editKeys) {
                orderList.editHash.get(i);
                orderList.hashOrders.remove(i);
            }

            Integer[] editingOrders = orderList.getAllOrderDates();
            Set<Integer> editReplaceKeys = orderList.editHash.keySet();
            for (Integer j : editReplaceKeys) {
                orderList.editHash.get(j);
                Order order = new Order();
                order.setOrderNumber(orderList.editHash.get(j).getOrderNumber());
                order.setOrderDate(orderList.editHash.get(j).getOrderDate());
                order.setCustomerName(orderList.editHash.get(j).getCustomerName());
                order.setState(orderList.editHash.get(j).getState());
                order.setProductType(orderList.editHash.get(j).getProductType());
                order.setArea(orderList.editHash.get(j).getArea());
                order.setCostPSF(orderList.editHash.get(j).getCostPSF());
                order.setLaborCostPSF(orderList.editHash.get(j).getLaborCostPSF());
                order.setTaxRate(orderList.editHash.get(j).getTaxRate());
                order.setMaterialCost(orderList.editHash.get(j).getMaterialCost());
                order.setLaborCost(orderList.editHash.get(j).getLaborCost());
                order.setTax(orderList.editHash.get(j).getTax());
                order.setTotalCostOfOrder(orderList.editHash.get(j).getTotalCostOfOrder());

                orderList.hashOrders.put(j, order);
            }

        } catch (FileNotFoundException e) {
           //con.printString("No saved orders");

        } finally {
            Integer[] listingOrders = orderList.getAllOrderDates();
//            if (listingOrders.length == 0) {
//                con.printString("----------------------------------");
//                con.printString("There are no orders for this date.");
//                con.printString("----------------------------------");
//            }

//        if(listingOrders.length == 0){
//            con.printString("----------------------------------");
//            con.printString("There are no orders for this date.");
//            con.printString("----------------------------------");
//        }
            for (int i = 0; i < listingOrders.length; i++) {
                Order order = orderList.findOrder(listingOrders[i]);
                if (Objects.equals(userDate, order.getOrderDate())) {
                    
                    hasOrderDate =true;
                    
                    con.printString("=============================================");
                    con.printString("|Customer Name: " + "\t" + order.getCustomerName());
                    con.printString("|--------------------------------------------");
                    con.printString("|Order Date: " + "\t\t" + order.getOrderDate());
                    con.printString("|--------------------------------------------");
                    con.printString("|Order Number: " + "\t\t" + order.getOrderNumber());
                    con.printString("|--------------------------------------------");
                    con.printString("|State: " + "\t\t" + order.getState());
                    con.printString("|--------------------------------------------");
                    con.printString("|Product: " + "\t\t" + order.getProductType());
                    con.printString("=============================================");
//                    con.printString("|Project Area Sq ft: " + "\t" + order.getArea());
//                    con.printString("|Cost per Sq Foot: \t$" + order.getCostPSF());
//                    con.printString("|Labor per Sq Foot: \t$" + order.getLaborCostPSF());
//                    con.printString("|Material Cost: \t$" + order.getMaterialCost());
//                    con.printString("|State Tax Rate: \t" + +order.getTaxRate() + "%");
//                    con.printString("|Tax: \t\t\t$" + order.getTax());
//                    con.printString("|Total: \t\t$" + order.getTotalCostOfOrder());
//                    con.printString("=============================================");
                } 

            }
            if(hasOrderDate == false){
                con.printString("----------------------------------");
                con.printString("There are no orders for this date.");
                con.printString("----------------------------------");
            }
        }
    }

    public void removeOrder() {
        String userDate;
        Integer userNum;
        
        Integer[] printingOrders = orderList.getAllOrderDates();
        //we need to make a hashmap that will store the removed data
        //HashMap<Integer, Order> removeHash = new HashMap<>();
         con.printString("**************Remove Order******************");
        con.printString("*********************************************");
        userDate = con.getUserString("Tell us the date you would like us to remove orders for: ");
        for (int p = 0; p < printingOrders.length; p++) {
            Order printOrder = orderList.findOrder(printingOrders[p]);
            if (Objects.equals(userDate, printOrder.getOrderDate())) {
                con.printString("=============Order Info================");
                con.printString("Order #: " + printOrder.getOrderNumber());
                con.printString("Date: " + printOrder.getOrderDate());
                con.printString("Name: " + printOrder.getCustomerName());
                con.printString("=======================================");
            }
        }
        con.printString("-------------------------------------------------------------------------");
        userNum = con.getUserInt("Tell us the Order Number for the order you would like to remove: ");
        Integer[] listingOrders = orderList.getAllOrderDates();
        try {
            orderList.loadOrderFile(userDate);
        } catch (FileNotFoundException e) {
            con.printString("No saved orders");

        } finally {
            
            if (listingOrders.length == 0) {
                con.printString("----------------------------------");
                con.printString("There are no orders for this date.");
                con.printString("----------------------------------");
            }

  
            for (int i = 0; i < listingOrders.length; i++) {
                Order order = orderList.findOrder(listingOrders[i]);
                if (Objects.equals(userDate, order.getOrderDate()) && Objects.equals(userNum, order.getOrderNumber())) {
                    con.printString("=============================================");
                    con.printString("Your order Number is: " + order.getOrderNumber());
                    con.printString("The date of your order is: " + order.getOrderDate());
                    con.printString("Your name is: " + order.getCustomerName());
                    con.printString("=============================================");
                    String userResponse = con.getUserString("Would you like to remove " + order.getCustomerName() + "'s order?(Y/N)");
                    if (userResponse.equalsIgnoreCase("y")) {
                        orderList.removeOrder(userNum);
                        orderList.removeHash.put(userNum, order);
                        con.printString("Order #" + userNum + " has been removed.");
                        con.getUserString("Please hit enter to continue to menu.");

                    } else {
                        con.printString("--------------------------------------------------------------------------------");
                        con.printString("There are no orders with " + userDate + " and " + userNum + " that can be removed.");
                        con.printString("--------------------------------------------------------------------------------");
                    }
                }
            }
        }
    }

    public void editOrder() {
        String userDate;
        Integer userNum;

        Integer[] printingOrders = orderList.getAllOrderDates();

        con.printString("*****************Edit Order******************");
        con.printString("*********************************************");
        userDate = con.getUserString("Tell us the date you would like us to display orders for: ");
        for (int p = 0; p < printingOrders.length; p++) {
            Order printOrder = orderList.findOrder(printingOrders[p]);
            if (Objects.equals(userDate, printOrder.getOrderDate())) {
                con.printString("=============Order Info================");
                con.printString("Order #: " + printOrder.getOrderNumber());
                con.printString("Date: " + printOrder.getOrderDate());
                con.printString("Name: " + printOrder.getCustomerName());
                con.printString("=======================================");
            }
        }
        userNum = con.getUserInt("Tell us the Order Number for the order you would like to edit: ");

        try {
            orderList.loadOrderFile(userDate);
        } catch (FileNotFoundException e) {
            con.printString("No saved orders");
        } finally {
            Integer[] listingOrders = orderList.getAllOrderDates();

            if (listingOrders.length == 0) {
                con.printString("----------------------------------");
                con.printString("There are no orders for this date.");
                con.printString("----------------------------------");
            }
    for (int i = 0; i < listingOrders.length; i++) {
                Order order = orderList.findOrder(listingOrders[i]);
                if (Objects.equals(userDate, order.getOrderDate()) && Objects.equals(userNum, order.getOrderNumber())) {
                    con.printString("=============================================");
                    con.printString("Your order Number is: " + order.getOrderNumber());
                    con.printString("The date of your order is: " + order.getOrderDate());
                    con.printString("Your name is: " + order.getCustomerName());
                    con.printString("=============================================");

                    String userResponse = con.getUserStringForEdit("Would you like to edit Order #" + order.getOrderNumber() + "? (Y/N)");
                    if (userResponse.equalsIgnoreCase("y")) {

                        con.printString("=============================");
                        con.printString("******Editing Order #" + order.getOrderNumber() + "******");
                        con.printString("=============================");
                        
                        
                        //potential blowup
                       boolean dateValid = true; 
                       
                       while(dateValid){
                       String userNewDate = con.getUserString("(Current Order Date: " + order.getOrderDate() + ") Please enter a new date for your order(MMDDYYYY) or Hit enter to keep the date the same: ");
                           if (userNewDate.equals(null) || userNewDate.equals("")) {
                            con.printString("The Date remains: " + order.getOrderDate());
                            dateValid = false;

                        } else if (orderList.isDateValid(userNewDate)){
                            order.setOrderDate(userNewDate);
                            orderList.editHash.put(userNum, order);
                            dateValid = false;
                        }else{
                                con.printString("Invalid Date. Enter new Date.");
                                dateValid = true;
                            }
                        }

                        con.printString("=============================");
                        String userNewName = con.getUserStringForEdit("(Current User Name: " + order.getCustomerName() + ") Please enter a new name or Hit enter to keep the name the same: ");
                        if (userNewName.equals("") || userNewName.equals(null)) {
                            con.printString("The Name remains: " + order.getCustomerName());
                        } else {
                            if(userNewName.contains(",")){
                            userNewName = userNewName.replace(",", " ");   
                            }
                            order.setCustomerName(userNewName);
                            orderList.editHash.put(userNum, order);
                        }

                        con.printString("=============================");
                        
                        String userNewState = orderList.hashOrders.get(userNum).getState();
                        boolean stateValid = true;
                        while(stateValid){
                        userNewState = con.getUserStringForEdit("(Current State: " + order.getState() + ") Please enter a new state or Hit enter to keep the state the same: \n"
                                + "* OH\n"
                                + ""
                                + "* PA\n"
                                + ""
                                + "* MI\n"
                                + ""
                                + "* IN\n");

                        userNewState.toLowerCase();
                        if (userNewState.equals("oh")) {
                            userNewState = "OH";
                            stateValid = false;
                        } else if (userNewState.equals("pa")) {
                            userNewState = "PA";
                            stateValid = false;
                        } else if (userNewState.equals("mi")) {
                            userNewState = "MI";
                            stateValid = false;
                        } else if (userNewState.equals("in")) {
                            userNewState = "IN";
                            stateValid = false;
                        }
                        
                        else if (userNewState.equals("") || userNewState.equals(null)) {
                            con.printString("The State remains: " + order.getState());
                            userNewState = order.getState();
                            order.setState(userNewState);
                            order.setTaxRate(taxes.getTaxRate(userNewState));
                            stateValid = false;
                        }
                        }
                         if(stateValid == false) {
                            order.setState(userNewState);
                            order.setTaxRate(taxes.getTaxRate(userNewState));
                            orderList.editHash.put(userNum, order);
                        }
                        con.printString("=============================");
                        String userNewProduct = con.getUserStringForEdit("(Current Product Type: " + order.getProductType() + ") Please enter a new Product Type or Hit enter to keep the type the same: "
                                + "\n"
                                + "|-----------------------------------------------|\n"
                                + "|* Carpet   |  Material Cost = $2.25 per/sqf    |\n"
                                + "|-----------------------------------------------|\n"
                                + "|* Laminate |  Material Cost = $1.75 per/sqf    |\n"
                                + "|-----------------------------------------------|\n"
                                + "|* Tile     |  Material Cost = $3.50 per/sqf    |\n"
                                + "|-----------------------------------------------|\n"
                                + "|* Wood     |  Material Cost = $4.75 per/sqf    |\n"
                                + "|-----------------------------------------------|\n"
                                + "\n");

                        userNewProduct.toLowerCase();
                        if (userNewProduct.equals("carpet")) {
                            userNewProduct = "Carpet";
                        } else if (userNewProduct.equals("laminate")) {
                            userNewProduct = "Laminate";
                        } else if (userNewProduct.equals("tile")) {
                            userNewProduct = "Tile";
                        } else if (userNewProduct.equals("wood")) {
                            userNewProduct = "Wood";
                        }

                        if (userNewProduct.equals("") || userNewProduct.equals(null)) {
                            con.printString("The Product Type remains: " + order.getProductType());
                            userNewProduct = order.getProductType();
                            order.setCostPSF(productList.getProducts(userNewProduct).getProductCostPSQ());
                            order.setLaborCostPSF(productList.getProducts(userNewProduct).getLaborCostPSQ());
                        } else {
                            order.setProductType(userNewProduct);
                            orderList.editHash.put(userNum, order);
                            order.setCostPSF(productList.getProducts(userNewProduct).getProductCostPSQ());
                            order.setLaborCostPSF(productList.getProducts(userNewProduct).getLaborCostPSQ());
                        }

                        //we cannot parse a double to a string back to a double
                        //so we needed to first pass the double we wanted as a string and then turn it to a double
                        con.printString("=============================");
                        String userNewArea = con.getUserStringForEdit("(Current Area: " + order.getArea() + ")Please enter a new Area or Hit enter to keep the area the same: ");
                        Double nArea;
                        if (userNewArea.equals("") || userNewArea.equals(0.0d)) {
                            con.printString("The Area remains: " + order.getArea());
                            nArea = order.getArea();

                        } else {
                            nArea = Double.parseDouble(userNewArea);
                            nArea = Math.max(0, nArea);
                            order.setArea(nArea);
                            orderList.editHash.put(userNum, order);
                        }

                        order.setMaterialCost(calc.materialCost(nArea, productList.getProducts(userNewProduct).getProductCostPSQ()));
                        order.setLaborCost(calc.laborCost(nArea, productList.getProducts(userNewProduct).getLaborCostPSQ()));
                        order.setTax(calc.tax(nArea, productList.getProducts(userNewProduct).getLaborCostPSQ(), productList.getProducts(userNewProduct).getProductCostPSQ(), taxes.getTaxRate(userNewState)));
                        order.setTotalCostOfOrder(calc.total(nArea, productList.getProducts(userNewProduct).getLaborCostPSQ(), productList.getProducts(userNewProduct).getProductCostPSQ(), taxes.getTaxRate(userNewState)));

                        if (Objects.equals(userDate, order.getOrderDate())) {

                            con.printString("=============================================");
                            con.printString("================New Edit Total===============");
                            con.printString("=============================================");
                            con.printString("|Order #" + order.getOrderNumber());
                            con.printString("|Date: " + order.getOrderDate());
                            con.printString("|Name: " + order.getCustomerName());
                            con.printString("|State: " + order.getState());
                            con.printString("|Product Type: " + order.getProductType());
                            con.printString("|Area: " + order.getArea());
                            con.printString("|Cost per Sq Foot: $" + order.getCostPSF());
                            con.printString("|Labor per Sq Foot: $" + order.getLaborCostPSF());
                            con.printString("|Material Cost: $" + order.getMaterialCost());
                            con.printString("|Tax: $" + order.getTaxRate());
                            con.printString("|Total: $" + order.getTotalCostOfOrder());
                            con.printString("=============================================");
                        }
                    }

                    con.printString("****************************");
                    con.printString("Your order has been updated.");
                    con.printString("****************************");
                }
            }
        }
    }

    public void saveCurrentWork() throws IOException {
        orderList.savingCurrentOrder();
    }

    private boolean setMode() {
        boolean productionMode = false;
        String userMode = con.getUserString("Test or Production mode (Test/Prod):");
        if (userMode.equalsIgnoreCase("test")) {
            productionMode = false;
            
            con.printString("Test Mode files will not be saved");
            return productionMode;
        } else if (userMode.equalsIgnoreCase("Prod")) {
            productionMode = true;
            con.printString("Production Mode has been activated");
            return productionMode;
        } else {
            productionMode = false;
            con.printString("Invalid response you have been sent to test mode");
            con.printString("Quit to re-enter into Production Mode");
            return productionMode;
        }
    }

    private boolean quit() throws FileNotFoundException {
        boolean goBack = false;
        int removedOrders = orderList.removeHash.size();
        int editedOrders = orderList.editHash.size();
        int orderNumber = orderList.loadOrderNumberFile();
        int maxHashedOrderNumber = 0;
        String userChoice = "";
        Set<Integer> key = orderList.hashOrders.keySet();
        for (Integer orderNum : key) {
            if (maxHashedOrderNumber < orderNum) {
                maxHashedOrderNumber = orderNum;
                //maxHashedOrderNumber = maxHashedOrderNumber ;
            }
        }
            if (removedOrders > 0 || orderNumber <= maxHashedOrderNumber || editedOrders > 0 ) {
                con.printString("There are currently unsaved transactions");
                userChoice = con.getUserString("If you would like to return to the Main Menu and save press R to return: ");
                con.printString("Press any other key to continue to exit : ");
                if (userChoice.equalsIgnoreCase("r")) {
                    con.printString("Returning to Main Menu");
                    goBack = true;
                } else {
                    goBack = false;
                }
            } else {
                goBack = false;
            }
    
        
        return goBack;
    }
    
        
        
    
    }


