package com.example.schoolmanagement;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
        holder.tv_3.setText(list.get(position).getPassword());
        holder.tv_4.setText(list.get(position).getEmail());
        holder.tv_5.setText(list.get(position).getAddress());
        holder.tv_6.setText(list.get(position).getMobile());
        holder.tv_7.setText(list.get(position).getExper());
        holder.tv_8.setText(list.get(position).getClassteacher());

        holder.tv_ans1.setText(list.get(position).getJoinans());
        holder.tv_ans2.setText(list.get(position).getPassans());
        holder.tv_ans3.setText(list.get(position).getMailans());
        holder.tv_ans4.setText(list.get(position).getAddans());
        holder.tv_ans5.setText(list.get(position).getMobans());
        holder.tv_ans6.setText(list.get(position).getExans());
        holder.tv_ans7.setText(list.get(position).getClassans());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView prfile_image;
        public TextView tv_1;
        public TextView tv_2;
        public TextView tv_3;
        public TextView tv_4;
        public TextView tv_5;
        public TextView tv_6;
        public TextView tv_7;
        public TextView tv_8;

        public TextView tv_ans1;
        public TextView tv_ans2;
        public TextView tv_ans3;
        public TextView tv_ans4;
        public TextView tv_ans5;
        public TextView tv_ans6;
        public TextView tv_ans7;
        public Button btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            prfile_image = itemView.findViewById(R.id.profile_image);
            tv_1 = itemView.findViewById(R.id.tv_1);
            tv_2 = itemView.findViewById(R.id.tv_2);
            tv_3 = itemView.findViewById(R.id.tv_3);
            tv_4 = itemView.findViewById(R.id.tv_4);
            tv_5 = itemView.findViewById(R.id.tv_5);
            tv_6 = itemView.findViewById(R.id.tv_6);
            tv_7 = itemView.findViewById(R.id.tv_7);
            tv_8 = itemView.findViewById(R.id.tv_8);

            tv_ans1 = itemView.findViewById(R.id.tv_ans1);
            tv_ans2 = itemView.findViewById(R.id.tv_ans2);
            tv_ans3 = itemView.findViewById(R.id.tv_ans3);
            tv_ans4 = itemView.findViewById(R.id.tv_ans4);
            tv_ans5 = itemView.findViewById(R.id.tv_ans5);
            tv_ans6 = itemView.findViewById(R.id.tv_ans6);
            tv_ans7 = itemView.findViewById(R.id.tv_ans7);

            btn = itemView.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(teacherinfoFragment.getActivity(),Updateprofile.class);
                    teacherinfoFragment.getActivity().startActivity(i);
                }
            });
        }


    }
}
