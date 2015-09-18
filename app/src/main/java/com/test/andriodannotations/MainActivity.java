package com.test.andriodannotations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity{

    ArrayList<Contact> personasWS;
    MyAdapter myAdapter;

    @ViewById(R.id.personas_lv)
    ListView personas_lv;

    @RestService
    RestClient restClient;

    @AfterViews
    public void init(){
        personasWS = new ArrayList<>();
        getPersonasBackground();
    }

    @Background
    public void getPersonasBackground(){
        personasWS = restClient.contactos();
//        var = restClient.var();
        mostrarResultado();
    }

    @UiThread
    public void mostrarResultado(){
//        Toast.makeText(this, personasWS.get(1).toString(), Toast.LENGTH_LONG).show();
//        Toast.makeText(this, var.length(), Toast.LENGTH_LONG).show();
        String var ="\n";
        if(personasWS!=null){
            myAdapter = new MyAdapter(this, android.R.layout.simple_list_item_1,personasWS);
            personas_lv.setAdapter(myAdapter);
//            for(Contact contact: personasWS){
//                var = var+contact.name+"\n";
//
//            }
//            Toast.makeText(this, var, Toast.LENGTH_LONG).show();
        }
    }

    //@Rest(rootUrl = "https://person-service.herokuapp.com/",converters = GsonHttp)



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

        if (id == R.id.action_newperson) {
            startActivity(new Intent(this, AddPersonActivity_.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
