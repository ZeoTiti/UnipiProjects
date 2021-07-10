package com.example.polit.onlineshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView mText;
    private DatabaseReference mDatabase;
    public ValueEventListener mListener;
    public ArrayList<Mobile> mMobiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById(R.id.textView);

        mMobiles = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> products = dataSnapshot.child("products").getChildren();

                for (DataSnapshot product : products) {
                    Mobile mobile = product.getValue(Mobile.class);
                    mMobiles.add(mobile);
                }

                mText.setText(mMobiles.get(0).getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        Mobile iphone = new Mobile("Galaxy Note", 1099);
        Mobile xiaomi = new Mobile("Huawei G2", 169);
        mDatabase.child("products").child(iphone.getID()).setValue(iphone);
        mDatabase.child("products").child(xiaomi.getID()).setValue(xiaomi);

        mDatabase.addValueEventListener(mListener);
    }
}
