package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Record {
    @Id
    private int id;
    private String name;
    private String description;
    private int cost;
    private int totalStock;
    private int owned;

    // Default constructor
    public Record() {}

    // Getter and setter methods for the new fields

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }

    public void buySome(int howMuch) {
        int maxTotal = Math.min(this.totalStock, howMuch);
        int minTotal = Math.max(0, maxTotal);
        int difference = minTotal - this.owned;
        System.out.println(difference);
        int minimum = 10;
        if(this.cost + difference * this.cost/this.totalStock > minimum) {
            this.cost += difference * this.cost / this.totalStock;
        }
        else {
            minimum = Math.max(minimum, this.cost / 2);
            this.cost = minimum;
        }
        this.owned += difference;
    }

    // Getter and setter methods for the existing fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}