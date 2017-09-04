package test.hk.com.KkDriving.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * Created by 1 on 2017/8/5.
 */

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context.getApplicationContext(), "reslut.db", null , 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_table1 = "create table right_table ("
                + "_id integer primary key autoincrement, "
                + "right integer)";
        String CREATE_table2 = "create table mistake_table ("
                + "_id integer primary key autoincrement, "
                + "mistake integer)";

        db.execSQL(CREATE_table1);
        db.execSQL(CREATE_table2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
