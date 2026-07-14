package com.spacecolony;
public class Threat {
    public String name;
    public int skill, resilience, energy, maxEnergy;
    public Threat(int missionCounter) {
        this.name = "Asteroid Storm";
        this.skill = 4 + missionCounter; 
        this.resilience = 2;
        this.maxEnergy = 15 + (missionCounter * 3);
        this.energy = maxEnergy;
    }
    public void defend(int damage) { energy -= Math.max(0, damage - resilience); }
    public int act() { return skill; }
    public boolean isDefeated() { return energy <= 0; }
}
