package com.example.calcount3;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "Record")
public class Record {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    public int rid;

    @ColumnInfo(name = "date")
    @NotNull
    public Date date;

    @ColumnInfo(name = "foodItem")
    @NotNull
    public String foodItem;

    @ColumnInfo(name = "calorieCount")
    @NotNull
    public double calorieCount;

    @ColumnInfo(name = "fatContent")
    @NotNull
    public double fatContent;

    @ColumnInfo(name = "sugarContent")
    @NotNull
    public double sugarContent;

    //MIGHT HAVE TO DELETE BELOW

    public Record(){}

    public Record(String record){this.foodItem = record;}



    public String getRecord(){return this.foodItem;}
}
