package com.example.moviefx.utility;

import com.example.moviefx.pojo.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Parse {
    private Parse(){
    }
    public static ArrayList<Movie> parseJSON(String json) {
        ArrayList<Movie> movieArrayList=new ArrayList<>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray items=object.optJSONArray("titles");
            for(int i=0;i<items.length();i++){
                JSONObject itemObject=items.getJSONObject(i);
                JSONObject jawSummary=itemObject.optJSONObject("jawSummary");
                String title=jawSummary.optString("title");
                String year=jawSummary.optString("releaseYear");
                String synopsis=jawSummary.optString("synopsis");
                movieArrayList.add(new Movie(title,year,synopsis));
            }
        }catch (JSONException e){
            e.printStackTrace();
                    }
        return movieArrayList;
    }
}
