package com.example.fme.discover_istanbul;

/**
 * Created by FME on 17.12.2017.
 */

public class Sport {
    int id;
    String baslik;
    String yazar;

    public Sport() {
    }

    public Sport(String baslik, String yazar) {
        this.baslik = baslik;
        this.yazar = yazar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }
}
