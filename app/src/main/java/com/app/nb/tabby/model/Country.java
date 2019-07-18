package com.app.nb.tabby.model;

import java.text.MessageFormat;

public class Country {

    private String name;
    private String CountryCode;

    public Country(String name, String countryCode) {
        this.name = name;
        CountryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getFlagURL() {
        //Formateo y consumir api
        return MessageFormat.format("http://www.geognos.com/api/en/countries/flag/{0}.png", this.getCountryCode());
    }

    //Sobreescribimos el metodo  toString de nuestra clase POJO para que cuando
    //el Spinner llame internamente cada objeto , use el name para ser mostrado
    // como unico valor en la lista desplegable
    @Override
    public String toString() {
        return name;
    }
}
