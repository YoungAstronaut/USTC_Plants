package com.example.ustcplant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

public class LocationsGet extends AppCompatActivity {

    LocationClient mLocationClient;  //定位客户端
    MapView mapView;  //Android Widget地图控件
    BaiduMap baiduMap;
    boolean isFirstLocate = true;
    TextView tv_Lat;  //纬度
    TextView tv_Lon;  //经度
    TextView tv_Add;  //地址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_locations_get);
        mapView = (MapView) findViewById(R.id.bmapView);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//        }else {
//            requestLocation();
//        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case 1:
//                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(this, "没有定位权限！", Toast.LENGTH_LONG).show();
//                    finish();
//                } else {
//                    requestLocation();
//                }
//        }
//    }
//    private void requestLocation() {
//        initLocation();
//        mLocationClient.start();
//    }
//
//    private void initLocation() {  //初始化
//        LocationClient.setAgreePrivacy(true);
//        try{
//            mLocationClient = new LocationClient(getApplicationContext());
//        }catch (java.lang.Exception e){
//            finish();
//        }
//        mLocationClient.registerLocationListener(new MyLocationListener());
//        SDKInitializer.initialize(getApplicationContext());
//        setContentView(R.layout.activity_locations_get);
//
//        mapView = findViewById(R.id.bmapView);
//        baiduMap = mapView.getMap();
//        tv_Lat = findViewById(R.id.tv_Lat);
//        tv_Lon = findViewById(R.id.tv_Lon);
//        tv_Add = findViewById(R.id.tv_Add);
//        LocationClientOption option = new LocationClientOption();
//        //设置扫描时间间隔
//        option.setScanSpan(1000);
//        //设置定位模式，三选一
//        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//        /*option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
//        option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);*/
//        //设置需要地址信息
//        option.setIsNeedAddress(true);
//        //保存定位参数
//        mLocationClient.setLocOption(option);
//    }
//    //内部类，百度位置监听器
//    private class MyLocationListener  implements BDLocationListener {
//        //获取纬度信息
//        @Override
//        public void onReceiveLocation(BDLocation bdLocation) {
//            tv_Lat.setText(bdLocation.getLatitude()+"");
//            tv_Lon.setText(bdLocation.getLongitude()+"");
//            tv_Add.setText(bdLocation.getAddrStr());
//            if(bdLocation.getLocType()==BDLocation.TypeGpsLocation ||
//                    bdLocation.getLocType()==BDLocation.TypeNetWorkLocation){
//                navigateTo(bdLocation);
//            }
//        }
//    }
//    private void navigateTo(BDLocation bdLocation) {
//        if(isFirstLocate){
//            LatLng ll = new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
//            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
//            baiduMap.animateMapStatus(update);
//            isFirstLocate = false;
//        }
//    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
        mapView = null;
    }
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
        mapView.onDestroy();
    }

}