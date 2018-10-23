package com.stepwisedesigns.knax.googlebooksV2;

public class Book {

    private String mBookTitle;
    private String mAuthor;
    private String mType;
    private String mSubtitle;
    private String mID;
    private String mPublisher;
    private String mCategory;
    private double mRating;

    public Book() {
    }

    public Book(String bookTitle, String author, String publisher, String ID, String subtitle, String category, double rating, String type, String Id) {

        mBookTitle = bookTitle;
        mAuthor = author;
        mType = type;
        mID = ID;
        mPublisher = publisher;
        mCategory = category;
        mSubtitle = subtitle;
        mRating = rating;
    }

    public String getmBookTitle() {
        return mBookTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmType() {
        return mType;
    }

    public String getmSubtitle() {
        return mSubtitle;
    }

    public String getmID() {
        return mID;
    }

    public String getmPublisher() { return mPublisher; }

    public String getmCategory() {
        return mCategory;
    }

    public double getmRating() {
        return mRating;
    }
}
