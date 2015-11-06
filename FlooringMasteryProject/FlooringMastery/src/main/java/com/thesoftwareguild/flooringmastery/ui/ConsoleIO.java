package com.thesoftwareguild.flooringmastery.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.thesoftwareguild.flooringmastery.FlooringMasteryApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class ConsoleIO {
    
    //Prompt user for integer
    //==============================================================
    public int getUserInt(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        boolean badInput;
        int number = 0;
        do {
            try {
                System.out.print(prompt);
                number = keyboard.nextInt();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                keyboard.nextLine();
            }
        } while (badInput);

        return number;
    }
    
    public int getUserIntForEdit(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        boolean badInput;
        int number = 0;
        do {
            try {
                System.out.print(prompt);
                number = keyboard.nextInt();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                keyboard.nextLine();
            }
        } while (badInput);
        
        if(number==0){
            number = 0;
            return number;
        } else{

        return number;
    }
    } 
    
    

    //Prompt user for integer with minimum and maximum values
    //==============================================================
    public int getUserIntMinMax(String prompt, int min, int max) {

        Scanner keyboard = new Scanner(System.in);
        boolean badInput;
        int number = 0;
        do {
            try {
                System.out.print(prompt);
                number = keyboard.nextInt();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                keyboard.nextLine();
            }
        } while (badInput);
        while (number < min || number > max) {
            System.out.print(prompt);
            number = keyboard.nextInt();
        }
        return number;
    }

    //Prompt user for string
    //================================================================
    public String getUserString(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        String text = keyboard.nextLine();
        return text;
    }

    //Prompt user for string and ignore case
    //================================================================
    public String getUserStringToCaps(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        String text = keyboard.next();
        String capText = text.toUpperCase();
        return capText;
    }
    
    
    public String getUserStringForEdit(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        String text = keyboard.nextLine();
        if(text==null){
            text = "";
            return text;
        }else{
        return text;
    }
    }
    
    

    //Prompt user for float
    //================================================================
    public float getUserFloat(String prompt) {
        float number;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        number = keyboard.nextFloat();
        return number;
    }

    //Prompt user for float with minimum and maximum values
    //==============================================================
    public float getUserFloatMinMax(String prompt, float min, float max) {
        float number;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        number = keyboard.nextFloat();
        while (number < min || number > max) {
            System.out.print(prompt);
            number = keyboard.nextFloat();
        }
        return number;
    }

    public double getUserDoubleForEdit(String prompt) throws InputMismatchException {
        
        Scanner keyboard = new Scanner(System.in);
        double number = 0.0d;
        
        System.out.print(prompt);
        number = keyboard.nextDouble();
        
        
        if(number==0.0d){
            number = 0.0d;
            return number;
        } else{

        return number;
                }
     }
    
    
    
    
    
    //Prompt user for double
    //================================================================  
    public double getUserDouble(String prompt) {
        
        Scanner keyboard = new Scanner(System.in);
        boolean badInput;
        double number = 0;
        do {
            try {
                System.out.print(prompt);
                number = keyboard.nextDouble();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                keyboard.nextLine();
            }
        } while (badInput);
        
        if(number==0){
            number = 0;
            return number;
        } else{

        return number;
                }
       
    }
    
    

    //Prompt user for double with minimum and maximum values
    //==============================================================
    public double getUserDoubleMinMax(String prompt, double min, double max) {
        Scanner keyboard = new Scanner(System.in);
        boolean badInput;
        double number = 0;
        do {
            try {
                System.out.print(prompt);
                number = keyboard.nextDouble();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                keyboard.nextLine();
            }
        } while (badInput);

        while (number < min || number > max) {
            System.out.println(prompt);
            number = keyboard.nextDouble();
        }
        return number;
    }

    //Print string to console
    //==============================================================
    public String printUserString(String prompt) {
        String text;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        text = keyboard.next();
        return text;

    }

    //Print
    public String printString(String text) {
        System.out.println(text);
        return text;
    }
}