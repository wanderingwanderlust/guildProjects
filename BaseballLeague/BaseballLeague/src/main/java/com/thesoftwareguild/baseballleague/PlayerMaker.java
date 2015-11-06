/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.baseballleague;

/**
 *
 * @author apprentice
 */
public class PlayerMaker {
    ConsoleIO con = new ConsoleIO();
    BaseballLeague league = new BaseballLeague();
    
    public BaseballPitcher makePitcher()
    {
        String name = con.readString("Please enter the pitcher's name: ");
            con.print("-------------------------------------------------------");
            int number = con.readInt("Please enter the pitcher's jersey number: ");
            con.print("-------------------------------------------------------");
            String throwingArm = con.readString("Please enter the pitcher's throwing arm: ");
            con.print("-------------------------------------------------------");
            String team = con.readString("Please enter the team the pitcher plays for: ");
            con.print("-------------------------------------------------------");
            Double era = con.readDouble("Please enter the pitcher's ERA: ");
            con.print("-------------------------------------------------------");
            int ks = con.readInt("Please enter the pitcher's strikeouts: ");
            con.print("-------------------------------------------------------");
            int walks = con.readInt("Please enter the pitcher's walks: ");
            con.print("-------------------------------------------------------");
            int hitBatters = con.readInt("Please enter the pitcher's hit batters: ");
            con.print("-------------------------------------------------------");
            String battingSide = con.readString("Please enter the pitcher's batting side: ");
            
            BaseballPitcher pitcher = new BaseballPitcher();
            pitcher.setName(name);
            pitcher.setJerseyNumber(number);
            pitcher.setThrowingArm(throwingArm);
            pitcher.setTeam(team);
            pitcher.setEra(era);
            pitcher.setStrikeouts(ks);
            pitcher.setWalks(walks);
            pitcher.setHitBatters(hitBatters);
            pitcher.setBattingSide(battingSide);
            
            return pitcher;
            
            
    }
    
    public BaseballFielder makeFielder()
    {
    String name = con.readString("Please enter the fielder's name: ");
            con.print("-------------------------------------------------------");
            int number = con.readInt("Please enter the fielder's jersey number: ");
            con.print("-------------------------------------------------------");
            String position = con.readString("Please enter the fielder's position: ");
            con.print("-------------------------------------------------------");
            String throwingArm = con.readString("Please enter the fielder's throwing arm: ");
            con.print("-------------------------------------------------------");
            String team = con.readString("Please enter the team the fielder plays for: ");
            con.print("-------------------------------------------------------");
            Double battingAvg = con.readDouble("Please enter the fielder's batting average: ");
            con.print("-------------------------------------------------------");
            int hrs = con.readInt("Please enter the fielder's homeruns: ");
            con.print("-------------------------------------------------------");
            int walks = con.readInt("Please enter the fielder's walks: ");
            con.print("-------------------------------------------------------");
            int kos = con.readInt("Please enter the fielders's strikeouts: ");
            con.print("-------------------------------------------------------");
            int hits = con.readInt("Please enter the fielders's hits: ");
            con.print("-------------------------------------------------------");
            int stolenBases = con.readInt("Please enter the fielders's stolen bases: ");
            con.print("-------------------------------------------------------");
            int errors = con.readInt("Please enter the fielders's errors: ");
            con.print("-------------------------------------------------------");
            String battingSide = con.readString("Please enter the fielder's batting side: ");
            
            BaseballFielder fielder = new BaseballFielder();
            fielder.setName(name);
            fielder.setJerseyNumber(number);
            fielder.setPosition(position);
            fielder.setThrowingArm(throwingArm);
            fielder.setTeamName(team);
            fielder.setBattingAvg(battingAvg);
            fielder.setHomeRuns(hrs);
            fielder.setWalks(walks);
            fielder.setStrikeouts(kos);
            fielder.setHits(hits);
            fielder.setStolenBases(stolenBases);
            fielder.setFieldingErrors(errors);
            fielder.setBattingSide(battingSide);
            
            return fielder;
    }
}
