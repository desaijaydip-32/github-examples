package com.example.foodfini.Model;

public class MenuModel {

    int img , price ;
    String itemName;
    boolean cart;

    public MenuModel(int img, int price, String itemName, boolean cart) {
        this.img = img;
        this.price = price;
        this.itemName = itemName;
        this.cart = cart;
    }

    public boolean isCart() {
        return cart;
    }

    public void setCart(boolean cart) {
        this.cart = cart;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
