package lat.pam.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    // static variable
    private static final int DB_VERSION = 1;

    // Database name
    private static final String DB_NAME = "Food.db";
    private static final String TABLE_NAME = "products";

    // column tables
    private static final String ID = "id"; //0
    private static final String TITLE = "judul"; //1
    private static final String DESCRIPT = "deskripsi"; //2
    private static final String PRICE = "harga"; //3
    private static final String IMG = "image"; //4


    public Database(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT," + DESCRIPT + " TEXT," + PRICE + " INTEGER,"
                + IMG + " INTEGER" + ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertData(Food product){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, product.judul);
        values.put(DESCRIPT, product.deskripsi);
        values.put(PRICE, product.harga);
        values.put(IMG, product.img);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Food> getfoods(Context context) {

        ArrayList<Food> foodList = new ArrayList<Food>();

        String query = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(1);
                String descript = cursor.getString(2);
                int price = cursor.getInt(3);
                Drawable image = context.getDrawable(cursor.getInt(4));
                int imgInt = cursor.getInt(4);

                Food product = new Food(title, descript, price, image, imgInt);

                foodList.add(product);
            } while (cursor.moveToNext());
        }
        return foodList;
    }
}
