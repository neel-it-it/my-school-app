package com.example.schoolmanagement;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagement.api.ApiClient;
import com.example.schoolmanagement.response.stu_homework.HomeworkDataItem;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class homworkadpater extends RecyclerView.Adapter<homworkadpater.MyViewHolder> {
    private List<HomeworkDataItem> list;
    private Activity activity;

    public homworkadpater(List<HomeworkDataItem> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_homew,parent,false);
        return new homworkadpater.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.imv_res.setImageResource(list.get(position).getImage());
        holder.tv_subname.setText(list.get(position).getHomeworkName());
        holder.tv_subname.setText(list.get(position).getSubName());
        holder.tv_standname.setText(list.get(position).getDivId());
        holder.tv_stand.setText(list.get(position).getClassId());
       holder.imv_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriWebsite = Uri.parse(ApiClient.Asset_url + "Ajava.pdf");
                Intent intent = new Intent(Intent.ACTION_VIEW,uriWebsite);
                activity.startActivity(intent);


            }
        });
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
        public CardView download;

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
