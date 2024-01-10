package com.example.avtoelon.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AutoModel implements Parcelable {
    private int id;
    private String name;
    private String year;
    private String region;
    private String odometer;
    private double price;
    private String publishedDate;
    private int show_count;
    private String imageList;
    private int isLike;

    public AutoModel(int id, String name, String year, String region, String odometer, double price, String publishedDate, int show_count, String imageList, int isLike) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.region = region;
        this.odometer = odometer;
        this.price = price;
        this.publishedDate = publishedDate;
        this.show_count = show_count;
        this.imageList = imageList;
        this.isLike = isLike;
    }

    protected AutoModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        year = in.readString();
        region = in.readString();
        odometer = in.readString();
        price = in.readDouble();
        publishedDate = in.readString();
        show_count = in.readInt();
        imageList = in.readString();
        isLike = in.readInt();
    }

    public static final Creator<AutoModel> CREATOR = new Creator<AutoModel>() {
        @Override
        public AutoModel createFromParcel(Parcel in) {
            return new AutoModel(in);
        }

        @Override
        public AutoModel[] newArray(int size) {
            return new AutoModel[size];
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

    public int isLike() {
        return isLike;
    }

    public void setLike(int like) {
        isLike = like;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(year);
        dest.writeString(region);
        dest.writeString(odometer);
        dest.writeDouble(price);
        dest.writeString(publishedDate);
        dest.writeInt(show_count);
        dest.writeString(imageList);
        dest.writeInt(isLike);
    }
}
