package com.example.calcount3;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity(tableName = "Records")
public class Record {
    @PrimaryKey(autoGenerate = true) @NotNull
    public int rid;

    @ColumnInfo(name = "date") @NotNull
    public LocalDate date;

    @ColumnInfo(name = "food_item") @NotNull
    public String foodItem;

    @ColumnInfo(name = "calorie_count") @NotNull
    public double calorieCount;

    @ColumnInfo(name = "fat_content") @NotNull
    public double fatContent;

    @ColumnInfo(name = "sugar_content") @NotNull
    public double sugarContent;

    //MIGHT HAVE TO DELETE BELOW

    public Record(@NonNull String record){this.foodItem = record;}

    public String getRecord(){return this.foodItem;}
}
