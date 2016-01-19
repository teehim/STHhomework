package com.teehim.stylhunthw;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.teehim.stylhunthw.com.teehim.stylhunthw.model.Card;
import com.teehim.stylhunthw.com.teehim.stylhunthw.model.CardAdapter;
import com.teehim.stylhunthw.com.teehim.stylhunthw.model.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class CardSwipeActivity extends AppCompatActivity {

    private List<Card> stack;
    private SwipeFlingAdapterView flingContainer;
    private CardAdapter cardAdapter;
    SessionManager session;
    int swipeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_swipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        session = new SessionManager(getApplication());

       swipeCount = session.getNope()+session.getSave();


        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.stack);

        stack = new ArrayList<>();
        stack.add(new Card("http://rlv.zcache.com/richmond_blog_grocery_tote_no_url_grocery_tote_bag-rcb60b8dea76c42599a74aff783b46778_v9wb0_8byvr_324.jpg","Bag1"));
        stack.add(new Card("http://rlv.zcache.co.uk/sabily_logo_website_url_jumbo_tote_bag-r4cae0dd2cc2d426296ea728ff24702ba_v9isk_8byvr_630.jpg?view_padding=%5B285%2C0%2C285%2C0%5D","Bag2"));
        stack.add(new Card("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTWyabkg2ziWRvJBYabWD60O3WO7JhRtxvYypnjWH1gByFReDQl","Bag3"));
        stack.add(new Card("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSR4mn7u2wZRU-z1pmvXRbSWkcMoZadBVGPmWPNk7cr787pQIVIqQ","Bag4"));
        stack.add(new Card("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyWMdip-SQ0-70uTfA9zJMIMycB9eB2gFMkTwsHs_HO2pvm2_P","Bag5"));
        stack.add(new Card("https://res.cloudinary.com/keep/image/fetch/t_post_large,f_auto/https://s3.amazonaws.com/production-ol-images/a8f17656469d028c8261fec8f5e32391.jpg","Bag6"));
        stack.add(new Card("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcT6ml1Sp99qLf-9h_bguIHRmb26zO0OMulyFTI5VZvPRet5NB1u","Bag7"));
        stack.add(new Card("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTvlb1KhjxnnwpShZIZ3Imajh_pbn_GPOB6gDMU77c_F13jxgLz","Bag8"));

        if(swipeCount == 8){
            session.createSession();
        }else {
            for(int i=0;i<swipeCount;i++){
                stack.remove(0);
            }
        }

        cardAdapter = new CardAdapter(stack,this);
        flingContainer.setAdapter(cardAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                stack.remove(0);
                cardAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                session.nope();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                session.save();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                if(scrollProgressPercent < 0) {
                    view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);

                }else {
                    view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);

                }
            }
        });

    }

}


