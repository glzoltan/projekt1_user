package com.example.projekt1_user;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projekt1_user.R;

import java.util.ArrayList;

public class FragmentGrid extends Fragment {
    private RecyclerView recyclerView;
    private com.example.projekt1_user.GridAdapter gridAdapter;
    private ArrayList<String> gridDataList = new ArrayList<>();

    private Context context;

    @Override
    public void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        context = getActivity();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid,container,false);

        //db and active user

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String name = sharedPref.getString(getString(R.string.active_user),"Active user");
        //Toast.makeText(context, name, Toast.LENGTH_SHORT).show();

        //set task
        TextView tv_task = (TextView) v.findViewById(R.id.tv_task);

        if(0 == 0)
        {
            String text = "No new tasks";
            tv_task.setText(text);
            //return v;
        }
        //we need only the first one
        //res.moveToNext();
        //String task = res.getString(0);
        //tv_task.setText(task);

        //initialise recyclerview
        recyclerView = v.findViewById(R.id.recyclerView_grid);
        gridAdapter = new com.example.projekt1_user.GridAdapter(gridDataList, context);
        RecyclerView.LayoutManager manager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(gridAdapter);
        GridDataPrepare();
        return v;
    }

    private void GridDataPrepare() {
        gridDataList.add("\u2615");
        gridDataList.add("1");
        gridDataList.add("2");
        gridDataList.add("3");
        gridDataList.add("5");
        gridDataList.add("8");
        gridDataList.add("13");
        gridDataList.add("20");
        gridDataList.add("?");
    }

}
