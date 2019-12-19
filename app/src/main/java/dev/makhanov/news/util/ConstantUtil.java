package dev.makhanov.news.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ConstantUtil {
    private static final String APP_PREF = "abchess";
    public static final String TAG = "MAKHAN";
    public static final String PREF_SHOW_INRO = "show_intro_page";
    public static final String PREF_TOKEN = "token";
    public static final String PREF_USER_ID = "userid";
    public static final String ARGS_FORM_URL = "url";
    public static ProgressDialog dialog;
    public static final int RC_SIGN_IN = 252;

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE);
    }

    public static void showDialog(Context context) {
        dialog = new ProgressDialog(context);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("Загрузка");
        dialog.show();
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideDialog() {
        if (dialog != null)
            dialog.dismiss();
    }


    public static String getToken(Context context) {
        SharedPreferences sharedPreferences = ConstantUtil.getSharedPreferences(context);
        String token = sharedPreferences.getString(PREF_TOKEN, null);
        return token;
    }

    public static String getEmail(Context context) {
        SharedPreferences sharedPreferences = ConstantUtil.getSharedPreferences(context);
        return sharedPreferences.getString(PREF_USER_ID, null);
    }



    public static byte[] strToByteArr(String str) {
        int nBytes = str.length() / 2;
        byte[] ret = new byte[nBytes];
        for (int i = 0; i < nBytes; i++) {
            int c1 = str.charAt(i * 2) - 'A';
            int c2 = str.charAt(i * 2 + 1) - 'A';
            ret[i] = (byte) (c1 * 16 + c2);
        }
        return ret;
    }

    public static String byteArrToString(byte[] data) {
        StringBuilder ret = new StringBuilder(32768);
        for (int datum : data) {
            int b = datum;
            if (b < 0)
                b += 256;
            char c1 = (char) ('A' + (b / 16));
            char c2 = (char) ('A' + (b & 15));
            ret.append(c1);
            ret.append(c2);
        }
        return ret.toString();
    }

    public static Typeface getTypeface(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/gothic.ttf");
    }

    public static Typeface getBoldTypeface(Context context) {
        return Typeface.create(Typeface.createFromAsset(context.getAssets(), "fonts/gothic.ttf"), Typeface.BOLD);
    }

    public static int dpToPx(int a, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, a, context.getResources().getDisplayMetrics());
    }


}