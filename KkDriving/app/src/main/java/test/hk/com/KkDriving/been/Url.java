package test.hk.com.KkDriving.been;

import android.content.Context;
import android.util.Log;

import test.hk.com.KkDriving.tool.SharedPreferencesUtil;

/**
 * Created by 1 on 2017/7/31.
 */

public class Url {
    public static final String MODEL="model",SUBJECT="subject",TESTTYPE ="testType";
    private   String model,testType;
    private  int subject;
    private Context context;
    public String url = null;

    public Url(Context context){
        this.context = context;
            model = SharedPreferencesUtil.getString(context,MODEL,"");
            subject = SharedPreferencesUtil.getInt(context,SUBJECT,0);
            testType = SharedPreferencesUtil.getString(context,TESTTYPE,"");
         String url = "http://v.juhe.cn/jztk/query?subject=" + subject + "&model=" + model +
                "&key=6295bddf596b3fbee4a774372ad8e571&testType=" +testType;
        this.url = url;
        Log.d("xxx",model+subject+testType);
                Log.d("xxx",url);
                }


                }
