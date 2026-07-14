package com.spacecolony;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CrewListActivity extends AppCompatActivity {
    private CrewAdapter adapter;
    private String currentType;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_list);

        currentType = getIntent().getStringExtra("type");
        TextView tvTitle = findViewById(R.id.tvListTitle);
        tvTitle.setText(currentType);

        // Initialize RecyclerView with the correct filter
        RecyclerView rv = findViewById(R.id.rvCrewList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CrewAdapter(getFilteredCrewList(currentType), true);
        rv.setAdapter(adapter);

        Button btnAction = findViewById(R.id.btnAction);

        if(currentType.equals("Quarters")) {
            btnAction.setText("Send to Simulator");
            btnAction.setOnClickListener(v -> {
                // 1. Move selected crew to the Simulator
                for(CrewMember cm : adapter.getSelectedCrew()) {
                    cm.setLocation("Simulator");
                }

                adapter.updateList(getFilteredCrewList(currentType));
            });
        } else if(currentType.equals("Simulator")) {
            btnAction.setText("Send to Quarters (Restore HP)");
            btnAction.setOnClickListener(v -> {
                for(CrewMember cm : adapter.getSelectedCrew()) {
                    cm.setLocation("Quarters"); // Move them to Quarters
                    cm.restoreEnergy();        // Restore their health
                }
                adapter.updateList(getFilteredCrewList(currentType));
            });
        } else {
            // Fallback for MissionControl
            btnAction.setText("Send to Quarters");
            btnAction.setOnClickListener(v -> {
                for(CrewMember cm : adapter.getSelectedCrew()) {
                    cm.setLocation("Quarters");
                }
                adapter.updateList(getFilteredCrewList(currentType));
            });
        }
    }

    
    private List<CrewMember> getFilteredCrewList(String location) {
        List<CrewMember> allCrew = Storage.instance.listCrewMembers();
        List<CrewMember> filtered = new ArrayList<>();
        for(CrewMember cm : allCrew) {
            if(cm.getLocation().equals(location)) {
                filtered.add(cm);
            }
        }
        return filtered;
    }
}