package com.pinnoocle.fruitindustryoptimization.nets;

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
import com.pinnoocle.fruitindustryoptimization.bean.GroupOrderDetailModel;
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
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by whs on 2017/2/17
 * Retrofit ??????
 */

public interface RetrofitService {
    // ??????
    @POST("index.php")
    Observable<StatusModel> login(@QueryMap Map<String, String> queryMap);

    // ???????????????
    @POST("index.php")
    Observable<StatusModel> sms(@QueryMap Map<String, String> queryMap);

    // ????????????
    @POST("index.php")
    Observable<UserInfoModel> userInfo(@QueryMap Map<String, String> queryMap);

    // ????????????
    @POST("index.php")
    Observable<UserInfoDetailModel> userInfoDetail(@QueryMap Map<String, String> queryMap);

    //????????????
    @Multipart
    @POST("index.php")
    Observable<StatusModel> modify(@Query("s") String s, @Query("nickName") String nickName, @Query("wxapp_id") String wxappid, @Query("token") String token, @Part MultipartBody.Part file);

    //????????????
    @POST("index.php")
    Observable<StatusModel> modify1(@QueryMap Map<String, String> queryMap);

    //???????????????
    @POST("index.php")
    Observable<StatusModel> changePhone(@QueryMap Map<String, String> queryMap);

    //???????????????
    @GET("index.php")
    Observable<TreePosterModel> treePoster(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @GET("index.php")
    Observable<TreeOrderModel> treeOrder(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<WalletModel> wallet(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<BalanceDetailModel> balanceDetail(@QueryMap Map<String, String> queryMap);

    //??????
    @GET("index.php")
    Observable<HomeModel> home(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<CategoryIndexModel> categoryIndex(@QueryMap Map<String, String> queryMap);

    //???????????????
    @POST("index.php")
    Observable<StatusModel> cartAdd(@QueryMap Map<String, String> queryMap);

    //?????????????????????
    @POST("index.php")
    Observable<CartListsModel> cartList(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<ArticleModel> article(@QueryMap Map<String, String> queryMap);

    //?????????????????????
    @POST("index.php")
    Observable<StatusModel> cartDelete(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<StatusModel> cartSub(@QueryMap Map<String, String> queryMap);


    //??????????????????
    @GET("index.php")
    Observable<UserTreesModel> userTrees(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<TreesModel> trees(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<TreesDetailModel> treesDetail(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<AddressListModel> addressList(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @POST("index.php")
    Observable<StatusModel> setDefault(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<StatusModel> addressDelete(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<StatusModel> addressAdd(@QueryMap Map<String, String> queryMap);

    //?????????????????? ????????????????????????
    @POST("index.php")
    Observable<FileInfoModel> fileInfo(@QueryMap Map<String, String> queryMap);

    //?????????-????????????
    @GET("index.php")
    Observable<BeforeBuyModel> beforeBuy(@QueryMap Map<String, String> queryMap);

    //??????-????????????
    @GET("index.php")
    Observable<GeneTreeOrderModel> geneTreeOrder(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<StatusModel> addressEdit(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<MyBalanceModel> myBalance(@QueryMap Map<String, String> queryMap);

    //??????
    @POST("index.php")
    Observable<CollectModel> collect(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<VipIntroModel> vipIntro(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<GoodsDetailModel> goodsDetail(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<GoodsSearchModel> goodsSearch(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @POST("index.php")
    Observable<SeckillModel> seckill(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<GroupWorkModel> groupWork(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @POST("index.php")
    Observable<GroupWorkListModel> groupWorkList(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<VipListsModel> vipLists(@QueryMap Map<String, String> queryMap);

    //??????/??????????????????
    @POST("index.php")
    Observable<StatusModel> userCollect(@QueryMap Map<String, String> queryMap);


    //???????????????
    @GET("index.php")
    Observable<CouponListsModel> couponLists(@QueryMap Map<String, String> queryMap);

    //????????????-?????????
    @GET("index.php")
    Observable<BuyNowModel> buyNow(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<ResultModel> rightBuy(@QueryMap Map<String, String> queryMap);

    //?????????
    @GET("index.php")
    Observable<BuyNowModel> orderCart(@QueryMap Map<String, String> queryMap);

    //??????
    @POST("index.php")
    Observable<StatusModel> rightBuyCart(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<OrderListModel> orderList(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<SharingGoodsDetailModel> sharingGoodsDetail(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<GroupRuleModel> groupRule(@QueryMap Map<String, String> queryMap);

    //?????????
    @GET("index.php")
    Observable<BuyNowModel> groupBuy(@QueryMap Map<String, String> queryMap);

    //??????
    @POST("index.php")
    Observable<ResultModel> groupRightBuy(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<StatusModel> orderCancel(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<StatusModel> orderReceipt(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<OrderDetailModel> orderDetail(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @POST("index.php")
    Observable<UserTreeDetailModel> userTreeDetail(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<StatusModel> grow(@QueryMap Map<String, String> queryMap);

    //???????????????
    @POST("index.php")
    Observable<TreePacketModel> treePacket(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<CertificateDetailModel> certificateDetail(@QueryMap Map<String, String> queryMap);

    //????????????
    @POST("index.php")
    Observable<MyPushModel> myPush(@QueryMap Map<String, String> queryMap);

    //??????
    @POST("index.php")
    Observable<StatusModel> orderPay(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @POST("index.php")
    Observable<StatusModel> nameTree(@QueryMap Map<String, String> queryMap);

    //?????????????????????
    @GET("index.php")
    Observable<GroupOrderListModel> groupOrderList(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<ActiveDetailModel> activeDetail(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @GET("index.php")
    Observable<OrderDetailModel> groupOrderDetail(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @POST("index.php")
    Observable<SecKillVenueModel> secKillVenue(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @GET("index.php")
    Observable<SecKillDetailModel> secKillDetail(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<PartakeModel> partake(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @GET("index.php")
    Observable<TaskDetailModel> taskDetail(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @POST("index.php")
    Observable<StatusModel> commentOrder(@QueryMap Map<String, String> map1,@Body Map<String, String> map2);

    //????????????
    @Multipart
    @POST("index.php")
    Observable<UploadImageModel> image(@QueryMap Map<String, String> queryMap, @Part MultipartBody.Part file);

    //????????????
    @POST("index.php")
    Observable<StatusModel> refundApply(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<MyCommentModel> myComment(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<RefundListsModel> refundLists(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @GET("index.php")
    Observable<RefundListsModel> groupRefundLists(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<MyCommentModel> goodsComment(@QueryMap Map<String, String> queryMap);

    //????????????
    @GET("index.php")
    Observable<CouponCenterModel> couponCenter(@QueryMap Map<String, String> queryMap);

    //???????????????
    @POST("index.php")
    Observable<StatusModel> getCoupon(@QueryMap Map<String, String> queryMap);

    //??????????????????
    @POST("index.php")
    Observable<RefundDetailModel> refundDetail(@QueryMap Map<String, String> queryMap);

    //??????-????????????
    @POST("index.php")
    Observable<StatusModel> refundDelivery(@QueryMap Map<String, String> queryMap);

    //????????????????????????
    @POST("index.php")
    Observable<StatusModel> groupRefundApply(@QueryMap Map<String, String> queryMap);

}
