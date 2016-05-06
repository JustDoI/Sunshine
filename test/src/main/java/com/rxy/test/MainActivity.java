package com.rxy.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private int mTouchSlop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String temp = "{\"city\":\"bj\",\"code\":\"123\"}";
        String obj = "{\"city\":\"bj\",\"code\":\"123\",\"data\":[]}";
        String msg = "{\"city\":\"bj\",\"code\":\"123\",\"data\":[{\"fd\":\"12\"}]}";
        Log.e("mylog", "msg=" + msg);
        get(obj);
        mTouchSlop = ViewConfiguration.get(getApplicationContext()).getScaledTouchSlop();
        Log.i("mylog", "mTouchSlop=" + mTouchSlop);
        final Button bt = (Button) findViewById(R.id.bt);
        bt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("mylog", "ACTION_DOWN");
                        float x = bt.getX();
                        float y = bt.getY();
                        Log.e("mylog", "x=" + x + ">>>>y=" + y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("mylog", "ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("mylog", "ACTION_UP");
                        break;
                }
                return false;
            }
        });
    }

    private void get(String obj) {
        JSONObject json = JsonUtils.getJsonObject(obj);
        JSONArray ar;
        String result = null;
        try {
            result=json.getString("data");
//            ar = json.getJSONArray("data");
//            JSONObject temp = ar.getJSONObject(0);
//            result = temp.toString();
            setMsg(result);
        } catch (JSONException e) {
            Log.e("mylog","e="+e);
            e.printStackTrace();
            setMsg(result+"异常");
        }
    }

    private void setMsg(String result) {
        if (result == null) {
            ((TextView) findViewById(R.id.tv)).setText("true");
        } else {
            if(result.equals("[]")){
                ((TextView) findViewById(R.id.tv)).setText("没有意义的值");
            }else{
                ((TextView) findViewById(R.id.tv)).setText(result);
            }
        }

    }
}
