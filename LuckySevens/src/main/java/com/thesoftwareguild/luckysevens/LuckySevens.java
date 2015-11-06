/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.luckysevens;

/**
 *
 * @author apprentice
 */
import java.util.Random;
import java.util.Scanner;
public class LuckySevens {
    public static void main(String[] args) {
        Random rGen = new Random();
        Scanner sc = new Scanner(System.in);
        
        int money, dice1, dice2, dice3, win, loss, diceRoll, maxRoll;
        
        //maxMoneyRollCount = 0
         //maxMoney;
        diceRoll = 0;
        maxRoll = 0;
       
        System.out.println("You look like you want to gamble, let's play Lucky 7'\n");
        System.out.println("The rules are simple when the dice equals 7 you win $4 and if they don't you lose $1. Sounds fair right? I think so, so let's begin.");
        System.out.println("How much money do you want to deposit?");
        money = sc.nextInt();
        System.out.println("You have exactly: $" + money + " to gamble with.");
        int maxMoney = money;
        
        
        do {
             dice1 = rGen.nextInt(6) + 1;
             dice2 = rGen.nextInt(6) + 1;
             dice3 = dice1 +dice2;
             diceRoll +=1;
        
            if ( dice3 == 7)
                {   
                    money += 4;
                    System.out.println("Congratulations you've rolled a 7 and won $4!! Roll again to try and win more. Your balance is: " + money);
                    
                 }  
            else if (dice3 != 7)
                 {
                     money -=1;
                    System.out.println("You've rolled a "+dice3+" Sorry you didn't win this time but roll again! Your balance is: "+ money);
                    
                    
                 }
            if (money > maxMoney){
                maxMoney= money;
                maxRoll = diceRoll;
            }
            } while(money > 0);
           
        
        if (money == 0){
            System.out.println("Game Over!");
            System.out.println("You should have quit at roll " + maxRoll + " because your max winning was $" + maxMoney);
            System.out.println("You went broke after " + diceRoll+ " rolls.");
        }
   
        } 
    }

