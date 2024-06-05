package com.example.myapplication;

public class Item {

    String name;
    String des;
    int image;

    public Item(String name, String des, int image) {
        this.name = name;
        this.des = des;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdes() {
        return des;
    }

    public void setEmail(String des) {
        this.des = des;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}