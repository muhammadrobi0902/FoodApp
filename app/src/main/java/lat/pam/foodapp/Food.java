package lat.pam.foodapp;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;

import java.io.File;

public class Food {
    String judul;
    String deskripsi;
    int harga;
    Drawable image;
    int img;

    Food(String judul, String deskripsi, int harga, Drawable image, int img) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.image = image;
        this.img = img;
    }
}