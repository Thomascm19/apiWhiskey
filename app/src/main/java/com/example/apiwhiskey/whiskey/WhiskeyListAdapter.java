package com.example.apiwhiskey.whiskey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.apiwhiskey.R;
import com.example.apiwhiskey.whiskey.models.AuctionsInfoRequest;

import java.util.ArrayList;
import java.util.List;

public class WhiskeyListAdapter extends RecyclerView.Adapter<WhiskeyListAdapter.ViewHolder>{

    private ArrayList<AuctionsInfoRequest> dataset;

    public WhiskeyListAdapter(){
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_whiskey_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WhiskeyListAdapter.ViewHolder holder, int position) {
        AuctionsInfoRequest a = dataset.get(position);
        holder.whiskeyTextView.setText("Nombre: " + a.getName() + "\n" +
                "Url: " + a.getUrl() + "\n" +
                "Buyers fee: "+ a.getBuyers_fee() + "\n" +
                "Sellers fee: "+ a.getBuyers_fee() + "\n" +
                "Reserve fee: "+ a.getReserve_fee() + "\n" +
                "Listing fee: "+ a.getListing_fee() + "\n" +
                "Base currency: "+ a.getBase_currency());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void showListOfWhiskey(List<AuctionsInfoRequest> auctionsInfoList) {
        dataset.addAll(auctionsInfoList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView whiskeyTextView;

        public ViewHolder(View itemView){
            super(itemView);

            whiskeyTextView = itemView.findViewById(R.id.whiskeyTextView);
        }
    }

}
