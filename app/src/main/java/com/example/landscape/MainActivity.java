package com.example.landscape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLeft;
    private RecyclerView recyclerViewRight;
    private Button leftToRight;
    private Button RightToLeft;
    public static ArrayList<String> myListLeft;
    public static ArrayList<String> myListRight;
    public static ArrayList<String> deleteElementsLeft;
    public static ArrayList<String> deleteElementsRight;
    private ShiftingRecylerViewAdapterLeft recyclerViewAdapterLeft;
    private ShiftingRecylerViewAdapterRight recyclerViewAdapterRight;
    private LinearLayoutManager linearLayoutManagerLeft;
    private LinearLayoutManager linearLayoutManagerRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewLeft = findViewById(R.id.recyler_view_left);
        recyclerViewRight = findViewById(R.id.recyler_view_right);
        leftToRight = findViewById(R.id.left_to_right);
        RightToLeft = findViewById(R.id.right_to_left);

        myListLeft = new ArrayList<>();
        myListRight = new ArrayList<>();

        deleteElementsLeft = new ArrayList<>();
        deleteElementsRight = new ArrayList<>();

        leftToRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("testing", myListLeft.toString());
                for (int i=0;i<deleteElementsLeft.size();i++){
                    myListRight.add(deleteElementsLeft.get(i));
                    myListLeft.remove(deleteElementsLeft.get(i));
                }
                deleteElementsLeft.clear();

                ShiftingRecylerViewAdapterLeft recyclerViewAdapter=new ShiftingRecylerViewAdapterLeft(getApplicationContext(), myListLeft);
                linearLayoutManagerLeft=new LinearLayoutManager(getApplicationContext());
                recyclerViewLeft.setLayoutManager(linearLayoutManagerLeft);
                recyclerViewLeft.setAdapter(recyclerViewAdapter);

                recyclerViewAdapterRight =new ShiftingRecylerViewAdapterRight(getApplicationContext(), myListRight);
                linearLayoutManagerRight =new LinearLayoutManager(getApplicationContext());
                recyclerViewRight.setLayoutManager(linearLayoutManagerRight);
                recyclerViewRight.setAdapter(recyclerViewAdapterRight);
            }
        });
        RightToLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("testing", myListRight.toString());
                for (int i=0;i<deleteElementsRight.size();i++){
                    myListLeft.add(deleteElementsRight.get(i));
                    myListRight.remove(deleteElementsRight.get(i));
                }
                deleteElementsRight.clear();

                recyclerViewAdapterLeft =new ShiftingRecylerViewAdapterLeft(getApplicationContext(), myListLeft);
                linearLayoutManagerLeft=new LinearLayoutManager(getApplicationContext());
                recyclerViewLeft.setLayoutManager(linearLayoutManagerLeft);
                recyclerViewLeft.setAdapter(recyclerViewAdapterLeft);

                recyclerViewAdapterRight =new ShiftingRecylerViewAdapterRight(getApplicationContext(), myListRight);
                linearLayoutManagerRight =new LinearLayoutManager(getApplicationContext());
                recyclerViewRight.setLayoutManager(linearLayoutManagerRight);
                recyclerViewRight.setAdapter(recyclerViewAdapterRight);
            }
        });

        for(int i=0;i<10;i++){
            myListLeft.add("Element"+(i+1));
        }

        ShiftingRecylerViewAdapterLeft recyclerViewAdapter=new ShiftingRecylerViewAdapterLeft(getApplicationContext(), myListLeft);
        linearLayoutManagerLeft=new LinearLayoutManager(getApplicationContext());
        recyclerViewLeft.setLayoutManager(linearLayoutManagerLeft);
        recyclerViewLeft.setAdapter(recyclerViewAdapter);
    }
}