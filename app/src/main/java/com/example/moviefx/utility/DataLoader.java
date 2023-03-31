package com.example.moviefx.utility;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataLoader extends AsyncTaskLoader<String> {


    public DataLoader(Context context){
        super(context);
    }
    @Nullable
    @Override
    public String loadInBackground() {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url("https://netflix54.p.rapidapi.com/search/?query=stranger&offset=0&limit_titles=50&limit_suggestions=20&lang=en")
                    .get()
                    .addHeader("X-RapidAPI-Key", "d7afa8363cmsh0ae0299c297b24dp151272jsnc86a49a28f77")
                    .addHeader("X-RapidAPI-Host", "netflix54.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
          String result= response.body().string();
          return result;
        }catch (IOException e){

        }
        return "Hoyni";
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
