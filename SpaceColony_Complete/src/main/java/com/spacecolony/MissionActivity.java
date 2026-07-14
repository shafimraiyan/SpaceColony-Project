package com.spacecolony;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MissionActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);

        List<CrewMember> crew = Storage.instance.listCrewMembers();
        CrewAdapter adapter = new CrewAdapter(crew, true);
        RecyclerView rv = findViewById(R.id.rvMissionSelect);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        TextView tvLog = findViewById(R.id.tvMissionLog);
        Button btnLaunch = findViewById(R.id.btnLaunchMission);
        btnLaunch.setOnClickListener(v -> {
            List<CrewMember> selected = adapter.getSelectedCrew();
            if(selected.size() != 2) { tvLog.setText("Select exactly 2 crew members!"); return; }
            String result = MissionControl.launchMission(selected.get(0), selected.get(1));
            tvLog.setText(result);
            adapter.notifyDataSetChanged();
        });
    }
}
