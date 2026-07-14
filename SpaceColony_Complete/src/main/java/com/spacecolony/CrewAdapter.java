package com.spacecolony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewViewHolder> {
    private List<CrewMember> crewList;
    private boolean showCheckboxes;
    private List<CrewMember> selectedCrew = new ArrayList<>();

    public CrewAdapter(List<CrewMember> crewList, boolean showCheckboxes) {
        this.crewList = crewList; this.showCheckboxes = showCheckboxes;
    }

    @NonNull @Override
    public CrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_crew, parent, false);
        return new CrewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewViewHolder holder, int position) {
        CrewMember cm = crewList.get(position);
        holder.tvName.setText(cm.getName() + " (" + cm.getSpecialization() + ")");
        holder.tvStats.setText("HP: "+cm.getEnergy()+"/"+cm.getMaxEnergy()+" | XP: "+cm.getExperience());
        
        if (showCheckboxes) {
            holder.cbSelect.setVisibility(View.VISIBLE);
            holder.cbSelect.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) selectedCrew.add(cm);
                else selectedCrew.remove(cm);
            });
        } else {
            holder.cbSelect.setVisibility(View.GONE);
        }
    }

    @Override public int getItemCount() { return crewList.size(); }
    public List<CrewMember> getSelectedCrew() { return selectedCrew; }

    static class CrewViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvStats; CheckBox cbSelect;
        public CrewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvCrewName);
            tvStats = itemView.findViewById(R.id.tvCrewStats);
            cbSelect = itemView.findViewById(R.id.cbSelect);
        }
    }
}
