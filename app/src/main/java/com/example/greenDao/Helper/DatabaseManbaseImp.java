package com.example.greenDao.Helper;

import android.content.Context;
import android.database.sqlite.*;
import android.util.Log;

import com.database.greendao.example.DaoMaster;
import com.database.greendao.example.DaoSession;
import com.database.greendao.example.Info;
import com.database.greendao.example.InfoDao;
import com.database.greendao.example.UserInfo;
import com.database.greendao.example.UserInfoDao;

import java.util.List;

/**
 * Created by liuqiangbin on 2016/8/4.
 */
public class DatabaseManbaseImp extends DatabaseManbase {

    private Context context;

    private DatabaseManbaseImp(Context context) {
        super(context);
        this.context = context;
    }

    private static DatabaseManbaseImp mInstance;

    public synchronized static DatabaseManbaseImp getInstance(Context context){
        if(mInstance == null){
            mInstance = new DatabaseManbaseImp(context);
        }
        return mInstance;
    }


    @Override
    SQLiteOpenHelper createOpenHelper() {
        return new UserDatabaseOpenHelper(context,"user-db",null);
    }

    public List<UserInfo> getUserInfo(){
        try {
            SQLiteDatabase db = getReadDatabase();

            DaoMaster master = new DaoMaster(db);
            DaoSession session = master.newSession();
            UserInfoDao dao = session.getUserInfoDao();
            return dao.loadAll();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public long saveUserInfo(UserInfo info){
        try{
            SQLiteDatabase db = getWriteDatabase();
            DaoMaster master = new DaoMaster(db);
            DaoSession session = master.newSession();
            UserInfoDao dao = session.getUserInfoDao();
            return dao.insertOrReplace(info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }

    public long saveInfo(Info info){
        try{
            SQLiteDatabase db = getWriteDatabase();
            DaoMaster master = new DaoMaster(db);
            DaoSession session = master.newSession();
            InfoDao dao = session.getInfoDao();
            return dao.insertOrReplace(info);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }


    class UserDatabaseOpenHelper extends DaoMaster.OpenHelper {

        public UserDatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(this.getClass().getSimpleName(),"olaVersion: " + oldVersion+",newVersion" + newVersion);

            if (newVersion > oldVersion){
                db.execSQL("ALTER TABLE 'USER_INFO' ADD 'address' TEXT;");
            }

        }
    }
}
