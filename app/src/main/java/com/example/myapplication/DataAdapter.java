package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.ModelClass;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private final Context context;
    private final List<ModelClass> modelClass;

    public DataAdapter(Context context, List<ModelClass> modelClass, OnItemClickListener listener) {
        this.listener = listener;
        this.context = context;
        this.modelClass = modelClass;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_items, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass model = modelClass.get(position);
        holder.type.setText(model.getType() + "");
        holder.address.setText(model.getAddress() + "");
        holder.lat.setText(model.getLat() + "");
        holder.longt.setText(model.getLog() + "");
        holder.postalCode.setText(model.getPostalCode() + "");
        holder.fuelPrice.setText(model.getFuelPrice() + "");
        holder.dateTime.setText(model.getDateTime() + "");
    }

    @Override
    public int getItemCount() {
        return modelClass.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView type, address, lat, longt, postalCode,fuelPrice, dateTime;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing each view of our recycler view.
            type = itemView.findViewById(R.id.type);
            address = itemView.findViewById(R.id.address);
            postalCode = itemView.findViewById(R.id.postalCode);
            fuelPrice = itemView.findViewById(R.id.fuelPrice);
            lat = itemView.findViewById(R.id.lat);
            longt = itemView.findViewById(R.id.log);
            dateTime = itemView.findViewById(R.id.DateTime);

        }
    }
}
