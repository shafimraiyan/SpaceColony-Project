package com.spacecolony;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateCrewActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_crew);

        EditText etName = findViewById(R.id.etName);
        RadioGroup rgSpec = findViewById(R.id.rgSpec);
        Button btnCreate = findViewById(R.id.btnCreateCrew);

        btnCreate.setOnClickListener(v -> {
            String name = etName.getText().toString();
            if(name.isEmpty()) { Toast.makeText(this, "Enter a name!", Toast.LENGTH_SHORT).show(); return; }
            
            CrewMember newCrew = null;
            int selectedId = rgSpec.getCheckedRadioButtonId();
            if(selectedId == R.id.rbPilot) newCrew = new Pilot(name);
            else if(selectedId == R.id.rbEngineer) newCrew = new Engineer(name);
            else if(selectedId == R.id.rbMedic) newCrew = new Medic(name);
            else if(selectedId == R.id.rbScientist) newCrew = new Scientist(name);
            else if(selectedId == R.id.rbSoldier) newCrew = new Soldier(name);
            
            if(newCrew != null) { Storage.instance.addCrewMember(newCrew); finish(); }
            else Toast.makeText(this, "Select a Specialization", Toast.LENGTH_SHORT).show();
        });
    }
}
