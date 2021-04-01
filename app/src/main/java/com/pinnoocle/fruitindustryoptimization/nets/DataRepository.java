package com.pinnoocle.fruitindustryoptimization.nets;

import android.content.Context;

import java.util.Map;

import okhttp3.MultipartBody;

/**
 * Created by whs on 2017/5/18
 */

public class DataRepository implements RemotDataSource {
    private Context mContext;

    private static DataRepository INSTANCE = null;


    private final RemotDataSourceImpl mRemoteDataSource;

    public static DataRepository getInstance(RemotDataSourceImpl remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DataRepository(remoteDataSource);
        }
        return INSTANCE;
    }

    private DataRepository(RemotDataSourceImpl remoteDataSource) {
        //this.mContext=context;
        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void login(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.login(queryMap, callback);
    }

    @Override
    public void sms(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.sms(queryMap, callback);
    }

    @Override
    public void userInfo(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.userInfo(queryMap, callback);
    }

    @Override
    public void userInfoDetail(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.userInfoDetail(queryMap, callback);
    }

    @Override
    public void modify(String s, String nickName, String wxappid, String token, MultipartBody.Part file, getCallback callback) {
        mRemoteDataSource.modify(s, nickName, wxappid, token, file, callback);
    }

    @Override
    public void modify1(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.modify1(queryMap, callback);
    }

    @Override
    public void changePhone(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.changePhone(queryMap, callback);
    }

    @Override
    public void treePoster(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.treePoster(queryMap, callback);
    }

    @Override
    public void treeOrder(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.treeOrder(queryMap, callback);
    }

    @Override
    public void home(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.home(queryMap, callback);
    }

    @Override
    public void categoryIndex(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.categoryIndex(queryMap, callback);
    }

    @Override
    public void cartAdd(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.cartAdd(queryMap, callback);
    }

    @Override
    public void cartList(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.cartList(queryMap, callback);
    }

    @Override
    public void wallet(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.wallet(queryMap, callback);
    }

    @Override
    public void balanceDetail(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.balanceDetail(queryMap, callback);
    }

    @Override
    public void article(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.article(queryMap, callback);
    }

    @Override
    public void cartDelete(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.cartDelete(queryMap, callback);
    }

    @Override
    public void userTrees(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.userTrees(queryMap, callback);
    }

    @Override
    public void trees(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.trees(queryMap, callback);
    }

    @Override
    public void orderCart(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.orderCart(queryMap, callback);
    }

    @Override
    public void addressList(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.addressList(queryMap, callback);
    }

    @Override
    public void setDefault(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.setDefault(queryMap, callback);
    }

    @Override
    public void addressDelete(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.addressDelete(queryMap, callback);
    }

    @Override
    public void addressEdit(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.addressEdit(queryMap, callback);
    }

    @Override
    public void addressAdd(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.addressAdd(queryMap, callback);
    }

    @Override
    public void userCollect(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.userCollect(queryMap, callback);
    }

    @Override
    public void buyNow(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.buyNow(queryMap, callback);
    }

    @Override
    public void rightBuy(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.rightBuy(queryMap, callback);
    }

    @Override
    public void orderList(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.orderList(queryMap, callback);
    }

    @Override
    public void cartSub(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.cartSub(queryMap, callback);
    }

    @Override
    public void treesDetail(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.treesDetail(queryMap, callback);
    }

    @Override
    public void fileInfo(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.fileInfo(queryMap, callback);
    }

    @Override
    public void beforeBuy(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.beforeBuy(queryMap, callback);
    }

    @Override
    public void geneTreeOrder(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.geneTreeOrder(queryMap, callback);
    }

    @Override
    public void myBalance(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.myBalance(queryMap, callback);
    }

    @Override
    public void collect(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.collect(queryMap, callback);
    }

    @Override
    public void vipIntro(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.vipIntro(queryMap, callback);
    }

    @Override
    public void goodsDetail(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.goodsDetail(queryMap, callback);
    }

    @Override
    public void goodsSearch(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.goodsSearch(queryMap, callback);
    }

    @Override
    public void seckill(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.seckill(queryMap, callback);
    }

    @Override
    public void groupWork(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.groupWork(queryMap, callback);
    }

    @Override
    public void groupWorkList(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.groupWorkList(queryMap, callback);
    }

    @Override
    public void vipLists(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.vipLists(queryMap, callback);
    }

    @Override
    public void couponLists(Map<String, String> queryMap, getCallback callback) {
        mRemoteDataSource.couponLists(queryMap, callback);
    }

}
