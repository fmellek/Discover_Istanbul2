package com.example.fme.discover_istanbul;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SportActivity extends AppCompatActivity {
    Context context = this;
    ListView listemiz;
    List<Sport> list;
    SQliteHelper sqLiteDatabase = new SQliteHelper(context);
    ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        listemiz = (ListView) findViewById(R.id.listemiz);
        sqLiteDatabase.onUpgrade(sqLiteDatabase.getWritableDatabase(),1,2);
        sqLiteDatabase.KitapEkle(new Sport("Calikusu","Resa nuri guntekin"));
        sqLiteDatabase.KitapEkle(new Sport("Calik","Resa nuri gtekin"));
        sqLiteDatabase.KitapEkle(new Sport("Calkus","Resa nuri gntekin"));
        sqLiteDatabase.KitapEkle(new Sport("Cakusu","Resa nuguntekin"));
        list = sqLiteDatabase.sporlariGetir();
        List<String> listBaslik = new ArrayList<>();
        for (int i = 0; i < list.size();i++){
            listBaslik.add(i,list.get(i).getBaslik());
        }
        mAdapter = new ArrayAdapter<String>(context,R.layout.satir_layout,R.id.listMetin,listBaslik);
        listemiz.setAdapter(mAdapter);
        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context,SportActivity2.class);
                intent.putExtra("sport",list.get(i).getId());
                Log.i("idimiz", String.valueOf(list.get(i).getId()));
                startActivityForResult(intent,1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        list = sqLiteDatabase.sporlariGetir();
        List<String> listBaslik = new ArrayList<>();
        for (int i = 0; i < list.size();i++){
            listBaslik.add(i,list.get(i).getBaslik());
        }
        mAdapter = new ArrayAdapter<String>(context,R.layout.satir_layout,R.id.listMetin,listBaslik);
        listemiz.setAdapter(mAdapter);
    }
}
