package com.test.andriodannotations;

import org.parceler.Parcel;
import org.parceler.ParcelFactory;

@Parcel
public class Contact {

    private String name;
    private String lastName;
    private boolean favorite;



    @ParcelFactory
    public static Contact create(String name, String lastName, boolean favorite) {
        return new Contact(name, lastName, favorite);
    }

    public Contact(String name, String lastName, boolean favorite) {
        this.name = name;
        this.lastName = lastName;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "favorite=" + favorite +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
