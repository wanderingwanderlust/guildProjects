/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.addressbook;

import java.util.Scanner;

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
            System.out.println("Invalid input");
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
        String text = keyboard.nextLine();
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
        double number;
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        number = keyboard.nextDouble();
        return number;  
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
        text = keyboard.nextLine();
        return text;
        
    }
    //Print
    public String printString(String text)
    {
        System.out.println(text);
        return text;
    }
}
