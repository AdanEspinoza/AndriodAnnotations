package com.test.andriodannotations;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactParcelable implements Parcelable {
    private String name;
    private String lastName;

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
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
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