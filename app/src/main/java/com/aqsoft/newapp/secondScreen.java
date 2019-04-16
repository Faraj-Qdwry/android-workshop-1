package com.aqsoft.newapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class secondScreen extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("temps");


        btn = findViewById(R.id.button);
        textView = findViewById(R.id.text1);

        final ArrayList<TempData> list = new ArrayList<>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate();
                Toast.makeText(secondScreen.this, "Push",Toast.LENGTH_SHORT).show();
            }
        });




        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                TempData updatedDate = dataSnapshot.getValue(TempData.class);

                list.add(updatedDate);

                textView.setText(updatedDate.unit+"");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        for (int i = 0; i < list.size(); i++) {
            int t = list.get(i).temp;
        }


    }

    public void setDate(){
        TempData tempData = new TempData();
        tempData.unit = "C";
        tempData.temp = 26;
        tempData.humidity = 0.1245;

        reference.push().setValue(tempData);
    }


}
