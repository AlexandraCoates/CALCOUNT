package com.example.calcount3;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


//Creation of the App Database and assigning it its DAO.
@Database(entities = {Record.class}, version = 1)
public abstract class App_Database extends RoomDatabase {
    public abstract RecordDao recordDao();

    //Builds the database to be visible - I think
    private static volatile App_Database INSTANCE;
    static App_Database getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (App_Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            App_Database.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
