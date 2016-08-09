package com.example.greenDaoTest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;



import com.database.greendao.example.UserInfo;
import com.example.greenDao.Helper.DatabaseManbaseImp;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        UserInfo userInfo = new UserInfo(100L,"aland",30,1,8888888,"beijing");
//        long id = getDbMan().saveUserInfo(userInfo);
//        if(id > 0){
//            Log.d("MainActivity","database save success");
//        }

        List<UserInfo> infos = getDbMan().getUserInfo();
        if(infos != null && infos.size()>0){
            Log.d("MainActivity","database get data row:" + infos.size());
        }
    }

    private DatabaseManbaseImp getDbMan(){
        return DatabaseManbaseImp.getInstance(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

}
