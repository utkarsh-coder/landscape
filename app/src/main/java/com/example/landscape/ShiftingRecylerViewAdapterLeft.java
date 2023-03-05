package com.example.landscape;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShiftingRecylerViewAdapterLeft extends RecyclerView.Adapter<ShiftingRecylerViewAdapterLeft.ViewHolder> {

    private Context context;
    private  List<String> myList;


    public ShiftingRecylerViewAdapterLeft(Context context, List<String> myList){
        this.context=context;
        this.myList =myList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String rowText = myList.get(position);
        holder.rowText.setText(rowText);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text = myList.get(position);
                Toast.makeText(context, text+"default", Toast.LENGTH_SHORT).show();
                holder.rowText.setBackgroundColor(Color.parseColor("#63D568"));
                if (!MainActivity.deleteElementsLeft.contains(myList.get(position))) {
                    MainActivity.deleteElementsLeft.add(myList.get(position));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView rowText;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            rowText = (TextView) itemView.findViewById(R.id.recyler_row);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
