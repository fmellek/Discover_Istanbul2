package com.example.fme.discover_istanbul;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SportActivity2 extends AppCompatActivity {
     TextView txtBaslik, txtYazar;

     Button btnSil;
     SQliteHelper sqLiteDatabase;
     Context context = this;
     Sport seciliSport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport2);
        txtBaslik = (TextView) findViewById(R.id.txtBaslik);
        txtYazar = (TextView) findViewById(R.id.txtYazar);
        btnSil = (Button) findViewById(R.id.btnSil);

        sqLiteDatabase = new SQliteHelper(context);
        Intent intent = getIntent();
        int id = intent.getIntExtra("sport",-1);
        seciliSport = sqLiteDatabase.sporOku(id);
        txtBaslik.setText(seciliSport.getBaslik());
        txtYazar.setText(seciliSport.getYazar());


    }
    public void btnSil_Click(View view){
        sqLiteDatabase.sportSil(seciliSport);
        finish();
    }

}
