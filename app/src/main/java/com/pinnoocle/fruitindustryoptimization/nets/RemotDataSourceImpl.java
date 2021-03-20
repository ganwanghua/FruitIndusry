package com.pinnoocle.fruitindustryoptimization.nets;


import android.content.Context;

import com.pinnoocle.fruitindustryoptimization.bean.CartListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.ArticleModel;
import com.pinnoocle.fruitindustryoptimization.bean.BalanceDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.CategoryIndexModel;
import com.pinnoocle.fruitindustryoptimization.bean.HomeModel;
import com.pinnoocle.fruitindustryoptimization.bean.ImageModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreePosterModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoModel;
import com.pinnoocle.fruitindustryoptimization.bean.WalletModel;

import java.util.Map;

import okhttp3.MultipartBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by whs on 2017/5/18
 */

public class RemotDataSourceImpl implements RemotDataSource {

    private static Context mContext;

    private static class Laydz {
        private static RemotDataSourceImpl instance = new RemotDataSourceImpl();
    }


    public static RemotDataSourceImpl getInstance(Context context) {
        mContext = context;
        return Laydz.instance;
    }

    @Override
    public void login(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().login(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void sms(Map<String, String> queryMap, final getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().sms(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void userInfo(Map<String, String> queryMap, final getCallback callback) {
        Observable<UserInfoModel> observable = RetrofitHelper.getInstance(mContext).getServer().userInfo(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfoModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(UserInfoModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void userInfoDetail(Map<String, String> queryMap, final getCallback callback) {
        Observable<UserInfoDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().userInfoDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfoDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(UserInfoDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void modify(String s, String nickName, String wxappid, String token, MultipartBody.Part file, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().modify(s, nickName, wxappid, token, file);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void modify1(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().modify1(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void changePhone(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().changePhone(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void treePoster(Map<String, String> queryMap, getCallback callback) {
        Observable<TreePosterModel> observable = RetrofitHelper.getInstance(mContext).getServer().treePoster(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TreePosterModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(TreePosterModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void treeOrder(Map<String, String> queryMap, getCallback callback) {
        Observable<TreeOrderModel> observable = RetrofitHelper.getInstance(mContext).getServer().treeOrder(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TreeOrderModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(TreeOrderModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void home(Map<String, String> queryMap, getCallback callback) {
        Observable<HomeModel> observable = RetrofitHelper.getInstance(mContext).getServer().home(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(HomeModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void categoryIndex(Map<String, String> queryMap, getCallback callback) {
        Observable<CategoryIndexModel> observable = RetrofitHelper.getInstance(mContext).getServer().categoryIndex(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryIndexModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CategoryIndexModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void cartAdd(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().cartAdd(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void cartList(Map<String, String> queryMap, getCallback callback) {
        Observable<CartListsModel> observable = RetrofitHelper.getInstance(mContext).getServer().cartList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartListsModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CartListsModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void wallet(Map<String, String> queryMap, getCallback callback) {
        Observable<WalletModel> observable = RetrofitHelper.getInstance(mContext).getServer().wallet(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WalletModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(WalletModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void balanceDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<BalanceDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().balanceDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BalanceDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(BalanceDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void article(Map<String, String> queryMap, getCallback callback) {
        Observable<ArticleModel> observable = RetrofitHelper.getInstance(mContext).getServer().article(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticleModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ArticleModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void cartDelete(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().cartDelete(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatusModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }
}
