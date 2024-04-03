package com.akbar08.drawer_fragment_application.adapter;
public class item_model {
    String textHeader, textDesc, imgUrl;


    public item_model(String textHeader, String textDesc, String imgUrl) {
        this.textHeader = textHeader;
        this.textDesc = textDesc;
        this.imgUrl = imgUrl;
    }

    public String getTextHeader() {
        return textHeader;
    }

    public String getTextDesc() {
        return textDesc;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}