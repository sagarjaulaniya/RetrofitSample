package com.example.retrofitsample.Practice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofitsample.R;

import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    List<Comment> commentArrayList;

    public RecyclerViewAdapter(Context context, List<Comment> commentArrayList) {
        this.context = context;
        this.commentArrayList = commentArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylerview_design, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Comment comment = commentArrayList.get(i);
        holder.tv1.setText(comment.getPostId() + " ");
        holder.tv2.setText(comment.getId() + " ");
        holder.tv3.setText(comment.getName());
        holder.tv4.setText(comment.getBody());
        holder.tv5.setText(comment.getEmail());
    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2, tv3, tv4, tv5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
            tv5 = itemView.findViewById(R.id.tv5);
        }
    }
}
