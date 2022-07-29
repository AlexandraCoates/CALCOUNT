package com.example.calcount3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RecordDao {
@Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertRecord (Record record);


@Update
    public void updateRecord(Record record);

@Delete

    public void deleteRecord(Record record);

@Query("SELECT * FROM record ORDER BY date DESC")
    List<Record> recordDescDate();

@Query("SELECT * FROM record WHERE rid=:id")
    Record loadSingle(int id);


}
