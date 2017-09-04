package test.hk.com.rxrf_test;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv);

        Retrofit rf = new Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn/adat/sk/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiStores apiStores = rf.create(ApiStores.class);
        Observable<WeatherJson> observable = apiStores.getWeather("101010100");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherJson>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WeatherJson weatherJson) {
                        tv1.setText(weatherJson.getWeatherinfo().getCity());
                    }
                });
//                .subscribe(new Subscriber<WeatherJson>() {}


//        Call<WeatherJson> weather = apiStores.getWeather("101010100");
//        weather.enqueue(new Callback<WeatherJson>() {
//            @Override
//            public void onResponse(Call<WeatherJson> call, Response<WeatherJson> response) {
//                Log.d("xxx", "onResponse: "+response.body().getWeatherinfo().getCityid());
//            }
//
//            @Override
//            public void onFailure(Call<WeatherJson> call, Throwable t) {
//
//            }
//        });
    }

    interface ApiStores {
        @GET("{cityId}.html")
        Observable<WeatherJson> getWeather(@Path("cityId") String cityId);

    }
}
