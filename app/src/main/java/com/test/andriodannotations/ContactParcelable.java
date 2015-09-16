package com.test.andriodannotations;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactParcelable implements Parcelable {
    private String name;
    private String lastName;
    private boolean favorite;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    protected ContactParcelable(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        favorite = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeByte((byte) (favorite ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ContactParcelable> CREATOR = new Parcelable.Creator<ContactParcelable>() {
        @Override
        public ContactParcelable createFromParcel(Parcel in) {
            return new ContactParcelable(in);
        }

        @Override
        public ContactParcelable[] newArray(int size) {
            return new ContactParcelable[size];
        }
    };
}