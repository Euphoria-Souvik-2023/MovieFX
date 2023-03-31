package com.example.moviefx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moviefx.pojo.Movie;
import com.example.moviefx.utility.DataAdapter;
import com.example.moviefx.utility.DataLoader;
import com.example.moviefx.utility.Parse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    private TextView output;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        LoaderManager.LoaderCallbacks<String> callbacks=new LoaderManager.LoaderCallbacks<String>() {
            @NonNull
            @Override
            public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
                DataLoader loader=new DataLoader(MainActivity.this);
                return loader;
            }

            @Override
            public void onLoadFinished(@NonNull Loader<String> loader, String data) {
              ArrayList<Movie> list=Parse.parseJSON(data);

                DataAdapter adapter=new DataAdapter(getApplicationContext(),list);
                LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoaderReset(@NonNull Loader<String> loader) {
                submit.setVisibility(View.GONE);

            }
        };
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoaderManager.getInstance(MainActivity.this).initLoader(1,null,callbacks);

            }
        });
    }

    private void init() {
        submit = (Button) findViewById(R.id.apiButton);
        recyclerView=findViewById(R.id.recylerView);
    }
}