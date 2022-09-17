package com.walterkstro.models;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {
    public static String formating(float currency){
        Locale localCurrency = new Locale("es","GT");
        NumberFormat formatCurrency = NumberFormat.getCurrencyInstance( localCurrency );
        return formatCurrency.format(currency);
    }
}
