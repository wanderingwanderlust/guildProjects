/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.baseballleague;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class BaseballLeague {

    HashMap<String, Team> hashTeam = new HashMap<>();
    List<BaseballPitcher> listPitcher = new ArrayList<>();
    List<BaseballFielder> listFielder = new ArrayList<>();
    String DVD_FILE = "baseballLeague.txt";
    String DELIMITER = "::";

    public String[] getAllTeams() {
        Set<String> keySet = hashTeam.keySet();
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;

    }

    public Team getTeams(String leagueName) {
        return hashTeam.get(leagueName);
    }

    public void createTeam(Team teams) {
        // we need to put this into our map
        hashTeam.put(teams.getTeamName(), teams);

    }

    public Team removeTeam(String teamName) {
        //in order to remove we must access this function by accessing our map
        return hashTeam.remove(teamName);

    }

    public void createPitcher(BaseballPitcher pitcher) {
        listPitcher.add(pitcher);
    }

    public void createFielder(BaseballFielder fielder) {
        listFielder.add(fielder);
    }

    public void cutPitcher(int jerseyNumber, String team) {
        for (int i = 0; i < listPitcher.size(); i++) {
            if (listPitcher.get(i).getJerseyNumber() == jerseyNumber && listPitcher.get(i).getTeam().equalsIgnoreCase(team)) {
                listPitcher.remove(i);
            }
        }

    }

    public void cutFielder(int jerseyNumber, String team) {
        for (int i = 0; i < listFielder.size(); i++) {
            if (listFielder.get(i).getJerseyNumber() == jerseyNumber && listFielder.get(i).getTeamName().equalsIgnoreCase(team)) {
                listFielder.remove(i);
            }
        }

    }

    public void tradePitcher(int jerseyNumber, String currentTeam, String newTeam) {
        for (int i = 0; i < listPitcher.size(); i++) {
            if (listPitcher.get(i).getJerseyNumber() == jerseyNumber && listPitcher.get(i).getTeam().equalsIgnoreCase(currentTeam)) {
                listPitcher.get(i).setTeam(newTeam);
            }
        }
    }

    public void tradeFielder(int jerseyNumber, String currentTeam, String newTeam) {
        for (int i = 0; i < listFielder.size(); i++) {
            if (listFielder.get(i).getJerseyNumber() == jerseyNumber && listFielder.get(i).getTeamName().equalsIgnoreCase(currentTeam)) {
                listFielder.get(i).setTeamName(newTeam);
            }
        }
    }

    public List<BaseballPitcher> getPitchersByTeam(String teamName) {
        List<BaseballPitcher> pitcherRoster = new ArrayList<>();

        pitcherRoster
                = listPitcher.stream()
                .filter(s -> s.getTeam().equalsIgnoreCase(teamName))
                .collect(Collectors.toList());

        return pitcherRoster;
    }

    public List<BaseballFielder> getFielderByTeam(String teamName) {
        List<BaseballFielder> fielderRoster = new ArrayList<>();

        fielderRoster
                = listFielder.stream()
                .filter(s -> s.getTeamName().equalsIgnoreCase(teamName))
                .collect(Collectors.toList());

        return fielderRoster;
    }

    public void saveLeague() throws IOException {
        Set<String> keys = hashTeam.keySet();
        FileWriter save = new FileWriter("BaseballLeague.txt", false);
        for (String k : keys) {
            Team team = hashTeam.get(k);
            save.write(team.getLeague() + DELIMITER
                    + team.getDivision() + DELIMITER
                    + team.getTeamName() + DELIMITER + "\n");

            save.flush();

        }

        FileWriter savePitchers = new FileWriter("Pitchers.txt", false);
        for (int i = 0; i < listPitcher.size(); i++) {
            BaseballPitcher pitcher = listPitcher.get(i);
            savePitchers.write(pitcher.getName() + DELIMITER
                    + pitcher.getTeam() + DELIMITER
                    + pitcher.getJerseyNumber() + DELIMITER
                    + pitcher.getBattingSide() + DELIMITER
                    + pitcher.getThrowingArm() + DELIMITER
                    + pitcher.getEra() + DELIMITER
                    + pitcher.getStrikeouts() + DELIMITER
                    + pitcher.getWalks() + DELIMITER
                    + pitcher.getHitBatters() + DELIMITER + "\n");

            savePitchers.flush();
        }

        FileWriter saveFielders = new FileWriter("Fielders.txt", false);

        for (int i = 0; i < listFielder.size(); i++) {
            BaseballFielder fielder = listFielder.get(i);
            saveFielders.write(fielder.getName() + DELIMITER
                    + fielder.getTeamName() + DELIMITER
                    + fielder.getJerseyNumber() + DELIMITER
                    + fielder.getBattingSide() + DELIMITER
                    + fielder.getThrowingArm() + DELIMITER
                    + fielder.getFieldingErrors() + DELIMITER
                    + fielder.getStrikeouts() + DELIMITER
                    + fielder.getWalks() + DELIMITER
                    + fielder.getStolenBases() + DELIMITER
                    + fielder.getHomeRuns() + DELIMITER
                    + fielder.getPosition() + DELIMITER
                    + fielder.getBattingAvg()+ DELIMITER
                    + fielder.getHits() + DELIMITER + "\n");
            
            saveFielders.flush();

        }
        save.close();
        saveFielders.close();
        savePitchers.close();

    }

    public void loadLeague() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("BaseballLeague.txt")));
        
        String currentLine;
        String[] currentTokens;
        
        while(sc.hasNextLine()){
            currentLine =  sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
           Team team = new Team();
           
           team.setLeague(currentTokens[0]);
           team.setDivision(currentTokens[1]);
           team.setTeamName(currentTokens[2]);
   
           // we need to add a try catch to make sure if the user adds nothgin an empty string is created
           
           hashTeam.put(team.getTeamName(), team);
        }
           
           Scanner sc1 = new Scanner(new BufferedReader(new FileReader("Pitchers.txt")));
        

        
        while(sc1.hasNextLine()){
            currentLine =  sc1.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
           BaseballPitcher pitcher = new BaseballPitcher();

           pitcher.setName(currentTokens[0]);
           pitcher.setTeam(currentTokens[1]);
           pitcher.setJerseyNumber(Integer.parseInt(currentTokens[2]));
           pitcher.setBattingSide(currentTokens[3]);
           pitcher.setThrowingArm(currentTokens[4]);
           pitcher.setEra(Double.parseDouble(currentTokens[5]));
           pitcher.setStrikeouts(Integer.parseInt(currentTokens[6]));
           pitcher.setWalks(Integer.parseInt(currentTokens[7]));
           pitcher.setHitBatters(Integer.parseInt(currentTokens[8]));
           // we need to add a try catch to make sure if the user adds nothgin an empty string is created
           
           listPitcher.add(pitcher);
           
           
        }

        Scanner sc2 = new Scanner(new BufferedReader(new FileReader("Fielders.txt")));
        while(sc2.hasNextLine()){
            currentLine =  sc2.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
           BaseballFielder fielder = new BaseballFielder();
           

           
           fielder.setName(currentTokens[0]);
           fielder.setTeamName(currentTokens[1]);
           fielder.setJerseyNumber(Integer.parseInt(currentTokens[2]));
           fielder.setBattingSide(currentTokens[3]);
           fielder.setThrowingArm(currentTokens[4]);
           fielder.setFieldingErrors(Integer.parseInt(currentTokens[5]));
           fielder.setStrikeouts(Integer.parseInt(currentTokens[6]));
           fielder.setWalks(Integer.parseInt(currentTokens[7]));
           fielder.setStolenBases(Integer.parseInt(currentTokens[8]));
           fielder.setHomeRuns(Integer.parseInt(currentTokens[9]));
           fielder.setPosition(currentTokens[10]);
           fielder.setBattingAvg(Double.parseDouble(currentTokens[11]));
           fielder.setHits(Integer.parseInt(currentTokens[12]));
           
           
           // we need to add a try catch to make sure if the user adds nothgin an empty string is created
           
           listFielder.add(fielder);
    }

    }
}
