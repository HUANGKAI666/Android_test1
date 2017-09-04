package test.hk.com.KkDriving.http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import test.hk.com.KkDriving.been.TestData;


/**
 * Created by 1 on 2017/7/13.
 */

public class Requstes {


    public void getJson(String url, final Context context, final Handler mHandler){
        final List<TestData> listdata = new ArrayList<TestData>();

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject jsonObject) {
//                Toast.makeText(context ,jsonObject.toString(),Toast.LENGTH_LONG).show();
                Log.d("xxx",jsonObject.toString());
                try {
                    getJsonData(jsonObject.toString(),listdata,mHandler);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }

        );
        requestQueue.add(jsonObjectRequest);

    }

    public List<TestData> getJsonData(String jsonString, List<TestData> listdata, Handler mHandler) throws JSONException {

// "id": 12,
//        "question": "这个标志是何含义？",//问题
//        "answer": "4",//答案
//        "item1": "前方40米减速",//选项，当内容为空时表示判断题正确选项
//        "item2": "最低时速40公里",//选项，当内容为空时表示判断题错误选项
//        "item3": "限制40吨轴重",
//        "item4": "限制最高时速40公里",
//        "explains": "限制最高时速40公里：表示该标志至前方限制速度标志的路段内，机动车行驶速度不得超过标志所示数值。此标志设在需要限制车辆速度的路段的起点。以图为例：限制行驶时速不得超过40公里。",//答案解释

        TestData newData;
        JSONObject jo = new JSONObject(jsonString);
        JSONArray ja = jo.getJSONArray("result");
        for (int i=0;i<ja.length();i++){
            jo = ja.getJSONObject(i);
            newData = new TestData();
            newData.setId(jo.getInt("id"));
            newData.setQuestion(jo.getString("question")); ;
            newData.setAnswer(jo.getInt("answer"));
            newData.setItem1(jo.getString("item1"));
            newData.setItem2(jo.getString("item2"));
            if (jo.getString("item3")!=null){
                newData.setItem3(jo.getString("item3"));
                newData.setItem4(jo.getString("item4"));
            }
            newData.setExplains(jo.getString("explains"));
            if (jo.getString("url")!=null){
                newData.setImgurl(jo.getString("url"));
            }

            listdata.add(newData);
            //因为现在在线程里面所以要handle到主activity才能改变界面
//            Log.d("xxxx",newData.getId()+"");

        }
        Message message = Message.obtain();
        message.obj = listdata;
        mHandler.sendMessage(message);
        return listdata;
    }



}
