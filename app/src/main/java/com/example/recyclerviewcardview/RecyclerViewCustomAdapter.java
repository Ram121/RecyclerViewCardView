package com.example.recyclerviewcardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewCustomAdapter extends RecyclerView.Adapter<RecyclerViewCustomAdapter.MyViewHolder> {

    private final List<String> stringList = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtName) TextView txtName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        ButterKnife.bind(this, itemView);

        }
    }

    public void addStringToList(String value){
        stringList.add(value);
        notifyItemInserted(stringList.size()-1); //Position = size -1 as list starts from 0
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtName.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

}
