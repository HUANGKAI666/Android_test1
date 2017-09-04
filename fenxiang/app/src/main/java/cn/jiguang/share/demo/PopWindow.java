package cn.jiguang.share.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.jiguang.share.android.api.JShareInterface;
import cn.jiguang.share.android.api.PlatActionListener;
import cn.jiguang.share.android.api.Platform;
import cn.jiguang.share.android.api.ShareParams;


import android.R.drawable;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import static cn.jiguang.b.a.i;


@SuppressLint("CommitPrefEdits")
public class PopWindow {
    private GridView gridView;
    private List<Share> dataList;
    String[] name = {"微信好友", "微信朋友圈", "微信收藏", "qq好友", "qq空间", "新浪微博", "微博好友"};
    int[] image = {R.drawable.jiguang_socialize_wechat,
            R.drawable.jiguang_socialize_wxcircle,
            R.drawable.jiguang_socialize_wxfavorite,
            R.drawable.jiguang_socialize_qq,
            R.drawable.jiguang_socialize_qzone,
            R.drawable.jiguang_socialize_sina,
            R.drawable.jiguang_socialize_sina};
    public static String share_url = "https://www.baidu.cn";
    public static String share_text = "祝福的事就交给的小哥我了！";
    public static String share_title = " 祝福小哥";
    public static String share_imageurl = "http://img2.3lian.com/2014/f5/63/d/23.jpg";

    public static ProgressDialog progressDialog;

    private  PopupWindow popupWindow;
    private Context context;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String toastMsg = (String) msg.obj;
            Toast.makeText(context,toastMsg,Toast.LENGTH_SHORT).show();
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    };
    private PlatActionListener mPlatActionListener = new PlatActionListener() {
        @Override
        public void onComplete(Platform platform, int action, HashMap<String, Object> data) {
            if (handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享成功";
                handler.sendMessage(message);
            }
        }

        @Override
        public void onError(Platform platform, int action, int errorCode, Throwable error) {
            if (handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享失败:" + error.getMessage();
                handler.sendMessage(message);
            }
        }

        @Override
        public void onCancel(Platform platform, int action) {
            if (handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享取消";
                handler.sendMessage(message);
            }
        }
    };


    public PopWindow(final Context context) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.activity_select, null);

        popupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        //设置popwindow的动画效果
        popupWindow.setAnimationStyle(R.style.popWindow_anim_style);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        gridView = (GridView) view.findViewById(R.id.gridView1);
        dataList = new ArrayList<>();
        List<String> platformList = JShareInterface.getPlatformList();
        if (platformList == null || platformList.isEmpty()) {
            Toast.makeText(context, "请检查是否已经正确集成了JShare或者调用了JShareInterface.init", Toast.LENGTH_SHORT).show();
            //  finish();
            return;
        }
        int i = 0;
        for (String platform : platformList) {

            Share f = new Share();
            f.setName(platform);
            f.setImageId(image[i]);
            dataList.add(f);
            i++;

        }
//		for (int i = 0;i<platformList.size();i++){
//			Share f = new Share();
//	                  f.setName(name[i]);
//	                  f.setImageId(image[i]);
//	                  dataList.add(f);
//		}
        gridView.setAdapter(new ShareAdapter(context, dataList));


        gridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                final String platform = dataList.get(position).getName();
                ShareParams shareParams = new ShareParams();
                progressDialog = new ProgressDialog(context);
                progressDialog.setTitle("请稍候...");


                shareParams.setTitle(share_title);
                shareParams.setText(share_text);
                shareParams.setShareType(Platform.SHARE_WEBPAGE);
                shareParams.setUrl(share_url);
                shareParams.setImageUrl(share_imageurl);

                JShareInterface.share(platform, shareParams, mPlatActionListener);


            }
        });
    }


    /**
     * 弹窗显示的位置
     */
    public void showAsDropDown(View parent) {
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
    }

    /**
     * 消除弹窗
     */
    public void dissmiss() {
        popupWindow.dismiss();
    }
    // 当popWindow消失时响应

    public void onDismiss() {

    }



}
  






	

