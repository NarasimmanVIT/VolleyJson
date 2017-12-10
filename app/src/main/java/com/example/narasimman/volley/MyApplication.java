package com.example.narasimman.volley;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Narasimman on 10-12-2017.
 */

public class MyApplication extends Application{
    private static MyApplication mInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private MyApplication(Context context)
    {
        this.context=context;
        requestQueue=getRequestQueue();
    }
    public static synchronized MyApplication getmInstance(Context context){
        if(mInstance==null)
        {
            mInstance= new MyApplication(context);
        }
        return mInstance;
    }
    private  RequestQueue getRequestQueue()
    {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addRequest(Request<T> request){
        requestQueue.add(request);
    }
}
