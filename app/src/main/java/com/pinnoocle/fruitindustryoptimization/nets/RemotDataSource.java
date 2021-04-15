package com.pinnoocle.fruitindustryoptimization.nets;


import com.pinnoocle.fruitindustryoptimization.bean.UploadImageModel;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

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

    void cartSub(Map<String, String> queryMap, getCallback callback);

    void userTrees(Map<String, String> queryMap, getCallback callback);

    void trees(Map<String, String> queryMap, getCallback callback);

    void treesDetail(Map<String, String> queryMap, getCallback callback);

    void orderCart(Map<String, String> queryMap, getCallback callback);

    void addressList(Map<String, String> queryMap, getCallback callback);

    void setDefault(Map<String, String> queryMap, getCallback callback);

    void addressDelete(Map<String, String> queryMap, getCallback callback);

    void addressEdit(Map<String, String> queryMap, getCallback callback);

    void fileInfo(Map<String, String> queryMap, getCallback callback);

    void beforeBuy(Map<String, String> queryMap, getCallback callback);

    void geneTreeOrder(Map<String, String> queryMap, getCallback callback);

    void myBalance(Map<String, String> queryMap, getCallback callback);

    void collect(Map<String, String> queryMap, getCallback callback);

    void vipIntro(Map<String, String> queryMap, getCallback callback);

    void goodsDetail(Map<String, String> queryMap, getCallback callback);

    void goodsSearch(Map<String, String> queryMap, getCallback callback);

    void seckill(Map<String, String> queryMap, getCallback callback);

    void groupWork(Map<String, String> queryMap, getCallback callback);

    void groupWorkList(Map<String, String> queryMap, getCallback callback);

    void addressAdd(Map<String, String> queryMap, getCallback callback);

    void vipLists(Map<String, String> queryMap, getCallback callback);

    void userCollect(Map<String, String> queryMap, getCallback callback);

    void buyNow(Map<String, String> queryMap, getCallback callback);

    void rightBuy(Map<String, String> queryMap, getCallback callback);

    void rightBuyCart(Map<String, String> queryMap, getCallback callback);

    void orderList(Map<String, String> queryMap, getCallback callback);

    void sharingGoodsDetail(Map<String, String> queryMap, getCallback callback);

    void groupRule(Map<String, String> queryMap, getCallback callback);

    void groupBuy(Map<String, String> queryMap, getCallback callback);

    void groupRightBuy(Map<String, String> queryMap, getCallback callback);

    void orderCancel(Map<String, String> queryMap, getCallback callback);

    void orderReceipt(Map<String, String> queryMap, getCallback callback);

    void orderDetail(Map<String, String> queryMap, getCallback callback);

    void orderPay(Map<String, String> queryMap, getCallback callback);

    void couponLists(Map<String, String> queryMap, getCallback callback);

    void userTreeDetail(Map<String, String> queryMap, getCallback callback);

    void grow(Map<String, String> queryMap, getCallback callback);

    void treePacket(Map<String, String> queryMap, getCallback callback);

    void certificateDetail(Map<String, String> queryMap, getCallback callback);

    void myPush(Map<String, String> queryMap, getCallback callback);

    void nameTree(Map<String, String> queryMap, getCallback callback);

    void groupOrderList(Map<String, String> queryMap, getCallback callback);

    void activeDetail(Map<String, String> queryMap, getCallback callback);

    void groupOrderDetail(Map<String, String> queryMap, getCallback callback);

    void commentOrder(Map<String, String> map1, Map<String, String> map2, getCallback callback);

    void image(Map<String, String> queryMap, MultipartBody.Part file, getCallback callback);

    void secKillVenue(Map<String, String> queryMap, getCallback callback);

    void secKillDetail(Map<String, String> queryMap, getCallback callback);

    void partake(Map<String, String> queryMap, getCallback callback);

    void taskDetail(Map<String, String> queryMap, getCallback callback);

    void refundApply(Map<String, String> queryMap, getCallback callback);

    void myComment(Map<String, String> queryMap, getCallback callback);

    void refundLists(Map<String, String> queryMap, getCallback callback);

    void groupRefundLists(Map<String, String> queryMap, getCallback callback);

    void goodsComment(Map<String, String> queryMap, getCallback callback);

    void couponCenter(Map<String, String> queryMap, getCallback callback);

    void getCoupon(Map<String, String> queryMap, getCallback callback);

    Observable<UploadImageModel> imageObservable(Map<String, String> queryMap, MultipartBody.Part file);
}
