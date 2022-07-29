package com.example.calcount3;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add_Record_Data#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_Record_Data extends Fragment {

    Button btnSave;
    EditText dateAdd;
    EditText foodItemAdd;
    EditText caloriesAdd;
    EditText fatsAdd;
    EditText sugarsAdd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }
    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == btnSave) {
                boolean saveable = true;
                Log.e("Save", "Click");
                if(dateAdd.getText().toString().trim().length() == 0)
                {
                    dateAdd.setHint("Please enter a date");
                    saveable = false;
                }
                if(foodItemAdd.getText().toString().trim().length() == 0)
                {
                    foodItemAdd.setHint("Please enter a food type");
                    saveable = false;
                }
                if(caloriesAdd.getText().toString().trim().length() == 0)
                {
                    caloriesAdd.setHint("Please enter the calories");
                    saveable = false;
                }
                if(sugarsAdd.getText().toString().trim().length() == 0)
                {
                    sugarsAdd.setHint("Please enter the sugar content");
                    saveable = false;
                }
                if(fatsAdd.getText().toString().trim().length() == 0)
                {
                    fatsAdd.setHint("Please enter the fat content");
                    saveable = false;
                }
                if(saveable == true)
                {
                    Record record = new Record();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        record.date = (Date) sdf.parse(dateAdd.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    record.foodItem = foodItemAdd.getText().toString();
                    record.sugarContent = Double.parseDouble(sugarsAdd.getText().toString());
                    record.calorieCount = Double.parseDouble(caloriesAdd.getText().toString());
                    record.fatContent = Double.parseDouble(fatsAdd.getText().toString());
                    App_Database.getDatabase(getActivity())
                            .recordDao()
                            .insertRecord(record);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, Add_Edit_Records.newInstance("", "")).commit();

                }
            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add__record__data, container, false);

        btnSave = (Button) view.findViewById(R.id.SaveAdd);
        btnSave.setOnClickListener(handler);
        dateAdd = (EditText) view.findViewById(R.id.DateAdd);
        dateAdd.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));
        foodItemAdd = (EditText) view.findViewById(R.id.FoodItemAdd);
        caloriesAdd = (EditText) view.findViewById(R.id.CalorieCountAdd);
        fatsAdd = (EditText) view.findViewById(R.id.FatContentAdd);
        sugarsAdd = (EditText) view.findViewById(R.id.SugarContentAdd);
        return view;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Add_Record_Data() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Add_Record_Data.
     */
    // TODO: Rename and change types and number of parameters
    public static Add_Record_Data newInstance(String param1, String param2) {
        Add_Record_Data fragment = new Add_Record_Data();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


}