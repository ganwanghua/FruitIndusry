package com.pinnoocle.fruitindustryoptimization.nets;


import java.util.Map;

import okhttp3.MultipartBody;

/**
 * Created by whs on 2017/6/7
 */

public interface RemotDataSource {
    interface getCallback {

        void onFailure(String info);

        void onSuccess(Object data);
    }

    void login(Map<String, String> queryMap, getCallback callback);

    void sms(Map<String, String> queryMap, getCallback callback);

    void userInfo(Map<String, String> queryMap, getCallback callback);

    void userInfoDetail(Map<String, String> queryMap, getCallback callback);

    void modify(String s, String nickName, String wxappid, String token, MultipartBody.Part file, getCallback callback);

    void modify1(Map<String, String> queryMap, getCallback callback);

    void changePhone(Map<String, String> queryMap, getCallback callback);

    void treePoster(Map<String, String> queryMap, getCallback callback);

    void treeOrder(Map<String, String> queryMap, getCallback callback);

    void wallet(Map<String, String> queryMap, getCallback callback);

    void balanceDetail(Map<String, String> queryMap, getCallback callback);

    void home(Map<String, String> queryMap, getCallback callback);

    void categoryIndex(Map<String, String> queryMap, getCallback callback);

    void cartAdd(Map<String, String> queryMap, getCallback callback);

    void cartList(Map<String, String> queryMap, getCallback callback);

    void article(Map<String, String> queryMap, getCallback callback);

    void cartDelete(Map<String, String> queryMap, getCallback callback);

    void userTrees(Map<String, String> queryMap, getCallback callback);

    void trees(Map<String, String> queryMap, getCallback callback);
}
