package com.app.nb.tabby.utils;

import android.content.Context;

import com.app.nb.tabby.R;
import com.app.nb.tabby.model.Country;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Country> getCountries(final Context context) {
        return new ArrayList<Country>() {{
            add(new Country(context.getString(R.string.country_spain), "ES"));
            add(new Country(context.getString(R.string.country_argentina), "AR"));
            add(new Country(context.getString(R.string.country_bolivia), "BO"));
            add(new Country(context.getString(R.string.country_chile), "CL"));
            add(new Country(context.getString(R.string.country_peru), "PE"));
            add(new Country(context.getString(R.string.country_colombia), "CO"));
            add(new Country(context.getString(R.string.country_ecuador), "EC"));
            add(new Country(context.getString(R.string.country_mexico), "MX"));
            add(new Country(context.getString(R.string.country_uruguay), "UY"));
            add(new Country(context.getString(R.string.country_venezuela), "VE"));
        }};
    }
}
