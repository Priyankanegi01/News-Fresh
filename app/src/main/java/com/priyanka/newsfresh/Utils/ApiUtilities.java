package com.priyanka.newsfresh.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.priyanka.newsfresh.Utils.Config.BASE_URL;

public class ApiUtilities {
    private static Retrofit retrofit;
    public static ApiInterface getApiInterface() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
