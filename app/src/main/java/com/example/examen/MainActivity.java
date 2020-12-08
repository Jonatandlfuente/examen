package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.examen.apiRest.ApiPokemon;
import com.example.examen.constants.Constants;
import com.example.examen.domain.JsonResponse;
import com.example.examen.models.Pokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public final String TAG = getClass().getName();
    private ArrayList<Pokemon> mPokemon = new ArrayList<>();
    public static String name="";
    public static String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllPokemon();
    }

    public void getAllPokemon() {

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(Constants.HEADER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiPokemon pokeApi=retrofit.create(ApiPokemon.class);
      //  Log.d(TAG, "Parametros de entrada: " + name + " " + url);

       pokeApi.getParamPokemon(200,0).enqueue(new Callback<JsonResponse>() {
    @Override
    public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
        if (response != null && response.body() != null) {
            mPokemon = (ArrayList<Pokemon>) response.body().results;
            Log.d(TAG, "array de solo pokemon. Inicio");
           // Intent sendPokemon = new Intent(getApplicationContext(),ActivityViewAdapter.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("LIST",mPokemon);
          //  sendPokemon.putExtras(bundle);
           // startActivity(sendPokemon);

            for (Pokemon mPokemon : mPokemon) {
                Log.d(TAG, mPokemon.getName() == null ? "" : mPokemon.getName()); //e.getLocalizedMessage() == null ? "" : e.getLocalizedMessage()
                Log.d(TAG, mPokemon.getUrl() == null ? "" : mPokemon.getUrl());
              //  Log.d(TAG, String.valueOf(mPool.getLocation().getLongitude() == 0 ? "" : mPool.getLocation().getLongitude()));
            }
            Log.d(TAG, "Parametros de salida: " + name + " " + url);
            Log.d(TAG, "array de solo pokemon. Fin");
        }
    }

    @Override
    public void onFailure(Call<JsonResponse> call, Throwable t) {

    }
});


    }
}