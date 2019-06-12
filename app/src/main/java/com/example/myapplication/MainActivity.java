package com.example.myapplication;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String keyword;
    ProgressDialog progressDoalog;
    ArrayList<gitdescription> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView r1 = findViewById(R.id.r1);
        final LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        arraylist = new ArrayList<gitdescription>();
        final EditText ed1 = findViewById(R.id.search2);
        Button back = findViewById(R.id.back);
        Button searchbtn = findViewById(R.id.searchbtn);



        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading...");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
            }
        });



        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arraylist.clear();
                keyword = ed1.getText().toString();
                progressDoalog.show();


        if(keyword!=""){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        search Jsonplaceholderapi = retrofit.create(search.class);

        r1.setHasFixedSize(true);

        ImmutableMap<String,String> myMap = ImmutableMap.<String, String>builder()
                .put("q",keyword)
                .build();



        Call<Example> call = Jsonplaceholderapi.getposts2(myMap);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(!response.isSuccessful()){
                    progressDoalog.dismiss();
                    Toast.makeText(MainActivity.this, "Request UnSuccessful", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDoalog.dismiss();
                ArrayList<Item> photodata = response.body().getItems();
                for(int i=0 ;i<photodata.size();i++){
                    arraylist.add(new gitdescription(photodata.get(i).getFullName(),photodata.get(i).getHtmlUrl(),photodata.get(i).getDescription(),photodata.get(i).getLanguage()));
                    //Toast.makeText(MainActivity.this,arraylist.get(i).getR(),Toast.LENGTH_SHORT).show();
                }
                r1.setLayoutManager(manager);
                r1.setAdapter(new adapter(arraylist,getApplicationContext()));

            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        }
        else{
            Toast.makeText(MainActivity.this,"enter some text to search",Toast.LENGTH_SHORT).show();
        }

            }
        });


    }
}
