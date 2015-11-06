/*9
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmastery;

import java.text.DecimalFormat;

/**
 *
 * @author apprentice
 */
public class OrderCalculator {
    
    public Double materialCost(Double area, Double costOfFlooring)
    {
        return area * costOfFlooring;
    }
    
    public Double laborCost(Double area, Double costOfLabor)
    {
        return area * costOfLabor;
    }
    
    public Double tax (Double area, Double costOfLabor, Double costOfFlooring, Double taxRate)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        Double taxPercent = ((area * costOfFlooring) + (area * costOfLabor)) * (taxRate/100);
        taxPercent = Double.valueOf(df.format(taxPercent));
        return taxPercent;
    }
    
    public Double total (Double area, Double costOfLabor, Double costOfFlooring, Double taxRate)
    {
        Double tax = ((area * costOfFlooring) + (area * costOfLabor)) * (taxRate/100);
        Double totalWithTax = tax + ((area * costOfFlooring) + (area * costOfLabor));
        // this import allows us to create a decimal with only two remainders
        //rounding unsure
        DecimalFormat df = new DecimalFormat("#.##");
        totalWithTax = Double.valueOf(df.format(totalWithTax));
        return totalWithTax;
        
        
    }
}
