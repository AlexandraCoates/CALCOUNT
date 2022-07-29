package com.example.calcount3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Add_Edit_Records-newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add_Edit_Records extends Fragment {

    Button btnAdd;
    Button btnEdit;
    LinearLayout list;
    ArrayList<RadioButton> radioButtons = new ArrayList<RadioButton>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_add__edit__records, container, false);

        btnAdd = (Button) view.findViewById(R.id.button4);
        btnEdit = (Button) view.findViewById(R.id.button3);
        btnAdd.setOnClickListener(handler);
        btnEdit.setOnClickListener(handler);
        list = (LinearLayout) view.findViewById(R.id.linearLayout);
        List<Record> recordList = App_Database.getDatabase(getActivity()).recordDao().recordDescDate();
        for(Record record : recordList)
        {
            TextView textView = new TextView(getActivity());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            textView.setText(sdf.format(record.date) + " " + record.foodItem);
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setId(record.rid);
            radioButtons.add(radioButton);
            radioButton.setOnClickListener(radioHandler);
            list.addView(textView);
            list.addView(radioButton);
        }


        return view;
    }

    View.OnClickListener radioHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            for (RadioButton button : radioButtons)
            {
                if(button.getId() != view.getId())
                {
                    button.setChecked(false);
                } else if (button.getId() == view.getId())
                {

                    button.setChecked(true);
                }
            }
        }
    };

    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == btnAdd) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frameLayout, Add_Record_Data.newInstance("", "")).commit();
            } else if (view == btnEdit) {
                int id = 1;
                for(RadioButton button : radioButtons)
                {
                    if(button.isChecked())
                    {
                        id = button.getId();

                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, Edit_Record_Data.newInstance(id)).commit();
                    }
                }
            }

        }
    };


        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Add_Edit_Records.
         */
        // TODO: Rename and change types and number of parameters
        public static Add_Edit_Records newInstance(String param1, String param2) {
            Add_Edit_Records fragment = new Add_Edit_Records();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }
    }





