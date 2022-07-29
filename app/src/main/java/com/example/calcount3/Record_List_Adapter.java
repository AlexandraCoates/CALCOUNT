package com.example.calcount3;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import org.jetbrains.annotations.NotNull;

public class Record_List_Adapter extends ListAdapter<Record, RecordViewHolder> {

    public Record_List_Adapter(@NonNull DiffUtil.ItemCallback<Record> diffCallBack){
        super(diffCallBack);
    }

    @Override
    public RecordViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        return RecordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RecordViewHolder holder, int position){
        Record current = getItem(position);
        holder.bind(current.getRecord());
    }

    static class Record_Diff extends DiffUtil.ItemCallback<Record> {

        @Override
        public boolean areItemsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Record oldItem, @NonNull Record newItem) {
            return oldItem.getRecord().equals(newItem.getRecord());
        }
    }
}
