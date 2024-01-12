package com.example.avtoelon.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "autocar")
public class AutoCar implements Parcelable {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
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
    private String imageList;
    private boolean isLike;

    public AutoCar() {
    }

    public AutoCar(int id, String name, String company, String position, String year, String region, String odometer, String color, double price, String publishedDate, int show_count, String imageList, boolean isLike) {
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
        this.isLike = isLike;
    }

    protected AutoCar(Parcel in) {
        id = in.readInt();
        name = in.readString();
        company = in.readString();
        position = in.readString();
        year = in.readString();
        region = in.readString();
        odometer = in.readString();
        color = in.readString();
        price = in.readDouble();
        publishedDate = in.readString();
        show_count = in.readInt();
        imageList = in.readString();
        isLike = in.readByte() != 0;
    }

    public static final Creator<AutoCar> CREATOR = new Creator<AutoCar>() {
        @Override
        public AutoCar createFromParcel(Parcel in) {
            return new AutoCar(in);
        }

        @Override
        public AutoCar[] newArray(int size) {
            return new AutoCar[size];
        }
    };

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

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(company);
        parcel.writeString(position);
        parcel.writeString(year);
        parcel.writeString(region);
        parcel.writeString(odometer);
        parcel.writeString(color);
        parcel.writeDouble(price);
        parcel.writeString(publishedDate);
        parcel.writeInt(show_count);
        parcel.writeString(imageList);
        parcel.writeByte((byte) (isLike ? 1 : 0));
    }
}
