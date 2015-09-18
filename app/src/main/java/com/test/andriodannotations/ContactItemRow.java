package com.test.andriodannotations;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.row)
public class ContactItemRow extends LinearLayout{

    @ViewById(R.id.textView_name)
    TextView textView_name;
    @ViewById(R.id.textView_lastName)
    TextView textView_lastName;

    public ContactItemRow(Context context) {
        super(context);
    }

    public void bindContact(Contact contact){
        textView_name.setText(contact.name);
        textView_lastName.setText(contact.lastName);
    }
}
