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
import com.pinnoocle.fruitindustryoptimization.bean.MyPushModel;
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.OrderListModel;
import com.pinnoocle.fruitindustryoptimization.bean.SeckillModel;
import com.pinnoocle.fruitindustryoptimization.bean.SharingGoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreePacketModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreePosterModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreeDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreesModel;
import com.pinnoocle.fruitindustryoptimization.bean.VipIntroModel;
import com.pinnoocle.fruitindustryoptimization.bean.VipListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.WalletModel;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by whs on 2017/2/17
 * Retrofit 接口
 */

public interface RetrofitService {
    // 登录
    @POST("index.php")
    Observable<StatusModel> login(@QueryMap Map<String, String> queryMap);

    // 登录验证码
    @POST("index.php")
    Observable<StatusModel> sms(@QueryMap Map<String, String> queryMap);

    // 个人中心
    @POST("index.php")
    Observable<UserInfoModel> userInfo(@QueryMap Map<String, String> queryMap);

    // 用户信息
    @POST("index.php")
    Observable<UserInfoDetailModel> userInfoDetail(@QueryMap Map<String, String> queryMap);

    //上传图片
    @Multipart
    @POST("index.php")
    Observable<StatusModel> modify(@Query("s") String s, @Query("nickName") String nickName, @Query("wxapp_id") String wxappid, @Query("token") String token, @Part MultipartBody.Part file);

    //修改昵称
    @POST("index.php")
    Observable<StatusModel> modify1(@QueryMap Map<String, String> queryMap);

    //修改手机号
    @POST("index.php")
    Observable<StatusModel> changePhone(@QueryMap Map<String, String> queryMap);

    //推广二维码
    @GET("index.php")
    Observable<TreePosterModel> treePoster(@QueryMap Map<String, String> queryMap);

    //用户认养订单
    @GET("index.php")
    Observable<TreeOrderModel> treeOrder(@QueryMap Map<String, String> queryMap);

    //我的钱包
    @GET("index.php")
    Observable<WalletModel> wallet(@QueryMap Map<String, String> queryMap);

    //余额明细
    @GET("index.php")
    Observable<BalanceDetailModel> balanceDetail(@QueryMap Map<String, String> queryMap);

    //首页
    @GET("index.php")
    Observable<HomeModel> home(@QueryMap Map<String, String> queryMap);

    //全部分类
    @GET("index.php")
    Observable<CategoryIndexModel> categoryIndex(@QueryMap Map<String, String> queryMap);

    //加入购物车
    @POST("index.php")
    Observable<StatusModel> cartAdd(@QueryMap Map<String, String> queryMap);

    //购物车商品列表
    @POST("index.php")
    Observable<CartListsModel> cartList(@QueryMap Map<String, String> queryMap);

    //文章详情
    @GET("index.php")
    Observable<ArticleModel> article(@QueryMap Map<String, String> queryMap);

    //删除购物车商品
    @POST("index.php")
    Observable<StatusModel> cartDelete(@QueryMap Map<String, String> queryMap);

    //减少数量
    @POST("index.php")
    Observable<StatusModel> cartSub(@QueryMap Map<String, String> queryMap);


    //用户果树列表
    @GET("index.php")
    Observable<UserTreesModel> userTrees(@QueryMap Map<String, String> queryMap);

    //果树列表
    @GET("index.php")
    Observable<TreesModel> trees(@QueryMap Map<String, String> queryMap);

    //果树详情
    @GET("index.php")
    Observable<TreesDetailModel> treesDetail(@QueryMap Map<String, String> queryMap);

    //地址列表
    @GET("index.php")
    Observable<AddressListModel> addressList(@QueryMap Map<String, String> queryMap);

    //设为默认地址
    @POST("index.php")
    Observable<StatusModel> setDefault(@QueryMap Map<String, String> queryMap);

    //删除地址
    @POST("index.php")
    Observable<StatusModel> addressDelete(@QueryMap Map<String, String> queryMap);

    //添加地址
    @POST("index.php")
    Observable<StatusModel> addressAdd(@QueryMap Map<String, String> queryMap);

    //图片视频信息 （按照地块获取）
    @POST("index.php")
    Observable<FileInfoModel> fileInfo(@QueryMap Map<String, String> queryMap);

    //预下单-认养果树
    @GET("index.php")
    Observable<BeforeBuyModel> beforeBuy(@QueryMap Map<String, String> queryMap);

    //下单-认养果树
    @GET("index.php")
    Observable<GeneTreeOrderModel> geneTreeOrder(@QueryMap Map<String, String> queryMap);

    //编辑地址
    @POST("index.php")
    Observable<StatusModel> addressEdit(@QueryMap Map<String, String> queryMap);

