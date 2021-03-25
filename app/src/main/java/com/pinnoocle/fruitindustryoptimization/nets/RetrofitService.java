package com.pinnoocle.fruitindustryoptimization.nets;

import com.pinnoocle.fruitindustryoptimization.bean.AddressListModel;
import com.pinnoocle.fruitindustryoptimization.bean.BeforeBuyModel;
import com.pinnoocle.fruitindustryoptimization.bean.CartListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.ArticleModel;
import com.pinnoocle.fruitindustryoptimization.bean.BalanceDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.CategoryIndexModel;
import com.pinnoocle.fruitindustryoptimization.bean.CollectModel;
import com.pinnoocle.fruitindustryoptimization.bean.FileInfoModel;
import com.pinnoocle.fruitindustryoptimization.bean.GeneTreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.HomeModel;
import com.pinnoocle.fruitindustryoptimization.bean.ImageModel;
import com.pinnoocle.fruitindustryoptimization.bean.MyBalanceModel;
import com.pinnoocle.fruitindustryoptimization.bean.OrderCartModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreePosterModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreesModel;
import com.pinnoocle.fruitindustryoptimization.bean.WalletModel;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    Observable<StatusModel> modify1(@Body Map<String, String> queryMap);

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

    //预结算
    @GET("index.php")
    Observable<OrderCartModel> orderCart(@QueryMap Map<String, String> queryMap);

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
    @FormUrlEncoded
    @POST("index.php")
    Observable<StatusModel> addressAdd(@Field("s") String s, @Field("wxapp_id") String wxapp_id, @Field("token") String token
            , @Field("name") String name, @Field("phone") String phone, @Field("detail") String detail, @Field("region") String region);

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

    //认养返利
    @POST("index.php")
    Observable<CollectModel> collect(@QueryMap Map<String, String> queryMap);
}
