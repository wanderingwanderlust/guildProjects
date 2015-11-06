/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.vendingmachine;

import java.text.DecimalFormat;

/**
 *
 * @author apprentice
 */
public class ChangeMaker {
    
    public String makeChange(Double total)
    {
        int q;
        int d;
        int n;
        int p;
        
        total = total * 100;
        q = (int) (total/25);
        total = total - (q*25);
        d = (int) (total/10);
        total = total - (d*10);
        n = (int) (total/5);
        total = total - (n*5);
        p = (int)(total+0);
        
        String change = "Quarters: "+ Math.abs(q)+ "\n" +
                "Dimes: " +Math.abs(d)+ "\n" +
                "Nickles: " +Math.abs(n)+ "\n" +
                "Pennies: " + Math.abs(p)+ "\n";
        
        return change;
    }
    
    public Double costDifference(Double money, Double itemCost){
        DecimalFormat df = new DecimalFormat("#.##");
        double change = itemCost-money;
        change = Double.valueOf(df.format(change));
        return change;
    }
    
}
