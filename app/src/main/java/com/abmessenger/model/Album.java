package com.abmessenger.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mimi on 3/7/2016.
 */
public class Album implements Parcelable {
    public static final String EXTRA_ALBUM = "extra_album";
    String url; // TODO - actual Album will have an image to be fetched from a url
    private String title;
    private String subTitle;

    public Album(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }


    protected Album(Parcel in) {
        url = in.readString();
        title = in.readString();
        subTitle = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(title);
        dest.writeString(subTitle);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };
}
