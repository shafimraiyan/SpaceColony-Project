package com.spacecolony;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCreate).setOnClickListener(v -> startActivity(new Intent(this, CreateCrewActivity.class)));
        findViewById(R.id.btnQuarters).setOnClickListener(v -> startActivity(new Intent(this, CrewListActivity.class).putExtra("type", "Quarters")));
        findViewById(R.id.btnSimulator).setOnClickListener(v -> startActivity(new Intent(this, CrewListActivity.class).putExtra("type", "Simulator")));
        findViewById(R.id.btnMission).setOnClickListener(v -> startActivity(new Intent(this, MissionActivity.class)));
    }
}
