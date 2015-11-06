/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.baseballleague;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class Team {
    private String teamName;
    private String leagueName;
    private String Division;
    private List fielder;
    private List pitchers;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public String getDivision() {
        return Division;
    }

    public void setDivision(String Division) {
        this.Division = Division;
    }

    public List getFielder() {
        return fielder;
    }

    public void setFielder(List fielder) {
        this.fielder = fielder;
    }

    public List getPitchers() {
        return pitchers;
    }

    public void setPitchers(List pitchers) {
        this.pitchers = pitchers;
    }

    public String getLeague() {
        return leagueName;
    }

    public void setLeague(String league) {
        this.leagueName = league;
    }
    
    
}
