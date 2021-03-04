package com.example.schoolmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class Teacheradapter extends RecyclerView.Adapter<Teacheradapter.MyViewHolder> {
        private ArrayList<teachermodel>list;
        private TeacherinfoFragment teacherinfoFragment;
    public Teacheradapter(TeacherinfoFragment teacherinfoFragment, ArrayList<teachermodel> list) {
        this.teacherinfoFragment = teacherinfoFragment;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_teacherinfo,parent,false);
        return new Teacheradapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.prfile_image.setImageResource(list.get(position).getImage());
        holder.tv_1.setText(list.get(position).getTitle());
        holder.tv_2.setText(list.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView prfile_image;
        public TextView tv_1;
        public TextView tv_2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            prfile_image = itemView.findViewById(R.id.profile_image);
            tv_1 = itemView.findViewById(R.id.tv_1);
            tv_2 = itemView.findViewById(R.id.tv_2);
        }
    }
}
