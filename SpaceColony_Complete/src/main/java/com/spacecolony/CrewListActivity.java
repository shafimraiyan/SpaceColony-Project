package com.spacecolony;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CrewListActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_list);

        String type = getIntent().getStringExtra("type");
        TextView tvTitle = findViewById(R.id.tvListTitle);
        tvTitle.setText(type);

        List<CrewMember> crew = Storage.instance.listCrewMembers();
        CrewAdapter adapter = new CrewAdapter(crew, true);
        RecyclerView rv = findViewById(R.id.rvCrewList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        Button btnAction = findViewById(R.id.btnAction);
        if(type.equals("Quarters")) {
            btnAction.setText("Send to Simulator");
            btnAction.setOnClickListener(v -> { /* Logic to move selected to Simulator */ });
        } else {
            btnAction.setText("Send to Quarters (Restore HP)");
            btnAction.setOnClickListener(v -> {
                for(CrewMember cm : adapter.getSelectedCrew()) { cm.restoreEnergy(); }
                adapter.notifyDataSetChanged();
            });
        }
    }
}
