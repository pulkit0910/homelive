package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_details);

        Bundle bundle1 = getIntent().getExtras();
        getSupportActionBar().setTitle(bundle1.getString("fullname"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ProgressDialog progressDoalog = new ProgressDialog(details.this);
        progressDoalog.setMessage("Loading...");
        progressDoalog.show();

        Bundle bundle = getIntent().getExtras();
        WebView wb = findViewById(R.id.wb);
        wb.setWebViewClient(new WebViewClient());
        wb.loadUrl(bundle.getString("htmlurl"));

        final Handler h = new Handler() {
            @Override
            public void handleMessage(Message message) {
                progressDoalog.dismiss();
            }
        };
        h.sendMessageDelayed(new Message(), 1400);

    }
}

