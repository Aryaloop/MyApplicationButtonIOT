package com.example.myapplicationbuttoniot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button onRelay01 = (Button) findViewById(R.id.onRelay01);
        final Button offRelay01 = (Button) findViewById(R.id.offRelay01);

        final Button onRelay02 = (Button) findViewById(R.id.onRelay02);
        final Button offRelay02 = (Button) findViewById(R.id.offRelay02);

        final Button onRelay03 = (Button) findViewById(R.id.onRelay03);
        final Button offRelay03 = (Button) findViewById(R.id.offRelay03);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refRelay1 = database.getReference("Relay01");
        DatabaseReference refRelay2 = database.getReference("Relay02");
        DatabaseReference refRelay3 = database.getReference("Relay03");

        refRelay1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    final Long message = dataSnapshot.getValue(Long.class);

                    if (message==1){
                        onRelay01.setVisibility(View.GONE);
                        offRelay01.setVisibility(View.VISIBLE);
                    }else if(message==0){
                        offRelay01.setVisibility(View.GONE);
                        onRelay01.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        onRelay01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("Relay01");

                myref.setValue(1);
            }
        });
        offRelay01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("Relay01");

                myref.setValue(0);
            }
        });


        refRelay2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    final long message = dataSnapshot.getValue(long.class);

                    if(message==1){
                        onRelay02.setVisibility(View.GONE);
                        offRelay02.setVisibility(View.VISIBLE);
                    } else if (message==0) {
                        offRelay02.setVisibility(View.GONE);
                        onRelay02.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        refRelay3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    final Long message = dataSnapshot.getValue(Long.class);

                    if (message==1){
                        onRelay03.setVisibility(View.GONE);
                        offRelay03.setVisibility(View.VISIBLE);
                    }else if(message==0){
                        offRelay03.setVisibility(View.GONE);
                        onRelay03.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        onRelay02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("Relay02");
                myref.setValue(1);
            }
        });
        offRelay02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("Relay02");
                myref.setValue(0);
            }
        });

        onRelay03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("Relay03");

                myref.setValue(1);
            }
        });
        offRelay03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("Relay03");

                myref.setValue(0);
            }
        });
    }
}