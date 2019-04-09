package com.example.speakout;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

public class Activityu extends AppCompatActivity {
    private Button uprobtn, ratingbtn, reqbtn;
    EditText editname;
    DatabaseReference databaseMember;
    private static final String TAG = "Activityu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityu);
        // Write a message to the database
       final FirebaseDatabase database = FirebaseDatabase.getInstance();
       DatabaseReference myRef = database.getReference("Members");

       // myRef.setValue("Hello, World!");
        editname = (EditText) findViewById(R.id.name);
        reqbtn = (Button) findViewById(R.id.reqbtn);
        reqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=editname.getText().toString();
                databaseMember.push().setValue(value);
            }
        });


        uprobtn = (Button) findViewById(R.id.proid);
        uprobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openuprofile();
            }
        });
        ratingbtn = (Button) findViewById(R.id.rbtn);
        ratingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRating();
            }
        });
    }

    public void openuprofile() {
        Intent intent = new Intent(this, pprofile.class);
        startActivity(intent);
    }

    public void openRating() {
        Intent intent = new Intent(this, Rating.class);
        startActivity(intent);
    }

    /*private void AddMember() {
        String name = editname.getText().toString().trim();
        if (!TextUtils.isEmpty(name)) {
            String id = databaseMember.push().getKey();
            Member member = new Member(id, name);
            databaseMember.child(id).setValue(member);
            Toast.makeText(this, "Member Added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You should enter name", Toast.LENGTH_LONG).show();
        }
    }*/

    public void basicReadWrite() {
        // [START write_message]
        // Write a message to the database
        String name = editname.getText().toString().trim();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Members");

        myRef.setValue("Name:  "+name);


        // [END write_message]

        // [START read_message]
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}

