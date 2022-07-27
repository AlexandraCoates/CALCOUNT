package com.example.calcount3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class RecordViewHolder extends RecyclerView.ViewHolder {
    private final TextView recordItemView;

    private RecordViewHolder(View itemView){
        super(itemView);
        recordItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text){
        recordItemView.setText(text);
    }

    static RecordViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new RecordViewHolder(view);
    }
}

// Call this: - might not have too, I have no idea:
// RecyclerView recyclerView = findViewById(R.id.recyclerview);
// final Record_List_Adapter adapter = new Record_List_Adapter(new Record_List_Adapter.RecordDiff());
// recyclerView.setAdapter(adapter);
// recyclerView.setLayoutManager(new LinearLayoutManager(this));
