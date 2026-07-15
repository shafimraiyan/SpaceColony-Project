# Space Colony - Object-Oriented Programming Project

## 1. Project Description
Space Colony is an Android application built using Java in Android Studio. The player manages a space crew made up of 5 specializations (Pilot, Engineer, Medic, Scientist, and Soldier). The user can recruit crew members, train them in the Simulator to gain Experience (XP), and send them on cooperative turn-based missions against a dynamically scaling Threat.

## 2. Implementation & UML Diagram
**Object-Oriented Principles:**
- **Inheritance & Polymorphism:** An abstract `CrewMember` class defines the core stats and actions. The 5 specializations (`Pilot`, `Engineer`, etc.) extend this class and initialize their specific base stats from the assignment's Table 1.
- **Encapsulation:** All class fields are private/protected with public getters and setters. 
- **Data Structures:** `Storage` uses a `HashMap<Integer, CrewMember>` to manage crew members and their unique IDs.

**UML Class Diagram:**
![UML Diagram](https://raw.githubusercontent.com/shafimraiyan/SpaceColony-Project/main/UML_Diagram.png)


## 3. Application Use-Flow
1. **Recruit:** The user creates a new crew member by entering a name and selecting a specialization. They start in Quarters.
2. **Move to Simulator:** In Quarters, the user selects a crew member and moves them to the Simulator. 
3. **Train:** In the Simulator, the user selects a crew member and presses "Train" to increase their XP (which increases their Skill stat).
4. **Move to Mission Control:** The user moves two trained crew members to Mission Control.
5. **Launch Mission:** The user selects exactly two crew members and launches a mission.
6. **Combat Loop:** The turn-based algorithm executes:
    - Crew member A attacks the Threat.
    - Threat retaliates against Crew member A.
    - Crew member B attacks the Threat.
    - Threat retaliates against Crew member B.
    - Continues until Threat or crew members reach 0 energy.
7. **Outcome:** If the Threat dies, survivors gain +1 XP. If a crew member dies, they are removed from the game. Survivors can return to Quarters to fully regenerate their Energy while keeping their XP.

## 4. Team Composition & Work Sharing
- **Team Composition:** Solo Student
- **Division of Work:** 100% of code implementation, UI layout, mission algorithm logic, testing, and documentation done by the single student.
- **Tools Used:** Android Studio, Java, Draw.io (for UML), Git/GitHub, Ubuntu Linux.

## 5. Bonus Features Implemented
*Listed below are the exact bonus points earned to maximize the project grade:*
- [x] **RecyclerView (+1):** Used for the crew list in the UI.
- [x] **Statistics / Mission Scaling (+1):** A `missionCounter` tracks completed missions, and the Threat's difficulty scales directly based on it.
- [x] **Data Storage & Loading (+2):** The `Storage` class uses a HashMap Singleton to persist crew states across activity changes during runtime.

## 6. AI Usage Disclaimer
AI tools (ChatGPT) were used for basic troubleshooting of Gradle compilation errors and formatting documentation.

## 7. Submission Links
- **Video Demonstration (YouTube Unlisted):** [https://youtu.be/hDu_peSq-Hc]

