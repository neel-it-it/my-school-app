package com.example.schoolmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class homworkadpater extends RecyclerView.Adapter<homworkadpater.MyViewHolder> {
    private  ArrayList<homworkmodel> list;
    private  HomeworkFragment homeworkFragment;

    public homworkadpater(HomeworkFragment homeworkFragment, ArrayList<homworkmodel> list) {
        this.homeworkFragment = homeworkFragment;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_homew,parent,false);
        return new homworkadpater.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imv_res.setImageResource(list.get(position).getImage());
        holder.tv_subname.setText(list.get(position).getSubname());
        holder.tv_subname.setText(list.get(position).getSubject());
        holder.tv_standname.setText(list.get(position).getStandname());
        holder.tv_stand.setText(list.get(position).getStand());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imv_res;
        public TextView tv_subname;
        public TextView tv_subject;
        public TextView tv_standname;
        public TextView tv_stand;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_res = itemView.findViewById(R.id.imv_res);
            tv_subname = itemView.findViewById(R.id.tv_subname);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_standname = itemView.findViewById(R.id.tv_standname);
            tv_stand = itemView.findViewById(R.id.tv_stand);
        }
    }
}
