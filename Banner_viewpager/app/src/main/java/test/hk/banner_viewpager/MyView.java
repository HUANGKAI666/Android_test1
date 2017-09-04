package test.hk.banner_viewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
public class MyView extends RelativeLayout {
    private String mytext;
    private int mytextcolor;
    private Drawable mybackground;
    private float mytextsize;
    private LayoutParams Params;
    private Button bt;
    private myOnClickListener listener;
    public  interface myOnClickListener{
        public void  myClick();
    }

    public void  setmyOnClickListener(myOnClickListener listener){
    this.listener = listener;

    }


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.myView);
        mytext = typedArray.getString(R.styleable.myView_mytext);
        mytextcolor = typedArray.getColor(R.styleable.myView_mytextcolor,0);
        mybackground = typedArray.getDrawable(R.styleable.myView_mybackground);
        mytextsize = typedArray.getDimension(R.styleable.myView_mytextsize, 0);
        typedArray.recycle();

         bt =new Button(context);
        bt.setText(mytext);
        bt.setBackground(mybackground);
        bt.setTextColor(mytextcolor);
        bt.setTextSize(mytextsize);
        Params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        Params.addRule(CENTER_IN_PARENT);
        bt.setLayoutParams(Params);
        addView(bt);



        bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.myClick();
            }
        });


    }

}
