package com.test.andriodannotations;

//@Parcel

import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("name")
    public String name;

    @SerializedName("lastName")
    public String lastName;


//    @ParcelFactory
//    public static Contact create(String name, String lastName, boolean favorite) {
//        return new Contact(name, lastName, favorite);
//    }
//
//    public Contact(String name, String lastName, boolean favorite) {
//        this.name = name;
//        this.lastName = lastName;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    @Override
//    public String toString() {
//        return "Contact{" +
//                ", name='" + name + '\'' +
//                ", lastName='" + lastName + '\'' +
//                '}';
//    }
}
