package com.spacecolony;

import java.io.Serializable;

public abstract class CrewMember implements Serializable {
    protected String name, specialization;
    protected int skill, resilience, experience, energy, maxEnergy;
    protected int id;
    private static int idCounter = 0;

    public CrewMember(String name, String specialization, int skill, int resilience, int maxEnergy) {
        this.name = name; this.specialization = specialization;
        this.skill = skill; this.resilience = resilience;
        this.experience = 0;
        this.maxEnergy = maxEnergy; this.energy = maxEnergy;
        this.id = ++idCounter;
    }

    public int act() { return skill + experience; } // XP increases skill
    public void defend(int damage) { energy -= Math.max(0, damage - resilience); }
    
    public String getName() { return name; }
    public int getSkill() { return skill + experience; }
    public int getExperience() { return experience; }
    public void addExperience(int xp) { experience += xp; }
    public int getEnergy() { return energy; }
    public int getMaxEnergy() { return maxEnergy; }
    public void restoreEnergy() { energy = maxEnergy; }
    public boolean isAlive() { return energy > 0; }
    public int getId() { return id; }
    public String getSpecialization() { return specialization; }
}
