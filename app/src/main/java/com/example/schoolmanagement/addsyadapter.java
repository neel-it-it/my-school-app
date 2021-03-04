package com.example.schoolmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class addsyadapter extends RecyclerView.Adapter<addsyadapter.MyViewHolder>{

    private final ArrayList<addsymodel> list;
    public Add_SyllabuscoverageFragment add_syllabuscoverageFragment;

    public addsyadapter(Add_SyllabuscoverageFragment add_syllabuscoverageFragment, ArrayList<addsymodel> list) {
        this.add_syllabuscoverageFragment = add_syllabuscoverageFragment;
        this.list = list;
    }

    @NonNull
    @Override
    public addsyadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_addsy,parent,false);
        return new addsyadapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_stand.setText(list.get(position).getStand());
        holder.tv_div.setText(list.get(position).getDiv());
        holder.tv_file.setText(list.get(position).getFile_download());
        holder.tv_id.setText(list.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_stand;
        public TextView tv_div;
        public TextView tv_file;
        public TextView tv_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stand = itemView.findViewById(R.id.tv_stand);
            tv_div = itemView.findViewById(R.id.tv_div);
            tv_file = itemView.findViewById(R.id.tv_file);
            tv_id = itemView.findViewById(R.id.tv_id);
        }
    }
}
