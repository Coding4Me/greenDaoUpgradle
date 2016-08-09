package com.example.greenDao.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by liuqiangbin on 2016/8/4.
 */
public abstract class DatabaseManbase  {

    private Context context;

    private SQLiteOpenHelper mHelper;

    public DatabaseManbase(Context context){
        this.context = context.getApplicationContext();
    }

    protected SQLiteDatabase getReadDatabase(){
        return getOpenHelper().getReadableDatabase();
    }

    protected SQLiteDatabase getWriteDatabase(){
        try{
            return getOpenHelper().getWritableDatabase();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    abstract SQLiteOpenHelper createOpenHelper();

    private SQLiteOpenHelper getOpenHelper(){
        if (mHelper == null) {
            try {
                mHelper = createOpenHelper();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return mHelper;
    }


}
