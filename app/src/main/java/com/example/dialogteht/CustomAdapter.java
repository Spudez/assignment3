package com.example.dialogteht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;

    @Override
    public int getPosition(@Nullable String item) {
        return super.getPosition(item);
    }

    ArrayList<String> dataset;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.dataset = (ArrayList<String>)objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = View.inflate(context, R.layout.customlayout, null);
        TextView datetxt = (TextView) convertView.findViewById(R.id.datetext);
        datetxt.setText(dataset.get(position));
        Button bt = v.findViewById(R.id.delete);

        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                int positionToRemove = (int)v.getTag();
                removeItem(positionToRemove);
                notifyDataSetChanged();
            }
        });


        return v;
    }

    public void removeItem(int position){

        dataset.remove(position);
        notifyDataSetChanged();

    }

}
