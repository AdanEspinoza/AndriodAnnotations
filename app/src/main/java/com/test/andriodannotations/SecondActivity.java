package com.test.andriodannotations;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_second)
public class SecondActivity extends AppCompatActivity {

    public static final String SEND_DATA_EXTRA = "send_data_extra";

    @ViewById(R.id.name_tv)
    TextView name_tv;

    @ViewById(R.id.lastName_tv)
    TextView lastName_tv;

    @ViewById(R.id.favorite_tv)
    TextView favorite_tv;

    @Extra(SEND_DATA_EXTRA)
    ContactParcelable contactParcelable;

    @AfterViews
    public void init() {
//        Contact contact = Parcels.unwrap(getIntent().getParcelableExtra(SEND_DATA_EXTRA));
        name_tv.setText(contactParcelable.getName());
        lastName_tv.setText(contactParcelable.getLastName());
        String favorite;
        if(contactParcelable.isFavorite()){
            favorite = getResources().getString(R.string.favorite_yes);
        }else{
            favorite = getResources().getString(R.string.favorite_no);
        }
        favorite_tv.setText(favorite);
//            lastName_tv.setText(contact.getLastName());
//            if (contact.isFavorite()) favorite_tv.setText("Favorite: Yes");
//            else favorite_tv.setText("Favorite: No");

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Contact contact = Parcels.unwrap(getIntent().getParcelableExtra(SEND_DATA_EXTRA));
//        name_tv.setText(contact.getName());
//        lastName_tv.setText(contact.getLastName());
//        if(contact.isFavorite()) favorite_tv.setText("Favorite: Yes");
//        else favorite_tv.setText("Favorite: No");
//    }

    public static Intent buildIntent(Context context, Contact contactParcel) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(SEND_DATA_EXTRA, new Contact$$Parcelable(contactParcel));
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
