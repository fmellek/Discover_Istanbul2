package com.example.fme.discover_istanbul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSport,btnMusic,btnArt,btnParty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSport = (Button) findViewById(R.id.btnSport);
        btnMusic = (Button) findViewById(R.id.btnMusic);
        btnArt = (Button) findViewById(R.id.btnArt);
        btnParty = (Button) findViewById(R.id.btnParty);


    }
    public void onClick_Btn(View view){
        switch (view.getId()){
            case R.id.btnSport:
                Intent intent = new Intent(getApplicationContext(),SportActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMusic:
                intent = new Intent(getApplicationContext(),MusicActivity.class);
                startActivity(intent);
                break;
            case R.id.btnArt:

                break;
            case R.id.btnParty:
                break;
        }

    }
}
