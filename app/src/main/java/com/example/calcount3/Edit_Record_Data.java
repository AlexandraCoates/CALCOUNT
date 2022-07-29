package com.example.calcount3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Edit_Record_Data#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Edit_Record_Data extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Record record;
    Button btnDelete;
    Button btnEdit;
    EditText dateEdit;
    EditText foodItemEdit;
    EditText calorieCountEdit;
    EditText fatContentEdit;
    EditText sugarContentEdit;
    public Edit_Record_Data() {
        // Required empty public constructor
    }

    public Edit_Record_Data(int id)
    {
        record = App_Database.getDatabase(getActivity())
                .recordDao()
                .loadSingle(id);
    }

    public static Edit_Record_Data newInstance(int id)
    {
        Edit_Record_Data fragment = new Edit_Record_Data(id);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Edit_Record_Data.
     */
    // TODO: Rename and change types and number of parameters
    public static Edit_Record_Data newInstance(String param1, String param2) {
        Edit_Record_Data fragment = new Edit_Record_Data();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_edit__record__data, container, false);
        dateEdit = (EditText) view.findViewById(R.id.DateEdit);
        foodItemEdit = (EditText) view.findViewById(R.id.FoodItemEdit);
        calorieCountEdit = (EditText) view.findViewById(R.id.CalorieCountEdit);
        fatContentEdit = (EditText) view.findViewById(R.id.FatContentEdit);
        sugarContentEdit = (EditText) view.findViewById(R.id.SugarContentEdit);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dateEdit.setText(sdf.format(record.date));
        foodItemEdit.setText(record.foodItem);
        calorieCountEdit.setText(String.valueOf(record.calorieCount));
        fatContentEdit.setText(String.valueOf(record.fatContent));
        sugarContentEdit.setText(String.valueOf(record.sugarContent));
        btnEdit = (Button) view.findViewById(R.id.SaveEdit);
        btnEdit.setOnClickListener(editHandler);
        btnDelete = (Button) view.findViewById(R.id.DeleteEdit);
        btnDelete.setOnClickListener(editHandler);


        return view;
    }

    View.OnClickListener editHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btnDelete)
            {
                App_Database.getDatabase(getActivity())
                        .recordDao()
                        .deleteRecord(record);


                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frameLayout, Add_Edit_Records.newInstance("", "")).commit();
            } else if (view == btnEdit)
            {
                Log.e("Edit", "Click");
                boolean saveable = true;
                Log.e("Save", "Click");
                if(dateEdit.getText().toString().trim().length() == 0)
                {
                    dateEdit.setHint("Please enter a date");
                    saveable = false;
                }
                if(foodItemEdit.getText().toString().trim().length() == 0)
                {
                    foodItemEdit.setHint("Please enter a food type");
                    saveable = false;
                }
                if(calorieCountEdit.getText().toString().trim().length() == 0)
                {
                    calorieCountEdit.setHint("Please enter the calories");
                    saveable = false;
                }
                if(sugarContentEdit.getText().toString().trim().length() == 0)
                {
                    sugarContentEdit.setHint("Please enter the sugar content");
                    saveable = false;
                }
                if(fatContentEdit.getText().toString().trim().length() == 0)
                {
                    fatContentEdit.setHint("Please enter the fat content");
                    saveable = false;
                }
                if(saveable == true)
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        record.date = (Date) sdf.parse(dateEdit.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    record.foodItem = foodItemEdit.getText().toString();
                    record.sugarContent = Double.parseDouble(sugarContentEdit.getText().toString());
                    record.calorieCount = Double.parseDouble(calorieCountEdit.getText().toString());
                    record.fatContent = Double.parseDouble(fatContentEdit.getText().toString());
                    App_Database.getDatabase(getActivity())
                            .recordDao()
                            .updateRecord(record);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, Add_Edit_Records.newInstance("", "")).commit();
                }
            }

        }
    };


}