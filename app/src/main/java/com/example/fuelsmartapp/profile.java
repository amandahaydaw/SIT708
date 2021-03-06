package com.example.fuelsmartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class profile extends AppCompatActivity {
    TextView hi, back;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId, text;


    Intent intend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        hi = findViewById(R.id.hi);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            userId = fAuth.getCurrentUser().getUid();
            DocumentReference documentReference = fStore.collection("users").document(userId);
            documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                    hi.setText(documentSnapshot.getString("fName"));
                }
            });
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void back(View view) {
        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
    }


    public void sign_out(View view) {
        FirebaseAuth.getInstance().signOut();//logout
//        startActivity(new Intent(getApplicationContext(), signup.class));
        finish();
    }

    public void data(View view) {
        Toast.makeText(this, "Service is not available !", Toast.LENGTH_LONG).show();
    }
    public void account(View view) {
        Toast.makeText(this, "Service is not available !", Toast.LENGTH_LONG).show();
    }
    public void personal(View view) {
        Toast.makeText(this, "Service is not available !", Toast.LENGTH_LONG).show();
    }
    public void security(View view) {
        Toast.makeText(this, "Service is not available !", Toast.LENGTH_LONG).show();
    }
    public void message(View view) {
        Toast.makeText(this, "Service is not available !", Toast.LENGTH_LONG).show();
    }
}