package com.example.calcount3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Record.class}, version = 1)
public abstract class App_Database extends RoomDatabase {
    public abstract RecordDao recordDao();
}
