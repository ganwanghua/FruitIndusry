package com.pinnoocle.fruitindustryoptimization.nets;


import android.content.Context;

import com.pinnoocle.fruitindustryoptimization.bean.ActiveDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.AddressListModel;
import com.pinnoocle.fruitindustryoptimization.bean.ArticleModel;
import com.pinnoocle.fruitindustryoptimization.bean.BalanceDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.BeforeBuyModel;
import com.pinnoocle.fruitindustryoptimization.bean.BuyNowModel;
import com.pinnoocle.fruitindustryoptimization.bean.CartListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.CategoryIndexModel;
import com.pinnoocle.fruitindustryoptimization.bean.CertificateDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.CollectModel;
import com.pinnoocle.fruitindustryoptimization.bean.CouponCenterModel;
import com.pinnoocle.fruitindustryoptimization.bean.CouponListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.FileInfoModel;
import com.pinnoocle.fruitindustryoptimization.bean.GeneTreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsSearchModel;
import com.pinnoocle.fruitindustryoptimization.bean.GroupOrderListModel;
import com.pinnoocle.fruitindustryoptimization.bean.GroupRuleModel;
import com.pinnoocle.fruitindustryoptimization.bean.GroupWorkListModel;
import com.pinnoocle.fruitindustryoptimization.bean.GroupWorkModel;
import com.pinnoocle.fruitindustryoptimization.bean.HomeModel;
import com.pinnoocle.fruitindustryoptimization.bean.MyBalanceModel;
import com.pinnoocle.fruitindustryoptimization.bean.MyCommentModel;
import com.pinnoocle.fruitindustryoptimization.bean.MyPushModel;
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.OrderListModel;
import com.pinnoocle.fruitindustryoptimization.bean.PartakeModel;
import com.pinnoocle.fruitindustryoptimization.bean.RefundDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.RefundListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.ResultModel;
import com.pinnoocle.fruitindustryoptimization.bean.SecKillDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.SecKillVenueModel;
import com.pinnoocle.fruitindustryoptimization.bean.SeckillModel;
import com.pinnoocle.fruitindustryoptimization.bean.SharingGoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.TaskDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreePacketModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreePosterModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.bean.UploadImageModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreeDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreesModel;
import com.pinnoocle.fruitindustryoptimization.bean.VipIntroModel;
import com.pinnoocle.fruitindustryoptimization.bean.VipListsModel;
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

    @Override
    public void cartSub(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().cartSub(queryMap);
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
    public void userTrees(Map<String, String> queryMap, getCallback callback) {
        Observable<UserTreesModel> observable = RetrofitHelper.getInstance(mContext).getServer().userTrees(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserTreesModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(UserTreesModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void trees(Map<String, String> queryMap, getCallback callback) {
        Observable<TreesModel> observable = RetrofitHelper.getInstance(mContext).getServer().trees(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TreesModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(TreesModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void orderCart(Map<String, String> queryMap, getCallback callback) {
        Observable<BuyNowModel> observable = RetrofitHelper.getInstance(mContext).getServer().orderCart(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BuyNowModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(BuyNowModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void addressList(Map<String, String> queryMap, getCallback callback) {
        Observable<AddressListModel> observable = RetrofitHelper.getInstance(mContext).getServer().addressList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressListModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(AddressListModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void setDefault(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().setDefault(queryMap);
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
    public void addressDelete(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().addressDelete(queryMap);
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
    public void addressAdd(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().addressAdd(queryMap);
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
    public void userCollect(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().userCollect(queryMap);
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
    public void buyNow(Map<String, String> queryMap, getCallback callback) {
        Observable<BuyNowModel> observable = RetrofitHelper.getInstance(mContext).getServer().buyNow(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BuyNowModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(BuyNowModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void rightBuy(Map<String, String> queryMap, getCallback callback) {
        Observable<ResultModel> observable = RetrofitHelper.getInstance(mContext).getServer().rightBuy(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ResultModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void rightBuyCart(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().rightBuyCart(queryMap);
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
    public void orderList(Map<String, String> queryMap, getCallback callback) {
        Observable<OrderListModel> observable = RetrofitHelper.getInstance(mContext).getServer().orderList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderListModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(OrderListModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void sharingGoodsDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<SharingGoodsDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().sharingGoodsDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SharingGoodsDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(SharingGoodsDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void groupRule(Map<String, String> queryMap, getCallback callback) {
        Observable<GroupRuleModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupRule(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GroupRuleModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GroupRuleModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void groupBuy(Map<String, String> queryMap, getCallback callback) {
        Observable<BuyNowModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupBuy(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BuyNowModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(BuyNowModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void groupRightBuy(Map<String, String> queryMap, getCallback callback) {
        Observable<ResultModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupRightBuy(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ResultModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void orderCancel(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().orderCancel(queryMap);
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
    public void orderReceipt(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().orderReceipt(queryMap);
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
    public void orderDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<OrderDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().orderDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(OrderDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void orderPay(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().orderPay(queryMap);
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
    public void treesDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<TreesDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().treesDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TreesDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(TreesDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void fileInfo(Map<String, String> queryMap, getCallback callback) {
        Observable<FileInfoModel> observable = RetrofitHelper.getInstance(mContext).getServer().fileInfo(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FileInfoModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(FileInfoModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void beforeBuy(Map<String, String> queryMap, getCallback callback) {
        Observable<BeforeBuyModel> observable = RetrofitHelper.getInstance(mContext).getServer().beforeBuy(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeforeBuyModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(BeforeBuyModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void geneTreeOrder(Map<String, String> queryMap, getCallback callback) {
        Observable<GeneTreeOrderModel> observable = RetrofitHelper.getInstance(mContext).getServer().geneTreeOrder(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GeneTreeOrderModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GeneTreeOrderModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void addressEdit(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().addressEdit(queryMap);
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
    public void myBalance(Map<String, String> queryMap, getCallback callback) {
        Observable<MyBalanceModel> observable = RetrofitHelper.getInstance(mContext).getServer().myBalance(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBalanceModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(MyBalanceModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void collect(Map<String, String> queryMap, getCallback callback) {
        Observable<CollectModel> observable = RetrofitHelper.getInstance(mContext).getServer().collect(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CollectModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CollectModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void vipIntro(Map<String, String> queryMap, getCallback callback) {
        Observable<VipIntroModel> observable = RetrofitHelper.getInstance(mContext).getServer().vipIntro(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VipIntroModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(VipIntroModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void goodsDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<GoodsDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().goodsDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GoodsDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void goodsSearch(Map<String, String> queryMap, getCallback callback) {
        Observable<GoodsSearchModel> observable = RetrofitHelper.getInstance(mContext).getServer().goodsSearch(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodsSearchModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GoodsSearchModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void seckill(Map<String, String> queryMap, getCallback callback) {
        Observable<SeckillModel> observable = RetrofitHelper.getInstance(mContext).getServer().seckill(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SeckillModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(SeckillModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void groupWork(Map<String, String> queryMap, getCallback callback) {
        Observable<GroupWorkModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupWork(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GroupWorkModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GroupWorkModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void groupWorkList(Map<String, String> queryMap, getCallback callback) {
        Observable<GroupWorkListModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupWorkList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GroupWorkListModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GroupWorkListModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void vipLists(Map<String, String> queryMap, getCallback callback) {
        Observable<VipListsModel> observable = RetrofitHelper.getInstance(mContext).getServer().vipLists(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VipListsModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(VipListsModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void couponLists(Map<String, String> queryMap, getCallback callback) {
        Observable<CouponListsModel> observable = RetrofitHelper.getInstance(mContext).getServer().couponLists(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CouponListsModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CouponListsModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void userTreeDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<UserTreeDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().userTreeDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserTreeDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(UserTreeDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void grow(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().grow(queryMap);
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
    public void treePacket(Map<String, String> queryMap, getCallback callback) {
        Observable<TreePacketModel> observable = RetrofitHelper.getInstance(mContext).getServer().treePacket(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TreePacketModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(TreePacketModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void certificateDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<CertificateDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().certificateDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CertificateDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CertificateDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void myPush(Map<String, String> queryMap, getCallback callback) {
        Observable<MyPushModel> observable = RetrofitHelper.getInstance(mContext).getServer().myPush(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyPushModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(MyPushModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void nameTree(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().nameTree(queryMap);
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
    public void groupOrderList(Map<String, String> queryMap, getCallback callback) {
        Observable<GroupOrderListModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupOrderList(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GroupOrderListModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(GroupOrderListModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void activeDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<ActiveDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().activeDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ActiveDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ActiveDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void groupOrderDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<OrderDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupOrderDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(OrderDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void secKillVenue(Map<String, String> queryMap, getCallback callback) {
        Observable<SecKillVenueModel> observable = RetrofitHelper.getInstance(mContext).getServer().secKillVenue(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SecKillVenueModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(SecKillVenueModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void secKillDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<SecKillDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().secKillDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SecKillDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(SecKillDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void partake(Map<String, String> queryMap, getCallback callback) {
        Observable<PartakeModel> observable = RetrofitHelper.getInstance(mContext).getServer().partake(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PartakeModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(PartakeModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void taskDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<TaskDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().taskDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TaskDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(TaskDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void myComment(Map<String, String> queryMap, getCallback callback) {
        Observable<MyCommentModel> observable = RetrofitHelper.getInstance(mContext).getServer().myComment(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyCommentModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(MyCommentModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void refundLists(Map<String, String> queryMap, getCallback callback) {
        Observable<RefundListsModel> observable = RetrofitHelper.getInstance(mContext).getServer().refundLists(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RefundListsModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(RefundListsModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void groupRefundLists(Map<String, String> queryMap, getCallback callback) {
        Observable<RefundListsModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupRefundLists(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RefundListsModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(RefundListsModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void goodsComment(Map<String, String> queryMap, getCallback callback) {
        Observable<MyCommentModel> observable = RetrofitHelper.getInstance(mContext).getServer().goodsComment(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyCommentModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(MyCommentModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void couponCenter(Map<String, String> queryMap, getCallback callback) {
        Observable<CouponCenterModel> observable = RetrofitHelper.getInstance(mContext).getServer().couponCenter(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CouponCenterModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(CouponCenterModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void getCoupon(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().getCoupon(queryMap);
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
    public void refundDetail(Map<String, String> queryMap, getCallback callback) {
        Observable<RefundDetailModel> observable = RetrofitHelper.getInstance(mContext).getServer().refundDetail(queryMap);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RefundDetailModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(RefundDetailModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }

    @Override
    public void refundDelivery(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().refundDelivery(queryMap);
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
    public void groupRefundApply(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().groupRefundApply(queryMap);
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
    public void refundApply(Map<String, String> queryMap, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().refundApply(queryMap);
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
    public void commentOrder(Map<String, String> map1,Map<String, String> map2, getCallback callback) {
        Observable<StatusModel> observable = RetrofitHelper.getInstance(mContext).getServer().commentOrder(map1,map2);
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
    public void image(Map<String, String> queryMap, MultipartBody.Part file, getCallback callback) {
        Observable<UploadImageModel> observable = RetrofitHelper.getInstance(mContext).getServer().image(queryMap, file);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UploadImageModel>() {
                    @Override
                    public void onCompleted() { // 完成请求后

                    }

                    @Override
                    public void onError(Throwable e) { // 异常处理
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(UploadImageModel s) { // 请求成功
                        callback.onSuccess(s);
                    }
                });
    }
    public  Observable<UploadImageModel> imageObservable(Map<String, String> queryMap, MultipartBody.Part file){
        return RetrofitHelper.getInstance(mContext).getServer().image(queryMap, file);
    }
}
