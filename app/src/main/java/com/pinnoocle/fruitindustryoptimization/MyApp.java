package com.pinnoocle.fruitindustryoptimization;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.greendao.DaoMaster;
import com.pinnoocle.fruitindustryoptimization.greendao.DaoSession;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.zzhoujay.richtext.RichText;


public class MyApp extends Application {
    private static MyApp sInstance;
    public static final String DB_NAME = "rd.db";
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        FastData.getInstance();
        ToastUtils.init(this);
        RichText.initCacheDir(this);
        setDatabase();
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
