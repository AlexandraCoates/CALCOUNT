package com.example.calcount3;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

//Not sure if I will actually need this but I think I will for the displaying of data in the Add/Edit records screen.

public class RecordViewModel extends AndroidViewModel {
    private RecordDao recordDao;
    private final List<Record> rAllRecords;

    private  RecordViewModel(Application application){
        super(application);
        rAllRecords = recordDao.recordDescDate();
        recordDao.recordDescDate();
    }
    List<Record> getAllRecords() {return rAllRecords; }

}
