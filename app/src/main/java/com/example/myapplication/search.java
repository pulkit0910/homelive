package com.example.myapplication;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface search {

    @GET("search/repositories")
    Call<Example> getposts2(@QueryMap Map<String,String> id);
}
