package com.qf.utils;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 15-11-18.
 */
public class ShareUtils {
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public  static void init_sharedpreferences(Context context){
           preferences=context.getSharedPreferences("info",context.MODE_PRIVATE);
           editor=preferences.edit();
    }
    public static void putString(String key,String vaule){
            if (key!=null&&vaule!=null){
                editor.putString(key,vaule);
                editor.commit();
            }
    }
    public  static  String getString(String key){
        return preferences.getString(key,null);
    }
    public static  void  putInt(String key,int vaule){
            if (key!=null){
                editor.putInt(key,vaule);
                editor.commit();
            }
    }
    public  static int getInt(String key){
        return preferences.getInt(key,-1);
    }
}
