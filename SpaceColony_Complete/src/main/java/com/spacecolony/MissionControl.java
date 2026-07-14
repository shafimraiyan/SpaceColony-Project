package com.spacecolony;
public class MissionControl {
    public static String launchMission(CrewMember a, CrewMember b) {
        StringBuilder log = new StringBuilder();
        Threat threat = new Threat(Storage.instance.getMissionCounter());
        log.append("Threat: ").append(threat.name).append(" (HP: ").append(threat.maxEnergy).append(")\n");

        while (!threat.isDefeated() && (a.isAlive() || b.isAlive())) {
            if (a.isAlive()) {
                int dmg = a.act();
                threat.defend(dmg);
                log.append(a.getName()).append(" deals ").append(dmg).append(" dmg.\n");
                if (!threat.isDefeated()) { a.defend(threat.act()); log.append(a.getName()).append(" gets hit!\n"); }
            }
            if (b.isAlive() && !threat.isDefeated()) {
                int dmg = b.act();
                threat.defend(dmg);
                log.append(b.getName()).append(" deals ").append(dmg).append(" dmg.\n");
                if (!threat.isDefeated()) { b.defend(threat.act()); log.append(b.getName()).append(" gets hit!\n"); }
            }
        }

        if (threat.isDefeated()) {
            log.append("MISSION SUCCESS!\n");
            if(a.isAlive()) { a.addExperience(1); log.append(a.getName()).append(" +1 XP.\n"); }
            if(b.isAlive()) { b.addExperience(1); log.append(b.getName()).append(" +1 XP.\n"); }
            Storage.instance.incrementMissionCounter();
        } else {
            log.append("MISSION FAILED. Crew lost.\n");
            if(!a.isAlive()) Storage.instance.removeCrewMember(a.getId());
            if(!b.isAlive()) Storage.instance.removeCrewMember(b.getId());
        }
        return log.toString();
    }
}
