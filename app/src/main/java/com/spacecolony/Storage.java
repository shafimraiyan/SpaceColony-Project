package com.spacecolony;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static Storage instance = new Storage(); // Singleton for global access
    private HashMap<Integer, CrewMember> crew = new HashMap<>();
    private int missionCounter = 0;

    public void addCrewMember(CrewMember cm) { crew.put(cm.getId(), cm); }
    public CrewMember getCrewMember(int id) { return crew.get(id); }
    public List<CrewMember> listCrewMembers() { return new ArrayList<>(crew.values()); }
    public void removeCrewMember(int id) { crew.remove(id); }
    public int getMissionCounter() { return missionCounter; }
    public void incrementMissionCounter() { missionCounter++; }
}
