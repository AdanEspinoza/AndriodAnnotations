package com.test.andriodannotations;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;

@EBean
public class MyAdapter extends ArrayAdapter<Contact>{

    ArrayList<Contact> contactsList;

    @RootContext
    Context context;

//    @Bean(ContactItemRow.class)
//    ContactItemRow

    public MyAdapter(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, contacts);
        this.contactsList = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactItemRow contactItemRow;
        if (convertView == null) {
            contactItemRow = ContactItemRow_.build(context);
        } else {
            contactItemRow = (ContactItemRow) convertView;
        }

        contactItemRow.bindContact(getItem(position));
        return contactItemRow;
    }
}
