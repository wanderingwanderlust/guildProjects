package com.thesoftwareguild.vendingmachine;

import java.util.InputMismatchException;
import java.util.Scanner;

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
    int getUserInt(String prompt)
    { 
        int number;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        number = keyboard.nextInt();
        return number;  
    }
    
    //Prompt user for integer with minimum and maximum values
    //==============================================================
    int getUserIntMinMax(String prompt, int min, int max)
    {
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println(prompt);
        int number = keyboard.nextInt();
        while (number < min || number > max)
        {
            System.out.print(prompt);
            number = keyboard.nextInt();
        }
        return number;  
    }
     //Prompt user for string
    //================================================================
    String getUserString(String prompt)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        String text = keyboard.next();
        return text;
    }
    
    //Prompt user for float
    //================================================================
    float getUserFloat(String prompt)
    {
        float number;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        number = keyboard.nextInt();
        return number;  
    }
    
    //Prompt user for float with minimum and maximum values
    //==============================================================
    float getUserFloatMinMax(String prompt, float min, float max)
    {
        float number;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        number = keyboard.nextFloat();
        while (number < min || number > max)
        {
            System.out.print(prompt);
            number = keyboard.nextFloat();
        }
        return number;  
    }
   
    //Prompt user for double
    //================================================================  
    double getUserDouble(String prompt)
    {
        Scanner keyboard = new Scanner(System.in);
       boolean badInput;
        double result = 0;
        do {
            try {
                System.out.println(prompt);
                result = keyboard.nextDouble();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                keyboard.nextLine();
            }
        } while (badInput);

        return result;
    }
    
    //Prompt user for double with minimum and maximum values
    //==============================================================
    double getUserIntMinMax(String prompt, double min, double max)
    {
        double number;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        number = keyboard.nextDouble();
        while (number < min || number > max)
        {
            System.out.println(prompt);
            number = keyboard.nextDouble();
        }
        return number;  
    }
    
    //Print string to console
    //==============================================================
    String printUserString(String prompt)
    {
        String text;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        text = keyboard.next();
        return text;
        
    }
    //Print
    public String printString(String text)
    {
        System.out.println(text);
        return text;
    }
}