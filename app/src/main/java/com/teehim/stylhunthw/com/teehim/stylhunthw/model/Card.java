package com.teehim.stylhunthw.com.teehim.stylhunthw.model;

/**
 * Created by Thanatkorn on 1/18/2016.
 */
public class Card {

    private String img;
    private String desc;

    public Card() {
    }

    public Card(String img, String desc) {
        this.img = img;
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
