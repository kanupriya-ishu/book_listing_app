package com.example.booklisting;

public class Book {

    private String mImageUrl;

    private String mTitle;

    private String mAuthor;

    private double mPrice;

    private String mUrl;

    public Book(String imageUrl, String title, String author, double price, String url){
        mImageUrl = imageUrl;
        mTitle = title;
        mAuthor = author;
        mPrice = price;
        mUrl = url;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public double getPrice() {
        return mPrice;
    }

    public String getUrl() {
        return mUrl;
    }
}
