package com.example;


public class nflTeamInfo {

    private String name;
    private String mascotHint;
    private String stateHint;
    private String player;

    public nflTeamInfo (String name, String mascotHint, String stateHint, String player) {

        this.name = name;
        this.mascotHint = mascotHint;
        this.stateHint = stateHint;
        this.player = player;
        
    }

    public String getName() {
        return name;
    }

    public String getMascotHint() {
        return mascotHint;
    }

    public String getStateHint() {
        return stateHint;
    }

    public String getPlayer() {
        return player;
    }
    

    



    public static void main(String[] args) {
        //System.out.println(random(32));

        nflTeamInfo texans = new nflTeamInfo("Houston Texans", "People who live in Texas are _____", 
        "The Lone Star State", "Andre Johnson");

        nflTeamInfo cowboys = new nflTeamInfo("Dallas Cowboys", "A profession responsible for herdring cattle", 
        "The lone star state", "Troy Aikman");

        int num = 2;
        switch (num) {

            case 1: 
            System.out.println(texans.getName());
            break;
            case 2:
            System.out.println(cowboys.getName());
            break;
        }
    }
    
}
