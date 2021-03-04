package com.example.schoolmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class addeventadapter extends RecyclerView.Adapter<addeventadapter.MyViewHolder> {

    private final Add_EventFragment add_eventFragment;
    private final ArrayList<addeventmodel> list;

    public addeventadapter(Add_EventFragment add_eventFragment, ArrayList<addeventmodel> list) {
        this.add_eventFragment = add_eventFragment;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_addevent,parent,false);
        return new addeventadapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.imv_event.setImageResource(list.get(position).getImage());
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_date.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imv_event;
        public TextView tv_title;
        public TextView tv_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_event = itemView.findViewById(R.id.imv_event);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_date  =itemView.findViewById(R.id.tv_date);
        }
    }
}
