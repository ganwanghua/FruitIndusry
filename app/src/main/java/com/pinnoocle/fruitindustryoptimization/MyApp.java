package com.pinnoocle.fruitindustryoptimization;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.greendao.DaoMaster;
import com.pinnoocle.fruitindustryoptimization.greendao.DaoSession;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.zzhoujay.richtext.RichText;


public class MyApp extends Application {
    private static MyApp sInstance;
    public static final String DB_NAME = "rd.db";
    private DaoSession mDaoSession;
    public static final String WX_APPID = "wx18024fe375f56025";
    public static final String WX_APPSecret = "";
    public static IWXAPI mWxApi;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        FastData.getInstance();
        ToastUtils.init(this);
        RichText.initCacheDir(this);
        setDatabase();
        mWxApi = WXAPIFactory.createWXAPI(this, WX_APPID, true);
        mWxApi.registerApp(WX_APPID);

        UMConfigure.init(this, "606fc57cde41b946ab440c1b", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        PlatformConfig.setWeixin(WX_APPID, WX_APPSecret);
        PlatformConfig.setWXFileProvider("com.tencent.sample2.fileprovider");
    }

    private void setDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public static MyApp getInstance() {
        return sInstance;
    }
}
