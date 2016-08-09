package com.database.greendao.example;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_INFO".
*/
public class UserInfoDao extends AbstractDao<UserInfo, Void> {

    public static final String TABLENAME = "USER_INFO";

    /**
     * Properties of entity UserInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", false, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Age = new Property(2, Integer.class, "age", false, "AGE");
        public final static Property Sex = new Property(3, Integer.class, "sex", false, "SEX");
        public final static Property Phone = new Property(4, Integer.class, "phone", false, "PHONE");
        public final static Property Address = new Property(5, String.class, "address", false, "ADDRESS");
    };

    private DaoSession daoSession;


    public UserInfoDao(DaoConfig config) {
        super(config);
    }
    
    public UserInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_INFO\" (" + //
                "\"ID\" INTEGER," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"AGE\" INTEGER," + // 2: age
                "\"SEX\" INTEGER," + // 3: sex
                "\"PHONE\" INTEGER," + // 4: phone
                "\"ADDRESS\" TEXT);"); // 5: address
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(3, age);
        }
 
        Integer sex = entity.getSex();
        if (sex != null) {
            stmt.bindLong(4, sex);
        }
 
        Integer phone = entity.getPhone();
        if (phone != null) {
            stmt.bindLong(5, phone);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(6, address);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(3, age);
        }
 
        Integer sex = entity.getSex();
        if (sex != null) {
            stmt.bindLong(4, sex);
        }
 
        Integer phone = entity.getPhone();
        if (phone != null) {
            stmt.bindLong(5, phone);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(6, address);
        }
    }

    @Override
    protected final void attachEntity(UserInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public UserInfo readEntity(Cursor cursor, int offset) {
        UserInfo entity = new UserInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // age
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // sex
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // phone
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // address
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAge(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setSex(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setPhone(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setAddress(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(UserInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(UserInfo entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
