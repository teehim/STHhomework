package com.teehim.stylhunthw.com.teehim.stylhunthw.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teehim.stylhunthw.CardSwipeActivity;
import com.teehim.stylhunthw.MainActivity;
import com.teehim.stylhunthw.R;

import java.util.List;

/**
 * Created by Thanatkorn on 1/18/2016.
 */
public class CardAdapter extends BaseAdapter {
    public List<Card> cardList;
    public Context context;

    public CardAdapter(List<Card> list, Context context) {
        this.cardList = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cardList.size();
    }

    @Override
    public Card getItem(int position) {
        return cardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;


        if (v == null) {

            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.card, parent, false);
        }

        Card card = cardList.get(position);

        if(card != null){

            ImageView img = (ImageView) v.findViewById(R.id.thumb);
            TextView desc = (TextView) v.findViewById(R.id.desc);


            Picasso.with(context).load(card.getImg()).into(img);
            desc.setText(card.getDesc());
        }

        return v;
    }

}
