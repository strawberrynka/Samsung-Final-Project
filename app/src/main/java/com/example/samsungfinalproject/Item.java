package com.example.samsungfinalproject;

public class Item {
    public static final int TYPE_BOWL = 1;
    public static final int TYPE_DECOR = 2;
    public static final int TYPE_LITTER_BOX = 3;
    public static final int TYPE_WATER_BOWL = 4;

    private String name;
    private int price;
    private int image;
    private int type;

    public Item(String name, int price, int image, int type) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
