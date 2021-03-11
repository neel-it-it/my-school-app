package com.example.schoolmanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagement.ui.home.HomeFragment;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Context context;
        private List<String> titles;
        private List<Integer> images;

    public MyAdapter(Context context , List<String> titles , List<Integer> images)
    {
        this.context = context;
        this.titles = titles;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item , parent , false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mtextview.setText(titles.get(position));
        holder.mimageview.setImageResource(images.get(position));
        holder.rlc.setOnClickListener(view -> {
            if(position == 0) {

            }
            else{
                Toast.makeText(context, "" + titles.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        ImageView mimageview;
        TextView mtextview;
        RelativeLayout rlc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageview = itemView.findViewById(R.id.imv);
            mtextview = itemView.findViewById(R.id.text1);
            rlc = itemView.findViewById(R.id.rlc);
        }
    }
}
