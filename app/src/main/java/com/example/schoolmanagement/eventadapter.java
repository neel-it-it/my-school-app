package com.example.schoolmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class eventadapter extends  RecyclerView.Adapter<eventadapter.MyViewHolder> {
    private ArrayList<eventmodel> list;
    private EventFragment eventFragment;

    public eventadapter(EventFragment eventFragment, ArrayList<eventmodel> list) {
        this.eventFragment = eventFragment;
        this.list = list;
    }

    @NonNull
    @Override
    public eventadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_event,parent,false);
        return new eventadapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imv_1.setImageResource(list.get(position).getImage());
        holder.tv_1.setText(list.get(position).getTitle());
        holder.tv_2.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imv_1;
        public TextView tv_1;
        public TextView tv_2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_1 = itemView.findViewById(R.id.imv_1);
            tv_1 = itemView.findViewById(R.id.tv_1);
            tv_2 = itemView.findViewById(R.id.tv_2);

        }
    }
}
