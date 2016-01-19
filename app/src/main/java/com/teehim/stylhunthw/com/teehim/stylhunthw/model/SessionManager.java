package com.teehim.stylhunthw.com.teehim.stylhunthw.model;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Thanatkorn on 1/19/2016.
 */
public class SessionManager {

    SharedPreferences pref;

    SharedPreferences.Editor editor;


    Context _context;

    int PRIVATE_MODE = 0;


    private static final String PREF_NAME = "Stat";


    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createSession(){
        editor.putInt("saveCount", 0);
        editor.putInt("nopeCount", 0);
        editor.commit();
    }

    public void save(){
        int i = pref.getInt("saveCount",0)+1;
        editor.putInt("saveCount", i);
        editor.commit();
        System.out.println("save"+i);
    }

    public void nope(){
        int i = pref.getInt("nopeCount",0)+1;
        editor.putInt("nopeCount",i );
        editor.commit();
        System.out.println("nope"+i);
    }

    public int getSave(){
        return pref.getInt("saveCount",0);
    }

    public int getNope(){
        return pref.getInt("nopeCount",0);
    }

}
