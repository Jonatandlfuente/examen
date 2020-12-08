package com.example.examen.apiRest;

import com.example.examen.constants.Constants;
import com.example.examen.domain.JsonResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiPokemon {
    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(Constants.END_POINT )
    Call<JsonResponse> getPokemon();
//@Query("name") String name, @Query("url") String url
    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(Constants.END_POINT )
    Call<JsonResponse> getParamPokemon(@Query("limit") int limit,@Query("offset") int offset);

    /*@Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(Constants.END_POINT )
    Call<JsonResponse> getPathPokemon(@Path("name") String name);*/
}
