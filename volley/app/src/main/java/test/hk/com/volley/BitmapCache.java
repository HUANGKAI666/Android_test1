package test.hk.com.volley;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;



public class BitmapCache implements ImageLoader.ImageCache{

    LruCache<String,Bitmap> lruCache = new LruCache<String,Bitmap>(1024*1024*10){
        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getByteCount();
        }
    };



    @Override
    public Bitmap getBitmap(String s) {
        return lruCache.get(s);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {

        lruCache.put(s,bitmap);

    }
}
