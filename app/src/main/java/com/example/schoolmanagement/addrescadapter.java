package com.example.schoolmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class addrescadapter extends RecyclerView.Adapter<addrescadapter.MyViewHolder> {

    private final Add_ReceiptFragment add_receiptFragment;
    private final ArrayList<addrescmodel> list;

    public addrescadapter(Add_ReceiptFragment add_receiptFragment, ArrayList<addrescmodel> list) {
        this.add_receiptFragment = add_receiptFragment;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_addresc,parent,false);
        return new addrescadapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_stand.setText(list.get(position).getStand());
        holder.tv_div.setText(list.get(position).getDiv());
        holder.tv_name.setText(list.get(position).getName());
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
        public TextView tv_name;
        public TextView tv_file;
        public TextView tv_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stand = itemView.findViewById(R.id.tv_stand);
            tv_div = itemView.findViewById(R.id.tv_div);
            tv_name  =itemView.findViewById(R.id.tv_name);
            tv_file = itemView.findViewById(R.id.tv_file);
            tv_id = itemView.findViewById(R.id.tv_id);
        }
    }
}