    //认养返利
    @POST("index.php")
    Observable<MyBalanceModel> myBalance(@QueryMap Map<String, String> queryMap);

    //收藏
    @POST("index.php")
    Observable<CollectModel> collect(@QueryMap Map<String, String> queryMap);

    //会员权益
    @POST("index.php")
    Observable<VipIntroModel> vipIntro(@QueryMap Map<String, String> queryMap);

    //商品詳情
    @POST("index.php")
    Observable<GoodsDetailModel> goodsDetail(@QueryMap Map<String, String> queryMap);

    //商品列表
    @POST("index.php")
    Observable<GoodsSearchModel> goodsSearch(@QueryMap Map<String, String> queryMap);

    //我的秒杀助力
    @POST("index.php")
    Observable<SeckillModel> seckill(@QueryMap Map<String, String> queryMap);

    //拼团首页
    @POST("index.php")
    Observable<GroupWorkModel> groupWork(@QueryMap Map<String, String> queryMap);

    //拼团商品列表
    @POST("index.php")
    Observable<GroupWorkListModel> groupWorkList(@QueryMap Map<String, String> queryMap);

    //会员商品
    @GET("index.php")
    Observable<VipListsModel> vipLists(@QueryMap Map<String, String> queryMap);

    //收藏/取消收藏商品
    @POST("index.php")
    Observable<StatusModel> userCollect(@QueryMap Map<String, String> queryMap);


    //优惠券列表
    @GET("index.php")
    Observable<CouponListsModel> couponLists(@QueryMap Map<String, String> queryMap);

    //立即购买-预购买
    @GET("index.php")
    Observable<BuyNowModel> buyNow(@QueryMap Map<String, String> queryMap);

    //立即购买
    @POST("index.php")
    Observable<StatusModel> rightBuy(@QueryMap Map<String, String> queryMap);

    //预结算
    @GET("index.php")
    Observable<BuyNowModel> orderCart(@QueryMap Map<String, String> queryMap);

    //结算
    @POST("index.php")
    Observable<StatusModel> rightBuyCart(@QueryMap Map<String, String> queryMap);

    //我的订单
    @GET("index.php")
    Observable<OrderListModel> orderList(@QueryMap Map<String, String> queryMap);

    //拼团详情
    @GET("index.php")
    Observable<SharingGoodsDetailModel> sharingGoodsDetail(@QueryMap Map<String, String> queryMap);

    //拼团规则
    @GET("index.php")
    Observable<GroupRuleModel> groupRule(@QueryMap Map<String, String> queryMap);

    //预开团
    @GET("index.php")
    Observable<BuyNowModel> groupBuy(@QueryMap Map<String, String> queryMap);

    //开团
    @POST("index.php")
    Observable<StatusModel> groupRightBuy(@QueryMap Map<String, String> queryMap);

    //取消订单
    @POST("index.php")
    Observable<StatusModel> orderCancel(@QueryMap Map<String, String> queryMap);

    //确认收货
    @POST("index.php")
    Observable<StatusModel> orderReceipt(@QueryMap Map<String, String> queryMap);

    //订单详情
    @GET("index.php")
    Observable<OrderDetailModel> orderDetail(@QueryMap Map<String, String> queryMap);

    //用户果树详情
    @POST("index.php")
    Observable<UserTreeDetailModel> userTreeDetail(@QueryMap Map<String, String> queryMap);

    //浇水施肥
    @POST("index.php")
    Observable<StatusModel> grow(@QueryMap Map<String, String> queryMap);

    //果树大礼包
    @POST("index.php")
    Observable<TreePacketModel> treePacket(@QueryMap Map<String, String> queryMap);

    //果树证书
    @POST("index.php")
    Observable<CertificateDetailModel> certificateDetail(@QueryMap Map<String, String> queryMap);

    //推广订单
    @POST("index.php")
    Observable<MyPushModel> myPush(@QueryMap Map<String, String> queryMap);

    //付款
    @POST("index.php")
    Observable<StatusModel> orderPay(@QueryMap Map<String, String> queryMap);

    //修改果树名字
    @POST("index.php")
    Observable<StatusModel> nameTree(@QueryMap Map<String, String> queryMap);

    //用户的拼团订单
    @GET("index.php")
    Observable<GroupOrderListModel> groupOrderList(@QueryMap Map<String, String> queryMap);

    //拼单详情
    @GET("index.php")
    Observable<ActiveDetailModel> activeDetail(@QueryMap Map<String, String> queryMap);

    //拼团订单详情
    @GET("index.php")
    Observable<OrderDetailModel> groupOrderDetail(@QueryMap Map<String, String> queryMap);
}
