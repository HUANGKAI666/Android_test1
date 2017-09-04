package test.hk.com.volley;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button mSBt,mJBt,mIlBt,mIrBt,mNBt;
    ImageView mImg;
    NetworkImageView mNetWorkImage;
    RequestQueue requestQueue;
    TextView mT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSBt = (Button) findViewById(R.id.button1);
        mJBt = (Button) findViewById(R.id.button2);
        mIlBt = (Button) findViewById(R.id.button4);
        mIrBt = (Button) findViewById(R.id.button3);
        mNBt = (Button) findViewById(R.id.button5);
        mImg = (ImageView) findViewById(R.id.imageView);
        mNetWorkImage = (NetworkImageView) findViewById(R.id.imageView2);
        mT = (TextView) findViewById(R.id.textView);

        requestQueue =Volley.newRequestQueue(this);
        mSBt.setOnClickListener(this);
        mJBt.setOnClickListener(this);
        mIlBt.setOnClickListener(this);
        mIrBt.setOnClickListener(this);
        mNBt.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                stringRequest(requestQueue);
                break;
            case R.id.button2:
                jsonObjectRequest(requestQueue);

                break;
            case R.id.button3:
                imageRequest(requestQueue);

                break;
            case R.id.button4:
                imageLoader(requestQueue);

                break;
            case R.id.button5:
               networkImageView(requestQueue);

                break;

        }

    }


    //发送stringrequest请求
    private void stringRequest(RequestQueue requestQueue) {
        StringRequest stringRequest = new StringRequest("https://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
//                Toast.makeText(MainActivity.this, s,Toast.LENGTH_SHORT).show();
                mT.setText(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }

        );
        stringRequest.setTag("stringRequest");
        requestQueue.add(stringRequest);
    }
    //发送jsonobjectrequest请求
    private void jsonObjectRequest(RequestQueue requestQueue) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://www.imooc.com/api/teacher?type=4&num=30",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                mT.setText(jsonObject.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }
        );



        requestQueue.add(jsonObjectRequest);
    }

    //发送imagerequstes请求
    private void imageRequest(RequestQueue requestQueue) {
        ImageRequest ir = new ImageRequest("http://img.taopic.com/uploads/allimg/120820/214833-120R0222J553.jpg", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                mImg.setImageBitmap(bitmap);

            }
        }, 0, 0,Bitmap.Config.ALPHA_8, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }
        );

        requestQueue.add(ir);
    }

    //imageLoader加载图片
    private void imageLoader (RequestQueue requestQueue) {
        ImageLoader il = new ImageLoader(requestQueue,new BitmapCache());
        il.get("http://a3.att.hudong.com/84/15/14300000014299129095154086487.jpg",
                ImageLoader.getImageListener(mImg,R.mipmap.ic_launcher,R.mipmap.ic_launcher_round));


    }

    private void networkImageView(RequestQueue requestQueue) {
        NetworkImageView niv = new NetworkImageView(this);
        ImageLoader il = new ImageLoader(requestQueue,new BitmapCache());
        mNetWorkImage.setImageUrl("http://img.taopic.com/uploads/allimg/130523/" +
                "235090-1305230G35485.jpg",il);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (requestQueue!=null)
        requestQueue.cancelAll("stringRequest");

    }
}
