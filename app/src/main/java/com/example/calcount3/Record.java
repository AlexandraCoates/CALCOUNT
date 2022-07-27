package com.example.calcount3;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity(tableName = "Records")
public class Record {
    @PrimaryKey(autoGenerate = true)
    public int rid;

    @ColumnInfo(name = "date")
    public LocalDate date;

    @ColumnInfo(name = "food_item")
    public String foodItem;

    @ColumnInfo(name = "calorie_count")
    public double calorieCount;

    @ColumnInfo(name = "fat_content")
    public double fatContent;

    @ColumnInfo(name = "sugar_content")
    public double sugarContent;
}
