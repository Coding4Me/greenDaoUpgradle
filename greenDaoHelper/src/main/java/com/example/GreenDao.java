package com.example;

import org.greenrobot.greendao.generator.*;

public class GreenDao {

    public static void main(String[] args) {
        System.out.println("------  gen dao begin  ------");

        Schema schema = new Schema(2, "com.database.greendao.example"); //Upgrade database version
        schema.enableKeepSectionsByDefault();
        schema.enableActiveEntitiesByDefault();
        adUserItem(schema);
        adInfoItem(schema);
        try {
            new DaoGenerator().generateAll(schema, "app/greendao_gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------  gen dao end  ------");
    }

    private static void adUserItem(Schema schema){
        Entity entity = schema.addEntity("UserInfo");
        entity.addLongProperty("id");
        entity.addStringProperty("name");
        entity.addIntProperty("age");
        entity.addIntProperty("sex");
        entity.addIntProperty("phone");
        entity.addStringProperty("address");
    }

    private static void adInfoItem(Schema schema){
        Entity entity = schema.addEntity("Info");
        entity.addLongProperty("id");
        entity.addStringProperty("name");
        entity.addIntProperty("age");
        entity.addIntProperty("sex");
        entity.addIntProperty("phone");
        entity.addStringProperty("address");
    }
}
