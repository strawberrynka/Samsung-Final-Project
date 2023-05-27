package com.example.samsungfinalproject;//package com.example.samsungfinalproject;

public class Cat {
    public int id;

    public String name;
    public String gender;
    private String imagePath;

    private int x;
    private int y;

    public int health;
    public int satiety;
    public int happiness;

    public Player player;

    public Cat(int id, String name, String gender, String imagePath) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        x = 180;
        y = 400;
        this.health = 100;
        this.satiety = 50;
        this.happiness = 50;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getImagePath() { return imagePath; }

    public int getHealth() {
        return health;
    }

    public int getSatiety() {
        return satiety;
    }

    public int getHappiness() {
        return happiness;
    }

    public void feed() {
        satiety += 10;
        happiness += 5;
    }

    public void pet() {
        happiness += 10;
    }

    public void play() {
        satiety -= 5;
        happiness += 15;
    }

    public void sell() {
        health = 0;
        satiety = 0;
        happiness = 0;
    }

    public void clean() {
        happiness += 5;
        player.addCoins(10);
    }

}
