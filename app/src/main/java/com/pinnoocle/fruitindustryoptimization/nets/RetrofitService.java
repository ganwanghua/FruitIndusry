package com.pinnoocle.fruitindustryoptimization.nets;

import com.pinnoocle.fruitindustryoptimization.bean.CartListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.ArticleModel;
import com.pinnoocle.fruitindustryoptimization.bean.BalanceDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.CategoryIndexModel;
import com.pinnoocle.fruitindustryoptimization.bean.HomeModel;
import com.pinnoocle.fruitindustryoptimization.bean.ImageModel;
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
    @GET("index.php")
    Observable<StatusModel> cartDelete(@QueryMap Map<String, String> queryMap);

    //用户果树列表
    @GET("index.php")
    Observable<UserTreesModel> userTrees(@QueryMap Map<String, String> queryMap);

    //果树列表
    @GET("index.php")
    Observable<TreesModel> trees(@QueryMap Map<String, String> queryMap);

    //果树详情
    @GET("index.php")
    Observable<TreesDetailModel> treesDetail(@QueryMap Map<String, String> queryMap);
}
