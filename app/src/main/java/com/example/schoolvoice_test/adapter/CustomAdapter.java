package com.example.schoolvoice_test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.schoolvoice_test.R;
import com.example.schoolvoice_test.model.Actions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ActionsViewHolder> {

    Context context;
    List<Actions> actionsList;

    public CustomAdapter(Context context, List<Actions> actionsList) {
        this.context = context;
        this.actionsList = actionsList;
    }

    @NonNull
    @Override
    public ActionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rv_item, viewGroup, false);

        return new ActionsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActionsViewHolder holder, int i) {

        Actions mActions = actionsList.get(i);
        holder.viewTitle.setText(mActions.name);
        holder.viewTime.setText(mActions.time);
        Glide.with(context).load(mActions.image).into(holder.viewImage);
    }

    @Override
    public int getItemCount() {
        return actionsList.size();
    }

    public class ActionsViewHolder extends RecyclerView.ViewHolder{

        CircleImageView viewImage;
        TextView viewTitle,viewTime;

        public ActionsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewImage = (CircleImageView)itemView.findViewById(R.id.viewImage);
            this.viewTitle = (TextView)itemView.findViewById(R.id.viewTitle);
            this.viewTime = (TextView)itemView.findViewById(R.id.viewTime);

        }
    }




}
