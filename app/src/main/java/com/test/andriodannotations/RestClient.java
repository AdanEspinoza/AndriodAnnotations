package com.test.andriodannotations;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.ArrayList;

@Rest(rootUrl = "https://person-service.herokuapp.com", converters = {GsonHttpMessageConverter.class})
public interface RestClient {

    @Get("/person")
    ArrayList<Contact> contactos();
//    String var();

}
