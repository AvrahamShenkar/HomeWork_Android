package com.example.avraham.homeWork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


class BirthDayAdopter extends RecyclerView.Adapter<BirthDayAdopter.ViewHolder> {

    List<BirthDay> _bDays;

    public BirthDayAdopter(List bDays) {
        this._bDays = bDays;
    }

    @Override
    public BirthDayAdopter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_person_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BirthDayAdopter.ViewHolder holder, int position) {
        holder.fullName.setText(this._bDays.get(position).getName());
        holder.birthDate.setText("Birth Date: " + this._bDays.get(position).getBirthDate().toString());
        holder.description.setText(this._bDays.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return  this._bDays.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView fullName;
        public TextView birthDate;
        public TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.full_name);
            birthDate = itemView.findViewById(R.id.birthDay_date);
            description = itemView.findViewById(R.id.comment);
        }
    }
}
