package com.example.projekt1_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class VoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        FragmentTransaction frag_trans = getSupportFragmentManager().beginTransaction();
        frag_trans.add(R.id.fragment_container,new FragmentGrid());
        frag_trans.commit();
    }

    public void change_frag_back(View view)
    {
        FragmentTransaction frag_trans = getSupportFragmentManager().beginTransaction();
        frag_trans.replace(R.id.fragment_container,new FragmentGrid());
        frag_trans.commit();
    }
}
