package com.example.projekt1_user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VoteActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference dbtask;
    public static final String SHARED_PREFS="sharedPrefs";
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
    public void change_frag(View view)
    {

        TextView tv_task = (TextView) findViewById(R.id.tv_task);
        String task = tv_task.getText().toString();

        //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String user = sharedPref.getString(getString(R.string.active_user),"Active User");
        String vote = sharedPref.getString(getString(R.string.user_vote),"");
        if( vote.equals(""))
        {
            Toast.makeText(this, "Did not select anything", Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, user + " - "  + task + " - "+ vote, Toast.LENGTH_SHORT).show();
            return;
        }
        dbtask = FirebaseDatabase.getInstance().getReference("vote");
        String id=dbtask.push().getKey();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        String name = sharedPreferences.getString("username","");
        String grp = sharedPreferences.getString("groupcode","");
        Fire_Vote Vote=new Fire_Vote(id,task,grp,name,vote);
        dbtask.child(id).setValue(Vote);


    }

}
