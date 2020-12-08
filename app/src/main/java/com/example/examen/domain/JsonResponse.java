package com.example.examen.domain;

import com.example.examen.models.Pokemon;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {
    @SerializedName("results")
    @Expose
    public final List<Pokemon> results = null;
}
