package lat.pam.foodapp;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class FoodData {
    public static ArrayList<Food> getData(Context context) {
        ArrayList<Food> list = new ArrayList<Food>();
        list.add(new Food("Mie Goreng", "Mie goreng adalah hidangan mie goreng khas Indonesia yang populer hingga ke mancanegara, yang pastinya disukai semua orang. Mie goreng khas Indonesia sangat menggugah selera, biasanya ditambahkan denagn saus kecap manis dan gurih yang lezat.", 10000, context.getDrawable(R.drawable.mie_goreng), R.drawable.mie_goreng));
        list.add(new Food("Nasi Goreng", "Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng, margarin, atau mentega. Biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya; seperti telur, ayam, dan kerupuk.", 15000, context.getDrawable(R.drawable.nasigoreng), R.drawable.nasigoreng));
        list.add(new Food("Kopi Hitam", "kopi hitam dapat memberikan energi, menurunkan berat badan, dan meningkatkan fokus. Kandungan kafein yang ada dalam kopi dapat meningkatkan suasana hati, membantu otak bekerja lebh baik, dan meningkatkan stamina selama melakukan olahraga.", 3000, context.getDrawable(R.drawable.kopi_hitam), R.drawable.kopi_hitam));
        list.add(new Food("Cireng", "Cireng adalah camilan dari tepung aci yang dipipihkan kemudian digoreng. Itu sebabnya nama makanan ini cireng yang berasal dari singkatan aci digoreng. Cara membuat cireng juga sangat mudah. Pertama, kamu bisa membuat adonan biang yang dibuat dari sedikit tepung aci dan air yang direbus sampai menyerupai lem.", 12000, context.getDrawable(R.drawable.cireng),R.drawable.cireng));
        list.add(new Food("Donat", "Donat adalah penganan yang digoreng, dibuat dari adonan tepung terigu, gula, telur, dan mentega. Donat yang paling umum adalah donat berbentuk cincin dengan lubang di tengah dan donat berbentuk bundar dengan isian manis, seperti selai, jelly, krim, dan custard.", 5000, context.getDrawable(R.drawable.donut), R.drawable.donut));
        return list;
    }

    public static void tambahData(Context context){
        Database database = new Database(context);
        ArrayList<Food> foods = getData(context);

        for (Food product:foods){
            database.insertData(product);
        }
    }
}