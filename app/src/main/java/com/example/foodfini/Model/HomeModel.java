package com.example.foodfini.Model;

public class HomeModel {

    int img;
    String itemname;

    public HomeModel(int img, String itemname) {
        this.img = img;
        this.itemname = itemname;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
}
