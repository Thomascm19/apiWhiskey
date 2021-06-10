package com.example.apiwhiskey.distillery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.apiwhiskey.R;
import com.example.apiwhiskey.distillery.models.DistilleryInfoRequest;

import java.util.ArrayList;
import java.util.List;

public class DistilleryListAdapter extends RecyclerView.Adapter<DistilleryListAdapter.ViewHolder> {

    private ArrayList<DistilleryInfoRequest> dataset;

    public DistilleryListAdapter() {
        dataset = new ArrayList<>();
    }

    @Override
    public DistilleryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_distillery_item, parent, false);
        return new DistilleryListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DistilleryListAdapter.ViewHolder holder, int position) {
        DistilleryInfoRequest a = dataset.get(position);
        holder.distilleryTextView.setText("Nombre: " + a.getName() + "\n" +
                "Pais: " + a.getCountry() + "\n" +
                "Whisky base: " + a.getWhiskybase_whiskies() + "\n" +
                "Whisky base votes: " + a.getWhiskybase_votes() + "\n" +
                "Whisky base rating: " + a.getWhiskybase_rating());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void showListOfDistillery(List<DistilleryInfoRequest> distilleryInfoList) {
        dataset.addAll(distilleryInfoList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView distilleryTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            distilleryTextView = itemView.findViewById(R.id.distilleryTextView);
        }
    }
}
