package com.test.andriodannotations;

import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity{

    public static final String SEND_DATA_EXTRA = "send_data_extra";
    ContactParcelable contact;
    String name, lastName;
    boolean favoriteSelection = false;

    @ViewById(R.id.name_et)
    EditText name_et;

    @ViewById(R.id.lastName_et)
    EditText lastName_et;

    @ViewById(R.id.favorite_iv)
    ImageView favorite_iv;

    @Extra(SEND_DATA_EXTRA)
    String info;
    //Contact contact;


    @Click(R.id.favorite_iv)
    void favoriteClicked(){
        if(!favoriteSelection) {
            favoriteSelection = true;
            favorite_iv.setImageResource(R.mipmap.favon);
        }else if(favoriteSelection){
            favoriteSelection = false;
            favorite_iv.setImageResource(R.mipmap.favoff);
        }
    }

    @Click(R.id.btnSend)
    void btnClicked(){
        name = name_et.getText().toString();
        lastName = lastName_et.getText().toString();
        if(name.length() >0 ){
            if(lastName.length()>0){
                contact = new ContactParcelable(Parcel.obtain());
                contact.setFavorite(favoriteSelection);
                contact.setLastName(lastName);
                contact.setName(name);
                //info = contact.toString();
                //Intent myIntent = SecondActivity_.buildIntent(this, contact);
                //startActivity(myIntent);
              SecondActivity_.intent(this).extra(SEND_DATA_EXTRA,contact).start();
            }else{
                Toast.makeText(this,"Last Name is mandatory",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this,"Name is mandatory",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
