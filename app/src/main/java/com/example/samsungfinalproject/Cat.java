package com.example.samsungfinalproject;

public class Cat {
    private int id;
    private String name;
    private String gender;
    private String breed;
    private int health;
    private int satiety;
    private int happiness;

    public Cat(int id, String name, String gender, String breed, int health, int satiety, int happiness) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.health = health;
        this.satiety = satiety;
        this.happiness = happiness;
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

    public String getBreed() {
        return breed;
    }

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
        health += 5;
        happiness += 5;
    }
}