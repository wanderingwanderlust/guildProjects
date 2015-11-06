/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.baseballleague;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class BaseballLeagueController {

    ConsoleIO con = new ConsoleIO();
    BaseballLeague league = new BaseballLeague();
    PlayerMaker player = new PlayerMaker();

    void run() throws IOException {
        boolean keepAlive = true;
        int menuSelection = 0;
      try {
         league.loadLeague();
        while (keepAlive) {
            printMenu();
            menuSelection = con.readInt("Please select from the above choices ", 1, 7);

            switch (menuSelection) {
                case 1:
                    con.print("===================");
                    con.print("Create a New Team");
                    con.print("==================");
                    //create new teams
                    createTeam();
                    break;

                case 2:

                    con.print("===================");
                    con.print("Create a New Player");
                    con.print("===================");
                    //create new Player
                    createPlayer();
                    break;
                case 3:
                    con.print("===================");
                    con.print("Listing Teams");
                    con.print("===================");
                    listTeams();
                    break;
                case 4:
                    con.print("===================");
                    con.print("Listing Players");
                    con.print("===================");
                    listPlayers();
                    break;
                case 5:
                    con.print("===================");
                    con.print("Trade Players");
                    con.print("===================");
                    tradePlayers();
                    break;
                case 6:
                    con.print("===================");
                    con.print("Remove Player");
                    con.print("===================");
                    removePlayer();
                    break;

                case 7:
                    con.print("===================");
                    con.print("Thanks for playing");
                    con.print("===================");
                    keepAlive = false;
                    
                    break;

                default:
                    con.print("Unknown input");

            }
        }
        con.print("Thanks for creating a new Baseball League!.");
            league.saveLeague();
            } catch (FileNotFoundException e) {
            con.print("League file was not found.");
        } catch (IOException e) {
            con.print("Unable to write League to file.");
        }
    }

    public void printMenu() {
        con.print("*********************************");
        con.print("Baseball League MENU");
        con.print("---------------------------------");
        con.print("1. Create a New Team");
        con.print("---------------------------------");
        con.print("2. Create a New Player");
        con.print("---------------------------------");
        con.print("3. List Teams in League");
        con.print("---------------------------------");
        con.print("4. List Players on Team");
        con.print("---------------------------------");
        con.print("5. Trade Players");
        con.print("---------------------------------");
        con.print("6. Remove Player");
        con.print("---------------------------------");
        con.print("7. Exit");
        con.print("***********************************");

    }

    private void createTeam() {
        String[] teamNames = league.getAllTeams();

        // should also be in the DAO and we should have an auto increment 
        con.print("*************************************");
        con.print("Welcome to PGSN Baseball Team Creator");
        con.print("*************************************");
        con.print("Please enter the following information to create a team");
        con.print("-------------------------------------------------------");

        String leagueName = con.readString("Will the team be in the American League or National League: ");
        con.print("-------------------------------------------------------");
        String teamName = con.readString("Please Enter the Name of the team: ");
        con.print("-------------------------------------------------------");
        String divison = con.readString("Will the team play in the East/West/Central Division : ");
        con.print("-------------------------------------------------------");

        Team newTeam = new Team();
        newTeam.setLeague(leagueName);
        newTeam.setTeamName(teamName);
        newTeam.setDivision(divison);
        league.createTeam(newTeam);
        con.print("----------------------------------------");
        con.print(newTeam.getTeamName() + " has been created!");
        con.print("----------------------------------------");
        con.print("Now go create some players to fill the team up!");
        con.print("***********************************************");
    }

    private void createPlayer() {
        String playerType = "";

        con.print("*************************************");
        con.print("Welcome to PGSN Baseball Player Creator");
        con.print("*************************************");
        con.print("Please enter the following information to create a player");
        con.print("-------------------------------------------------------");

        while (!playerType.equalsIgnoreCase("p") && !playerType.equalsIgnoreCase("f")) {
            playerType = con.readString("To create a fielder press f: \n"
                    + "To create a pitcher press p: ");
        }
        if (playerType.equalsIgnoreCase("p")) {
            BaseballPitcher pitcher = new BaseballPitcher();
            pitcher = player.makePitcher();
            league.createPitcher(pitcher);
        } else {
            BaseballFielder fielder = new BaseballFielder();
            fielder = player.makeFielder();
            league.createFielder(fielder);
        }

    }

    private void listTeams() {
        con.print("*************************************");
        con.print("         PGSN Baseball Teams         ");
        con.print("*************************************");
        Set<String> teams = league.hashTeam.keySet();
        for (String t : teams) {
            league.hashTeam.get(t);
            con.print(t);

        }

    }

    private void listPlayers() {
        String searchTeam = con.readString("Please enter the team name of the roster you would like to view");
        Set<String> teams = league.hashTeam.keySet();
        for (String t : teams) {
            league.hashTeam.get(t);
            //con.print(t);
            if (t.equalsIgnoreCase(searchTeam)) {
                searchTeam = searchTeam.substring(0, 1).toUpperCase() + searchTeam.substring(1);

                con.print("*************************************");
                con.print("\t PGSN " + searchTeam + " Team Roster\t");
                con.print("*************************************");
                con.print("");
                con.print("Pitchers");
                con.print("======================================");

                for (int i = 0; i < league.getPitchersByTeam(searchTeam).size(); i++) {

                    league.getPitchersByTeam(searchTeam).get(i);

                    con.print("Name: " + league.getPitchersByTeam(searchTeam).get(i).getName());
                    con.print("Number: " + league.getPitchersByTeam(searchTeam).get(i).getJerseyNumber());
                    con.print("Throwing arm: " + league.getPitchersByTeam(searchTeam).get(i).getThrowingArm());
                    con.print("ERA: " + league.getPitchersByTeam(searchTeam).get(i).getEra());
                    con.print("Strikeouts: " + league.getPitchersByTeam(searchTeam).get(i).getStrikeouts());
                    con.print("Walks: " + league.getPitchersByTeam(searchTeam).get(i).getWalks());
                    con.print("Hit batters: " + league.getPitchersByTeam(searchTeam).get(i).getHitBatters());
                    con.print("Batting side: " + league.getPitchersByTeam(searchTeam).get(i).getBattingSide());
                    con.print("");

                }
                con.print("");
                con.print("Fielders");
                con.print("======================================");
                for (int i = 0; i < league.getFielderByTeam(searchTeam).size(); i++) {
                    league.getFielderByTeam(searchTeam).get(i);

                    con.print("Name: " + league.getFielderByTeam(searchTeam).get(i).getName());
                    con.print("Number: " + league.getFielderByTeam(searchTeam).get(i).getJerseyNumber());
                    con.print("Position: " + league.getFielderByTeam(searchTeam).get(i).getPosition());
                    con.print("Throwing arm: " + league.getFielderByTeam(searchTeam).get(i).getThrowingArm());
                    con.print("Batting Average: " + league.getFielderByTeam(searchTeam).get(i).getBattingAvg());
                    con.print("Homeruns: " + league.getFielderByTeam(searchTeam).get(i).getHomeRuns());
                    con.print("Walks: " + league.getFielderByTeam(searchTeam).get(i).getWalks());
                    con.print("Strikeouts: " + league.getFielderByTeam(searchTeam).get(i).getStrikeouts());
                    con.print("Hits: " + league.getFielderByTeam(searchTeam).get(i).getHits());
                    con.print("Stolen bases: " + league.getFielderByTeam(searchTeam).get(i).getStolenBases());
                    con.print("Errors: " + league.getFielderByTeam(searchTeam).get(i).getFieldingErrors());
                    con.print("Batting side: " + league.getFielderByTeam(searchTeam).get(i).getBattingSide());
                    con.print("");
                }
            }
        }
    }

    private void removePlayer() {
        String searchTeam = con.readString("Please enter the team name of the roster you would like remove a player from");
        Set<String> teams = league.hashTeam.keySet();
        for (String t : teams) {
            league.hashTeam.get(t);
            
            if (t.equalsIgnoreCase(searchTeam)) {
                searchTeam = searchTeam.substring(0, 1).toUpperCase() + searchTeam.substring(1);

                con.print("*************************************");
                con.print("\t PGSN " + searchTeam + " Team Roster\t");
                con.print("*************************************");
                con.print("");
                con.print("Pitchers");
                con.print("======================================");

                for (int i = 0; i < league.getPitchersByTeam(searchTeam).size(); i++) {

                    league.getPitchersByTeam(searchTeam).get(i);

                    con.print("Name: " + league.getPitchersByTeam(searchTeam).get(i).getName());
                    con.print("Number: " + league.getPitchersByTeam(searchTeam).get(i).getJerseyNumber());
                    con.print("");

                }
                
                
                con.print("");
                con.print("Fielders");
                con.print("======================================");
                for (int i = 0; i < league.getFielderByTeam(searchTeam).size(); i++) {
                    league.getFielderByTeam(searchTeam).get(i);

                    con.print("Name: " + league.getFielderByTeam(searchTeam).get(i).getName());
                    con.print("Number: " + league.getFielderByTeam(searchTeam).get(i).getJerseyNumber());
                    con.print("");
                }
                
                int playerType = con.readInt("Press 1 to select a Pitcher \nPress 2 to select a Fielder", 1, 2);
                int playerNum = con.readInt("Enter the number of the player you would like to release");
                
                if (playerType==1)
                {
                    league.cutPitcher(playerNum, searchTeam);
                }
                else
                {
                    league.cutFielder(playerNum, searchTeam);
                }
            }
        }
    }

    private void tradePlayers() {
        String searchTeam = con.readString("Please enter the team name of the roster you would like trade a player from");
        String newTeam = con.readString("Please enter the team name of the roster you would like trade a player to");
        Set<String> teams = league.hashTeam.keySet();
        for (String t : teams) {
            league.hashTeam.get(t);
            
            if (t.equalsIgnoreCase(searchTeam)) {
                searchTeam = searchTeam.substring(0, 1).toUpperCase() + searchTeam.substring(1);

                con.print("*************************************");
                con.print("\t PGSN " + searchTeam + " Team Roster\t");
                con.print("*************************************");
                con.print("");
                con.print("Pitchers");
                con.print("======================================");

                for (int i = 0; i < league.getPitchersByTeam(searchTeam).size(); i++) {

                    league.getPitchersByTeam(searchTeam).get(i);

                    con.print("Name: " + league.getPitchersByTeam(searchTeam).get(i).getName());
                    con.print("Number: " + league.getPitchersByTeam(searchTeam).get(i).getJerseyNumber());
                    con.print("");

                }
                
                
                con.print("");
                con.print("Fielders");
                con.print("======================================");
                for (int i = 0; i < league.getFielderByTeam(searchTeam).size(); i++) {
                    league.getFielderByTeam(searchTeam).get(i);

                    con.print("Name: " + league.getFielderByTeam(searchTeam).get(i).getName());
                    con.print("Number: " + league.getFielderByTeam(searchTeam).get(i).getJerseyNumber());
                    con.print("");
                }
                
                int playerType = con.readInt("Press 1 to select a Pitcher \nPress 2 to select a Fielder", 1, 2);
                int playerNum = con.readInt("Enter the number of the player you would like to trade");
                
                
                
                if (playerType==1)
                {
                    league.tradePitcher(playerNum, searchTeam, newTeam);
                }
                else
                {
                    league.tradeFielder(playerNum, searchTeam, newTeam);
                }
            }
        }
    }


}
