package test.hk.com.imagelodervolley.http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;

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

import test.hk.com.imagelodervolley.MainActivity;
import test.hk.com.imagelodervolley.been.NewData;


/**
 * Created by 1 on 2017/7/13.
 */

public class Requstes {


    public void getJson(String url, final Context context, final Handler mHandler){
        final List<NewData> listdata = new ArrayList<NewData>();

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject jsonObject) {
//                Toast.makeText(context ,jsonObject.toString(),Toast.LENGTH_LONG).show();
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

    public List<NewData> getJsonData(String jsonString,List<NewData> listdata,Handler mHandler) throws JSONException {


        NewData newData;
        JSONObject jo = new JSONObject(jsonString);
        JSONArray ja = jo.getJSONArray("data");
        for (int i=0;i<ja.length();i++){
            jo = ja.getJSONObject(i);
            newData = new NewData();
            newData.setIconurl(jo.getString("picSmall"));
            newData.setConten(jo.getString("description")) ;
            newData.setTitle(jo.getString("name"));
            listdata.add(newData);
            //因为现在在线程里面所以要handle到主activity才能改变界面

            Message message = Message.obtain();
               message.obj = listdata;
               mHandler.sendMessage(message);

//            Log.d("kk",newData.getConten());

        }
        return listdata;
    }



}
