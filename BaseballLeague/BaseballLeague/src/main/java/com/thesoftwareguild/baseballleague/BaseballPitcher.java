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
public class BaseballPitcher {
    private String name;
    private Integer jerseyNumber;
    private String throwingArm;
    private String team;
    private Double era;
    private Integer strikeouts;
    private Integer walks;
    private Integer hitBatters;
    private String battingSide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getThrowingArm() {
        return throwingArm;
    }

    public void setThrowingArm(String throwingArm) {
        this.throwingArm = throwingArm;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getEra() {
        return era;
    }

    public void setEra(Double era) {
        this.era = era;
    }

    public Integer getStrikeouts() {
        return strikeouts;
    }

    public void setStrikeouts(Integer strikeouts) {
        this.strikeouts = strikeouts;
    }

    public Integer getWalks() {
        return walks;
    }

    public void setWalks(Integer walks) {
        this.walks = walks;
    }

    public Integer getHitBatters() {
        return hitBatters;
    }

    public void setHitBatters(Integer hitBatters) {
        this.hitBatters = hitBatters;
    }

    public String getBattingSide() {
        return battingSide;
    }

    public void setBattingSide(String battingSide) {
        this.battingSide = battingSide;
    }
}
