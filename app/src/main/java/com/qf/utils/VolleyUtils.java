package com.qf.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
/**
 * Created by Administrator on 15-11-16.
 */
public class VolleyUtils {
    public static RequestQueue requestQueue;
    public static LruCache<String, Bitmap> lruCache;
    public static void initQueue(Context content) {
        requestQueue = Volley.newRequestQueue(content);

        //数据缓存
        lruCache = new LruCache<String, Bitmap>((int) (Runtime.getRuntime().maxMemory()/8)){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    /**
     * 图片数据下载
     * @param url
     * @param iv
     * @param resid
     * @param errorresid
     */
    public static void requestImage(String url, ImageView iv, int resid, int errorresid){
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return lruCache.get(url);
            }
            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                lruCache.put(url, bitmap);
            }
        });

        imageLoader.get(url, ImageLoader.getImageListener(iv, resid, errorresid));
    }


    /**
     *  volley的String数据下载
     */

    public static void My_Stringrequest(final String url, final Myresponse myresponse) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myresponse.myonresponse(url, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myresponse.myonerrorresponse(url, error);
            }
        });
        requestQueue.add(request);
    }

    public interface Myresponse {
        public void myonresponse(String url, String response);
        public void myonerrorresponse(String url, VolleyError error);
    }
}
