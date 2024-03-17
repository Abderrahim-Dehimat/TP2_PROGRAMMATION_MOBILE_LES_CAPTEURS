package com.example.tp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SensorAdapter2 extends RecyclerView.Adapter<SensorAdapter2.ViewHolder> {

    private List<String> sensorList;

    public SensorAdapter2(List<String> sensorList) {
        this.sensorList = sensorList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String sensorName = sensorList.get(position);
        holder.sensorNameTextView.setText(sensorName);
    }

    @Override
    public int getItemCount() {
        return sensorList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView sensorNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sensorNameTextView = itemView.findViewById(R.id.sensor_name);
        }
    }
}

