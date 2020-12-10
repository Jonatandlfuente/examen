package com.example.examen.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.examen.R;
import com.example.examen.models.Pokemon;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViewAdapter extends BaseAdapter {
    private Context mcontext;
    private List<Pokemon> mPokemon;

    @Builder
    public ViewAdapter(Context mcontext, List<Pokemon> mPokemon) {
        this.mcontext = mcontext;
        this.mPokemon = mPokemon;
    }
    @Override
    public int getCount() {
        return mPokemon.size();
    }

    @Override
    public Object getItem(int mPokemon) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.views_of_pokemon, null);
        }

        TextView textView = convertView.findViewById(R.id.txtPokemon);
        textView.setText(mPokemon.get(position).getName());

        TextView textView1= convertView.findViewById(R.id.txtUrlPokemon);
        textView1.setText(mPokemon.get(position).getUrl());
        return convertView;
    }
}
