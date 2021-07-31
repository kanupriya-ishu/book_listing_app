package com.example.booklisting;

public class Book {

    private String mImageUrl;

    private String mTitle;

    private String mAuthor;

    private long mPages;

    private String mUrl;

    public Book(String imageUrl, String title, String author, long pages, String url){
        mImageUrl = imageUrl;
        mTitle = title;
        mAuthor = author;
        mPages = pages;
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

    public long getPages() {
        return mPages;
    }

    public String getUrl() {
        return mUrl;
    }
}
