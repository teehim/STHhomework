package com.teehim.stylhunthw;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.teehim.stylhunthw.R;
import com.teehim.stylhunthw.com.teehim.stylhunthw.model.SessionManager;

public class StatActivity extends AppCompatActivity {

    TextView save,nope,swipe;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        session = new SessionManager(getApplication());

        save = (TextView) findViewById(R.id.save);
        nope = (TextView) findViewById(R.id.nope);
        swipe = (TextView) findViewById(R.id.swipe);

        save.setText(session.getSave()+"");
        nope.setText(session.getNope()+"");
        swipe.setText(session.getSave()+session.getNope()+"");

    }

}
