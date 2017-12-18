package com.example.narasimman.volley;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;



import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
/*
new commit
 */
String url="https://dinesh1234.000webhostapp.com/image.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cache cache=new DiskBasedCache(getCacheDir(),1024*1024);
        Network network=new BasicNetwork(new HurlStack());

        /*
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                TextView textView=findViewById(R.id.textview);
                try {
                    JSONArray jsonArray=response.getJSONArray("employee");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String name=jsonObject.getString("ename");
                        Log.e("dinesh",name);
                        String id=jsonObject.getString("empid");
                        Log.e("dinesh",id);
                        String dept=jsonObject.getString("dept");
                        Log.e("dinesh",dept);
                        Log.e("dinesh","-------------------------");
                        textView.append("Employee Name = "+String.valueOf(name)+" \n"+
                                        "Employee id = "+String.valueOf(id)+" \n"+
                                        "Department = "+String.valueOf(dept)+" \n"+
                                        "--------------------------------------\n"
                                        );
                    }
                } catch (JSONException e) {
                    Log.d("dinesh",e.toString());
                    e.printStackTrace();

                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

             1st patameter-request type(Get or post)
            2nd parameter-url
            3rd paramter-json object request
            4th parameter-listener for the response
            5th parameter-error listner
         */

       /* StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {

                TextView textView=findViewById(R.id.textview);
                textView.setText(response);
            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }
                });
            1st patameter-request type(Get or post)
            2nd parameter-url
            3rd parameter-listener for the response
            4th parameter-error listner

                */
        ImageRequest imageRequest=new ImageRequest(url, new Response.Listener<Bitmap>()
        {

            @Override
            public void onResponse(Bitmap response) {
                ImageView imageView=findViewById(R.id.imageView);
                imageView.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError  error) {

            }
        });

         /*
            1st parameter-url of the image
            2nd parameter-listener for the response
            3rd and 4th parameter-maximum  width and height of the image.if we are mentioning as zero then it will image will be appeared in with
                                    its own size
            5th parmater-scaletype of the image
            6th-error listner
             */
         /*
         merging the branches
          */
        MyApplication.getmInstance(getApplicationContext()).addRequest(imageRequest);
    }}