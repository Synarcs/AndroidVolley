package com.example.jsonplaceholder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Queue;

public class SecondScreen extends AppCompatActivity {
     private TextView tv;
     private Button bt;
     private RequestQueue rq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        tv =findViewById(R.id.Json_Response);
        bt = findViewById(R.id.getResponse);

        rq = Volley.newRequestQueue(this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }
    private void jsonParse(){
        String url = "https://api.myjson.com/bins/kp9wz";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("employees");

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject employee = jsonArray.getJSONObject(i);
                        String fname = employee.getString("firstname");
                        int age = employee.getInt("age");
                        String email = employee.getString("mail");
                        tv.append("firstName::"+fname+"age::"+String.valueOf(age)+"email::"+email+"\n \n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        rq.add(request);
    }
}
