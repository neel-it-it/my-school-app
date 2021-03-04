package com.example.schoolmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class addresadapter extends RecyclerView.Adapter<addresadapter.MyViewHolder>{

    private final Add_ResultFragment add_resultFragment;
    private final ArrayList<addresultmodel> list;

    public addresadapter(Add_ResultFragment add_resultFragment, ArrayList<addresultmodel> list) {
        this.add_resultFragment = add_resultFragment;
        this.list = list;
    }

    @NonNull
    @Override
    public addresadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_addresult,parent,false);
        return new addresadapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_stand.setText(list.get(position).getStandard());
        holder.tv_div.setText(list.get(position).getDiv());
        holder.tv_file.setText(list.get(position).getFile_download());
        holder.tv_id.setText(list.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_div;
        public TextView tv_stand;
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
