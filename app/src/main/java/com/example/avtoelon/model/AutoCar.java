package com.example.avtoelon.model;

import java.io.Serializable;
import java.util.List;

public class AutoCar implements Serializable {
    private int id;
    private String name;
    private String company;
    private String position;
    private String year;
    private String region;
    private String odometer;
    private String color;
    private double price;
    private String publishedDate;
    private int show_count;
    private List<String> imageList;
    private boolean isLike;

    public AutoCar(int id, String name, String company,
                   String position, String year, String region,
                   String odometer, String color, double price,
                   String publishedDate, int show_count,
                   List<String> imageList) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.position = position;
        this.year = year;
        this.region = region;
        this.odometer = odometer;
        this.color = color;
        this.price = price;
        this.publishedDate = publishedDate;
        this.show_count = show_count;
        this.imageList = imageList;
        this.isLike = false;
    }

    @Override
    public String toString() {
        return "AutoCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", year='" + year + '\'' +
                ", region='" + region + '\'' +
                ", odometer='" + odometer + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", publishedDate='" + publishedDate + '\'' +
                ", show_count=" + show_count +
                ", imageList=" + imageList +
                ", isLike=" + isLike +
                '}';
    }

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getShow_count() {
        return show_count;
    }

    public void setShow_count(int show_count) {
        this.show_count = show_count;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
