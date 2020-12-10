package com.example.examen.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import com.example.examen.R;
import com.example.examen.impl.ViewAdapter;
import com.example.examen.models.Pokemon;

import java.util.ArrayList;

public class ActivityViewAdapter extends AppCompatActivity {

    public final String TAG = getClass().getName();
    private ViewAdapter mViewAdapter;
    private ListView mViewList = null;
    private ListView mViewSports = null;
    private Pokemon poolclick;
    private ArrayList<Pokemon> pokemon = new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_adapter);
        Bundle bundle = getIntent().getExtras();
        pokemon = bundle.getParcelableArrayList("LIST");
        Log.d(TAG, "Antes de recibir el intent de la lista");
        for (Pokemon pokemon : pokemon) {
            Log.d(TAG, "He entrado en el array de piscinas");
            Log.d(TAG, pokemon.getName());
            Log.d(TAG, pokemon.getUrl());
            // Log.d(TAG, String.valueOf(pool.getLocation().getLatitude()));
        }
        mViewList = findViewById(R.id.myListView);
        Log.d(TAG, "Tamaño del array de piscinas antes de entrar en el viewAdapter:");
        Log.d(TAG, String.valueOf(pokemon));
        mViewAdapter = new ViewAdapter(getApplicationContext(), pokemon);
        mViewList.setAdapter(mViewAdapter);
        mViewAdapter.notifyDataSetChanged();
    }
}