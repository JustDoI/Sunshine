package com.rxy.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String obj = "{\"city\":\"bj\",\"code\":\"123\"}";
        get(obj);
    }

    private void get(String obj) {
        JSONObject json = JsonUtils.getJsonObject(obj);
        String result = null;
        try {
            result = json.getString("res");
        } catch (JSONException e) {
            e.printStackTrace();
        }
            setMsg(result);
    }

    private void setMsg(String result) {
        if (result == null) {
            ((TextView) findViewById(R.id.tv)).setText("true");
        } else {
            ((TextView) findViewById(R.id.tv)).setText("false");
        }

    }
}
