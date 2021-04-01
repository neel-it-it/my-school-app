package com.example.schoolmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagement.response.teacheraddhomework.DataItem;
import com.example.schoolmanagement.response.teacheraddhomework.TeacherAddHomeworkResponse;

import java.util.ArrayList;
import java.util.List;

public class addhomeadapter extends RecyclerView.Adapter<addhomeadapter.MyViewHolder> {
    private final Add_HomeworkFragment add_homeworkFragment;
    private List<DataItem> list;

    public addhomeadapter(Add_HomeworkFragment add_homeworkFragment, List<DataItem> list) {
        this.add_homeworkFragment = add_homeworkFragment;
        this.list = list;
    }

    @NonNull
    @Override
    public addhomeadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_addhomew,parent,false);
        return new addhomeadapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataItem item=list.get(position);
        holder.tv_stand.setText("Class :- "+item.getJsonMemberClass());
        holder.tv_subject.setText("Subject Name :- "+item.getHomeworkName());
        holder.tv_id.setText("ID :- "+item.getHomework_id());
        holder.tv_file.setText("PDF :- "+item.getHomework_pdf());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_div;
        public TextView tv_stand;
        public TextView tv_subject;
        public TextView tv_file;
        public TextView tv_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stand = itemView.findViewById(R.id.tv_stand);
            tv_div = itemView.findViewById(R.id.tv_div);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_file = itemView.findViewById(R.id.tv_file);
            tv_id = itemView.findViewById(R.id.tv_id);
        }
    }
}
