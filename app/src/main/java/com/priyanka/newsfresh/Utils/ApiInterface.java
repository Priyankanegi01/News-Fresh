package com.priyanka.newsfresh.Utils;

import com.priyanka.newsfresh.POJO.mainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
   @GET("top-headlines")
    Call<mainNews>getNews(
            @Query("country")String country,
            @Query("pageSize")int pagesize,
            @Query("apiKey")String apikey);
    @GET("top-headlines")
    Call<mainNews>getCategoryNews(
            @Query("country")String country,
            @Query("category")String category,
            @Query("pageSize")int pagesize,
            @Query("apiKey")String apikey);

}
