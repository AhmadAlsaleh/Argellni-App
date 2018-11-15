package com.crazyiter.android.argellni;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Patterns;

import java.text.NumberFormat;
import java.util.Locale;

public class PrimaryMethods {

    public static boolean isEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isPhone(String phone) {
        return Patterns.PHONE.matcher(phone).matches();
    }

    public static String formatPrice(Integer price) {
        return NumberFormat.getNumberInstance(Locale.US).format(price);
    }

    public static boolean isConnected(Activity activity) {
        return ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo() != null;
    }


}
