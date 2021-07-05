package com.example.foodfini.Model;

public class HomeModel {

    int img;
    String itemname;
    String s;






    public HomeModel(int img, String itemname, String s) {
        this.img = img;
        this.itemname = itemname;
        this.s = s;


    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
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
