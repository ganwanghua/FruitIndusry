package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pinnoocle.fruitindustryoptimization.adapter.RawStringJsonAdapter;

import java.util.List;

public class OrderDetailModel {


    /**
     * code : 1
     * msg : success
     * data : {"order":{"order_id":19751,"order_no":"2021040617553454985155","total_price":"776.00","order_price":"776.00","coupon_id":0,"coupon_money":"0.00","points_money":"0.00","points_num":0,"virtual_code":"","virtual_code_money":"0.00","points_exchange_num":0,"pay_price":"776.00","update_price":{"symbol":"+","value":"0.00"},"buyer_remark":"","seller_remark":"","pay_type":{"text":"微信支付","value":20},"pay_status":{"text":"待付款","value":10},"pay_time":0,"delivery_type":{"text":"快递配送","value":10},"extract_shop_id":0,"extract_clerk_id":0,"express_price":"0.00","express_id":0,"express_company":"","express_no":"","delivery_status":{"text":"待发货","value":10},"delivery_time":0,"receipt_status":{"text":"待收货","value":10},"receipt_time":0,"order_status":{"text":"进行中","value":10},"cancel_time":0,"points_bonus":0,"is_settled":0,"transaction_id":"","is_comment":0,"order_source":10,"order_source_id":0,"source_id":0,"user_id":17161,"push_zto":0,"is_delete":0,"create_time":"2021-04-06 17:55:34","user_tree_id":null,"referee_id":0,"referee_money":"0.00","goods_day":"","isAllowRefund":false,"goods":[{"order_goods_id":23330,"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","image_id":25159,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33775,"goods_attr":"","goods_no":"","goods_price":"198.00","line_price":"0.00","goods_weight":0.05,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":2,"total_price":"396.00","total_pay_price":"396.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":19751,"user_id":17161,"image":{"file_id":25159,"storage":"local","group_id":0,"file_url":"","file_name":"20201022130347d14211500.jpg","file_size":393068,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-22 13:03:47","file_path":"http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg"},"sku":{"goods_sku_id":33775,"goods_id":12476,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"198.00","line_price":"0.00","stock_num":1997,"goods_sales":0,"goods_weight":0.05},"goods":{"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","selling_point":"","category_id":10515,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022130425ec9bf6126.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304307f05e4864.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304351b97e0200.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131034ed9d86778.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131043e9ba47164.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221306001b5258996.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":0,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":""},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","goods_sales":0},"refund":null},{"order_goods_id":23331,"goods_id":12453,"goods_name":"兵团大地原味瓜子180g4袋","image_id":24718,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33744,"goods_attr":"","goods_no":"","goods_price":"38.00","line_price":"0.00","goods_weight":0.18,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":10,"total_price":"380.00","total_pay_price":"380.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":19751,"user_id":17161,"image":{"file_id":24718,"storage":"local","group_id":0,"file_url":"","file_name":"202009081902350a5184493.png","file_size":535838,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-09-08 19:02:35","file_path":"http://btys.vshop365.cn/uploads/202009081902350a5184493.png"},"sku":{"goods_sku_id":33744,"goods_id":12453,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"38.00","line_price":"0.00","stock_num":972,"goods_sales":13,"goods_weight":0.18},"goods":{"goods_id":12453,"goods_name":"兵团大地原味瓜子180g4袋","selling_point":"","category_id":10514,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190255719436399.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190255c2ec80043.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081903099929d9094.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190319ae7459538.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190329a9c5e9426.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190341a6bba5460.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190353e04dd2350.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081904070799b7743.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190419882cd3861.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","goods_sales":13},"refund":null}],"address":{"order_address_id":16860,"name":"cc","phone":"13111111111","date_time":0,"province_id":1,"city_id":2,"region_id":3,"detail":"rrr","order_id":19751,"user_id":17161,"region":{"province":"北京市","city":"北京市","region":"东城区"}},"express":null,"extract_shop":null,"state_text":"待付款"},"setting":{"points_name":"积分"}}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * order : {"order_id":19751,"order_no":"2021040617553454985155","total_price":"776.00","order_price":"776.00","coupon_id":0,"coupon_money":"0.00","points_money":"0.00","points_num":0,"virtual_code":"","virtual_code_money":"0.00","points_exchange_num":0,"pay_price":"776.00","update_price":{"symbol":"+","value":"0.00"},"buyer_remark":"","seller_remark":"","pay_type":{"text":"微信支付","value":20},"pay_status":{"text":"待付款","value":10},"pay_time":0,"delivery_type":{"text":"快递配送","value":10},"extract_shop_id":0,"extract_clerk_id":0,"express_price":"0.00","express_id":0,"express_company":"","express_no":"","delivery_status":{"text":"待发货","value":10},"delivery_time":0,"receipt_status":{"text":"待收货","value":10},"receipt_time":0,"order_status":{"text":"进行中","value":10},"cancel_time":0,"points_bonus":0,"is_settled":0,"transaction_id":"","is_comment":0,"order_source":10,"order_source_id":0,"source_id":0,"user_id":17161,"push_zto":0,"is_delete":0,"create_time":"2021-04-06 17:55:34","user_tree_id":null,"referee_id":0,"referee_money":"0.00","goods_day":"","isAllowRefund":false,"goods":[{"order_goods_id":23330,"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","image_id":25159,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33775,"goods_attr":"","goods_no":"","goods_price":"198.00","line_price":"0.00","goods_weight":0.05,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":2,"total_price":"396.00","total_pay_price":"396.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":19751,"user_id":17161,"image":{"file_id":25159,"storage":"local","group_id":0,"file_url":"","file_name":"20201022130347d14211500.jpg","file_size":393068,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-22 13:03:47","file_path":"http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg"},"sku":{"goods_sku_id":33775,"goods_id":12476,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"198.00","line_price":"0.00","stock_num":1997,"goods_sales":0,"goods_weight":0.05},"goods":{"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","selling_point":"","category_id":10515,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022130425ec9bf6126.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304307f05e4864.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304351b97e0200.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131034ed9d86778.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131043e9ba47164.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221306001b5258996.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":0,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":""},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","goods_sales":0},"refund":null},{"order_goods_id":23331,"goods_id":12453,"goods_name":"兵团大地原味瓜子180g4袋","image_id":24718,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33744,"goods_attr":"","goods_no":"","goods_price":"38.00","line_price":"0.00","goods_weight":0.18,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":10,"total_price":"380.00","total_pay_price":"380.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":19751,"user_id":17161,"image":{"file_id":24718,"storage":"local","group_id":0,"file_url":"","file_name":"202009081902350a5184493.png","file_size":535838,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-09-08 19:02:35","file_path":"http://btys.vshop365.cn/uploads/202009081902350a5184493.png"},"sku":{"goods_sku_id":33744,"goods_id":12453,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"38.00","line_price":"0.00","stock_num":972,"goods_sales":13,"goods_weight":0.18},"goods":{"goods_id":12453,"goods_name":"兵团大地原味瓜子180g4袋","selling_point":"","category_id":10514,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190255719436399.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190255c2ec80043.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081903099929d9094.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190319ae7459538.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190329a9c5e9426.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190341a6bba5460.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190353e04dd2350.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081904070799b7743.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190419882cd3861.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","goods_sales":13},"refund":null}],"address":{"order_address_id":16860,"name":"cc","phone":"13111111111","date_time":0,"province_id":1,"city_id":2,"region_id":3,"detail":"rrr","order_id":19751,"user_id":17161,"region":{"province":"北京市","city":"北京市","region":"东城区"}},"express":null,"extract_shop":null,"state_text":"待付款"}
         * setting : {"points_name":"积分"}
         */

        private OrderBean order;
        private SettingBean setting;

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public SettingBean getSetting() {
            return setting;
        }

        public void setSetting(SettingBean setting) {
            this.setting = setting;
        }

        public static class OrderBean {
            /**
             * order_id : 19751
             * order_no : 2021040617553454985155
             * total_price : 776.00
             * order_price : 776.00
             * coupon_id : 0
             * coupon_money : 0.00
             * points_money : 0.00
             * points_num : 0
             * virtual_code :
             * virtual_code_money : 0.00
             * points_exchange_num : 0
             * pay_price : 776.00
             * update_price : {"symbol":"+","value":"0.00"}
             * buyer_remark :
             * seller_remark :
             * pay_type : {"text":"微信支付","value":20}
             * pay_status : {"text":"待付款","value":10}
             * pay_time : 0
             * delivery_type : {"text":"快递配送","value":10}
             * extract_shop_id : 0
             * extract_clerk_id : 0
             * express_price : 0.00
             * express_id : 0
             * express_company :
             * express_no :
             * delivery_status : {"text":"待发货","value":10}
             * delivery_time : 0
             * receipt_status : {"text":"待收货","value":10}
             * receipt_time : 0
             * order_status : {"text":"进行中","value":10}
             * cancel_time : 0
             * points_bonus : 0
             * is_settled : 0
             * transaction_id :
             * is_comment : 0
             * order_source : 10
             * order_source_id : 0
             * source_id : 0
             * user_id : 17161
             * push_zto : 0
             * is_delete : 0
             * create_time : 2021-04-06 17:55:34
             * user_tree_id : null
             * referee_id : 0
             * referee_money : 0.00
             * goods_day :
             * isAllowRefund : false
             * goods : [{"order_goods_id":23330,"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","image_id":25159,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33775,"goods_attr":"","goods_no":"","goods_price":"198.00","line_price":"0.00","goods_weight":0.05,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":2,"total_price":"396.00","total_pay_price":"396.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":19751,"user_id":17161,"image":{"file_id":25159,"storage":"local","group_id":0,"file_url":"","file_name":"20201022130347d14211500.jpg","file_size":393068,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-22 13:03:47","file_path":"http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg"},"sku":{"goods_sku_id":33775,"goods_id":12476,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"198.00","line_price":"0.00","stock_num":1997,"goods_sales":0,"goods_weight":0.05},"goods":{"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","selling_point":"","category_id":10515,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022130425ec9bf6126.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304307f05e4864.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304351b97e0200.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131034ed9d86778.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131043e9ba47164.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221306001b5258996.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":0,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":""},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","goods_sales":0},"refund":null},{"order_goods_id":23331,"goods_id":12453,"goods_name":"兵团大地原味瓜子180g4袋","image_id":24718,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33744,"goods_attr":"","goods_no":"","goods_price":"38.00","line_price":"0.00","goods_weight":0.18,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":10,"total_price":"380.00","total_pay_price":"380.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":19751,"user_id":17161,"image":{"file_id":24718,"storage":"local","group_id":0,"file_url":"","file_name":"202009081902350a5184493.png","file_size":535838,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-09-08 19:02:35","file_path":"http://btys.vshop365.cn/uploads/202009081902350a5184493.png"},"sku":{"goods_sku_id":33744,"goods_id":12453,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"38.00","line_price":"0.00","stock_num":972,"goods_sales":13,"goods_weight":0.18},"goods":{"goods_id":12453,"goods_name":"兵团大地原味瓜子180g4袋","selling_point":"","category_id":10514,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190255719436399.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190255c2ec80043.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081903099929d9094.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190319ae7459538.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190329a9c5e9426.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190341a6bba5460.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190353e04dd2350.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081904070799b7743.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908190419882cd3861.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","goods_sales":13},"refund":null}]
             * address : {"order_address_id":16860,"name":"cc","phone":"13111111111","date_time":0,"province_id":1,"city_id":2,"region_id":3,"detail":"rrr","order_id":19751,"user_id":17161,"region":{"province":"北京市","city":"北京市","region":"东城区"}}
             * express : null
             * extract_shop : null
             * state_text : 待付款
             */

            private int order_id;
            private String order_no;
            private String total_price;
            private String order_price;
            private int coupon_id;
            private String coupon_money;
            private String points_money;
            private int points_num;
            private String virtual_code;
            private String virtual_code_money;
            private int points_exchange_num;
            private String pay_price;
            private UpdatePriceBean update_price;
            private String buyer_remark;
            private String seller_remark;
            private PayTypeBean pay_type;
            private PayStatusBean pay_status;
            private int pay_time;
            private DeliveryTypeBean delivery_type;
            private int extract_shop_id;
            private int extract_clerk_id;
            private String express_price;
            private int express_id;
            private String express_company;
            private String express_no;
            private DeliveryStatusBean delivery_status;
            private int delivery_time;
            private ReceiptStatusBean receipt_status;
            private int receipt_time;
            private OrderStatusBean order_status;
            private int cancel_time;
            private int points_bonus;
            private int is_settled;
            private String transaction_id;
            private int is_comment;
            private int order_source;
            private int order_source_id;
            private int source_id;
            private int user_id;
            private int push_zto;
            private int is_delete;
            private String create_time;
            private Object user_tree_id;
            private int referee_id;
            private String referee_money;
            private String goods_day;
            private boolean isAllowRefund;
            private AddressBean address;
            private Object express;
            private Object extract_shop;
            private String state_text;
            private List<GoodsBeanX> goods;

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public String getOrder_no() {
                return order_no;
            }

            public void setOrder_no(String order_no) {
                this.order_no = order_no;
            }

            public String getTotal_price() {
                return total_price;
            }

            public void setTotal_price(String total_price) {
                this.total_price = total_price;
            }

            public String getOrder_price() {
                return order_price;
            }

            public void setOrder_price(String order_price) {
                this.order_price = order_price;
            }

            public int getCoupon_id() {
                return coupon_id;
            }

            public void setCoupon_id(int coupon_id) {
                this.coupon_id = coupon_id;
            }

            public String getCoupon_money() {
                return coupon_money;
            }

            public void setCoupon_money(String coupon_money) {
                this.coupon_money = coupon_money;
            }

            public String getPoints_money() {
                return points_money;
            }

            public void setPoints_money(String points_money) {
                this.points_money = points_money;
            }

            public int getPoints_num() {
                return points_num;
            }

            public void setPoints_num(int points_num) {
                this.points_num = points_num;
            }

            public String getVirtual_code() {
                return virtual_code;
            }

            public void setVirtual_code(String virtual_code) {
                this.virtual_code = virtual_code;
            }

            public String getVirtual_code_money() {
                return virtual_code_money;
            }

            public void setVirtual_code_money(String virtual_code_money) {
                this.virtual_code_money = virtual_code_money;
            }

            public int getPoints_exchange_num() {
                return points_exchange_num;
            }

            public void setPoints_exchange_num(int points_exchange_num) {
                this.points_exchange_num = points_exchange_num;
            }

            public String getPay_price() {
                return pay_price;
            }

            public void setPay_price(String pay_price) {
                this.pay_price = pay_price;
            }

            public UpdatePriceBean getUpdate_price() {
                return update_price;
            }

            public void setUpdate_price(UpdatePriceBean update_price) {
                this.update_price = update_price;
            }

            public String getBuyer_remark() {
                return buyer_remark;
            }

            public void setBuyer_remark(String buyer_remark) {
                this.buyer_remark = buyer_remark;
            }

            public String getSeller_remark() {
                return seller_remark;
            }

            public void setSeller_remark(String seller_remark) {
                this.seller_remark = seller_remark;
            }

            public PayTypeBean getPay_type() {
                return pay_type;
            }

            public void setPay_type(PayTypeBean pay_type) {
                this.pay_type = pay_type;
            }

            public PayStatusBean getPay_status() {
                return pay_status;
            }

            public void setPay_status(PayStatusBean pay_status) {
                this.pay_status = pay_status;
            }

            public int getPay_time() {
                return pay_time;
            }

            public void setPay_time(int pay_time) {
                this.pay_time = pay_time;
            }

            public DeliveryTypeBean getDelivery_type() {
                return delivery_type;
            }

            public void setDelivery_type(DeliveryTypeBean delivery_type) {
                this.delivery_type = delivery_type;
            }

            public int getExtract_shop_id() {
                return extract_shop_id;
            }

            public void setExtract_shop_id(int extract_shop_id) {
                this.extract_shop_id = extract_shop_id;
            }

            public int getExtract_clerk_id() {
                return extract_clerk_id;
            }

            public void setExtract_clerk_id(int extract_clerk_id) {
                this.extract_clerk_id = extract_clerk_id;
            }

            public String getExpress_price() {
                return express_price;
            }

            public void setExpress_price(String express_price) {
                this.express_price = express_price;
            }

            public int getExpress_id() {
                return express_id;
            }

            public void setExpress_id(int express_id) {
                this.express_id = express_id;
            }

            public String getExpress_company() {
                return express_company;
            }

            public void setExpress_company(String express_company) {
                this.express_company = express_company;
            }

            public String getExpress_no() {
                return express_no;
            }

            public void setExpress_no(String express_no) {
                this.express_no = express_no;
            }

            public DeliveryStatusBean getDelivery_status() {
                return delivery_status;
            }

            public void setDelivery_status(DeliveryStatusBean delivery_status) {
                this.delivery_status = delivery_status;
            }

            public int getDelivery_time() {
                return delivery_time;
            }

            public void setDelivery_time(int delivery_time) {
                this.delivery_time = delivery_time;
            }

            public ReceiptStatusBean getReceipt_status() {
                return receipt_status;
            }

            public void setReceipt_status(ReceiptStatusBean receipt_status) {
                this.receipt_status = receipt_status;
            }

            public int getReceipt_time() {
                return receipt_time;
            }

            public void setReceipt_time(int receipt_time) {
                this.receipt_time = receipt_time;
            }

            public OrderStatusBean getOrder_status() {
                return order_status;
            }

            public void setOrder_status(OrderStatusBean order_status) {
                this.order_status = order_status;
            }

            public int getCancel_time() {
                return cancel_time;
            }

            public void setCancel_time(int cancel_time) {
                this.cancel_time = cancel_time;
            }

            public int getPoints_bonus() {
                return points_bonus;
            }

            public void setPoints_bonus(int points_bonus) {
                this.points_bonus = points_bonus;
            }

            public int getIs_settled() {
                return is_settled;
            }

            public void setIs_settled(int is_settled) {
                this.is_settled = is_settled;
            }

            public String getTransaction_id() {
                return transaction_id;
            }

            public void setTransaction_id(String transaction_id) {
                this.transaction_id = transaction_id;
            }

            public int getIs_comment() {
                return is_comment;
            }

            public void setIs_comment(int is_comment) {
                this.is_comment = is_comment;
            }

            public int getOrder_source() {
                return order_source;
            }

            public void setOrder_source(int order_source) {
                this.order_source = order_source;
            }

            public int getOrder_source_id() {
                return order_source_id;
            }

            public void setOrder_source_id(int order_source_id) {
                this.order_source_id = order_source_id;
            }

            public int getSource_id() {
                return source_id;
            }

            public void setSource_id(int source_id) {
                this.source_id = source_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getPush_zto() {
                return push_zto;
            }

            public void setPush_zto(int push_zto) {
                this.push_zto = push_zto;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getUser_tree_id() {
                return user_tree_id;
            }

            public void setUser_tree_id(Object user_tree_id) {
                this.user_tree_id = user_tree_id;
            }

            public int getReferee_id() {
                return referee_id;
            }

            public void setReferee_id(int referee_id) {
                this.referee_id = referee_id;
            }

            public String getReferee_money() {
                return referee_money;
            }

            public void setReferee_money(String referee_money) {
                this.referee_money = referee_money;
            }

            public String getGoods_day() {
                return goods_day;
            }

            public void setGoods_day(String goods_day) {
                this.goods_day = goods_day;
            }

            public boolean isIsAllowRefund() {
                return isAllowRefund;
            }

            public void setIsAllowRefund(boolean isAllowRefund) {
                this.isAllowRefund = isAllowRefund;
            }

            public AddressBean getAddress() {
                return address;
            }

            public void setAddress(AddressBean address) {
                this.address = address;
            }

            public Object getExpress() {
                return express;
            }

            public void setExpress(Object express) {
                this.express = express;
            }

            public Object getExtract_shop() {
                return extract_shop;
            }

            public void setExtract_shop(Object extract_shop) {
                this.extract_shop = extract_shop;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public List<GoodsBeanX> getGoods() {
                return goods;
            }

            public void setGoods(List<GoodsBeanX> goods) {
                this.goods = goods;
            }

            public static class UpdatePriceBean {
                /**
                 * symbol : +
                 * value : 0.00
                 */

                private String symbol;
                private String value;

                public String getSymbol() {
                    return symbol;
                }

                public void setSymbol(String symbol) {
                    this.symbol = symbol;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class PayTypeBean {
                /**
                 * text : 微信支付
                 * value : 20
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class PayStatusBean {
                /**
                 * text : 待付款
                 * value : 10
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class DeliveryTypeBean {
                /**
                 * text : 快递配送
                 * value : 10
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class DeliveryStatusBean {
                /**
                 * text : 待发货
                 * value : 10
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class ReceiptStatusBean {
                /**
                 * text : 待收货
                 * value : 10
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class OrderStatusBean {
                /**
                 * text : 进行中
                 * value : 10
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class AddressBean {
                /**
                 * order_address_id : 16860
                 * name : cc
                 * phone : 13111111111
                 * date_time : 0
                 * province_id : 1
                 * city_id : 2
                 * region_id : 3
                 * detail : rrr
                 * order_id : 19751
                 * user_id : 17161
                 * region : {"province":"北京市","city":"北京市","region":"东城区"}
                 */

                private int order_address_id;
                private String name;
                private String phone;
                private int date_time;
                private int province_id;
                private int city_id;
                private int region_id;
                private String detail;
                private int order_id;
                private int user_id;
                private RegionBean region;

                public int getOrder_address_id() {
                    return order_address_id;
                }

                public void setOrder_address_id(int order_address_id) {
                    this.order_address_id = order_address_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public int getDate_time() {
                    return date_time;
                }

                public void setDate_time(int date_time) {
                    this.date_time = date_time;
                }

                public int getProvince_id() {
                    return province_id;
                }

                public void setProvince_id(int province_id) {
                    this.province_id = province_id;
                }

                public int getCity_id() {
                    return city_id;
                }

                public void setCity_id(int city_id) {
                    this.city_id = city_id;
                }

                public int getRegion_id() {
                    return region_id;
                }

                public void setRegion_id(int region_id) {
                    this.region_id = region_id;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public int getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(int order_id) {
                    this.order_id = order_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public RegionBean getRegion() {
                    return region;
                }

                public void setRegion(RegionBean region) {
                    this.region = region;
                }

                public static class RegionBean {
                    /**
                     * province : 北京市
                     * city : 北京市
                     * region : 东城区
                     */

                    private String province;
                    private String city;
                    private String region;

                    public String getProvince() {
                        return province;
                    }

                    public void setProvince(String province) {
                        this.province = province;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getRegion() {
                        return region;
                    }

                    public void setRegion(String region) {
                        this.region = region;
                    }
                }
            }

            public static class GoodsBeanX {
                /**
                 * order_goods_id : 23330
                 * goods_id : 12476
                 * goods_name : 团团兵红花籽油2*500ml
                 * image_id : 25159
                 * deduct_stock_type : 10
                 * spec_type : 10
                 * spec_sku_id : 0
                 * goods_sku_id : 33775
                 * goods_attr :
                 * goods_no :
                 * goods_price : 198.00
                 * line_price : 0.00
                 * goods_weight : 0.05
                 * is_user_grade : 0
                 * grade_ratio : 0
                 * grade_goods_price : 0.00
                 * grade_total_money : 0.00
                 * coupon_money : 0.00
                 * points_money : 0.00
                 * points_num : 0
                 * points_bonus : 0
                 * virtual_code_money : 0.00
                 * exchange_points_num : 0
                 * exchange_points_money : 0.00
                 * total_num : 2
                 * total_price : 396.00
                 * total_pay_price : 396.00
                 * is_ind_dealer : 1
                 * dealer_money_type : 1
                 * first_money : 0.00
                 * second_money : 0.00
                 * third_money : 0.00
                 * is_comment : 0
                 * order_id : 19751
                 * user_id : 17161
                 * image : {"file_id":25159,"storage":"local","group_id":0,"file_url":"","file_name":"20201022130347d14211500.jpg","file_size":393068,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-22 13:03:47","file_path":"http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg"}
                 * sku : {"goods_sku_id":33775,"goods_id":12476,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"198.00","line_price":"0.00","stock_num":1997,"goods_sales":0,"goods_weight":0.05}
                 * goods : {"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","selling_point":"","category_id":10515,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022130425ec9bf6126.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304307f05e4864.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304351b97e0200.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131034ed9d86778.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131043e9ba47164.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221306001b5258996.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":0,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":""},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","goods_sales":0}
                 * refund : null
                 */

                private int order_goods_id;
                private int goods_id;
                private String goods_name;
                private int image_id;
                private int deduct_stock_type;
                private int spec_type;
                private String spec_sku_id;
                private int goods_sku_id;
                private String goods_attr;
                private String goods_no;
                private String goods_price;
                private String line_price;
                private double goods_weight;
                private int is_user_grade;
                private int grade_ratio;
                private String grade_goods_price;
                private String grade_total_money;
                private String coupon_money;
                private String points_money;
                private int points_num;
                private int points_bonus;
                private String virtual_code_money;
                private int exchange_points_num;
                private String exchange_points_money;
                private int total_num;
                private String total_price;
                private String total_pay_price;
                private int is_ind_dealer;
                private int dealer_money_type;
                private String first_money;
                private String second_money;
                private String third_money;
                private int is_comment;
                private int order_id;
                private int user_id;
                private ImageBean image;
                private SkuBean sku;
                private GoodsBean goods;
                @SerializedName("refund")
                @JsonAdapter(RawStringJsonAdapter.class)
                private String refund;

                public int getOrder_goods_id() {
                    return order_goods_id;
                }

                public void setOrder_goods_id(int order_goods_id) {
                    this.order_goods_id = order_goods_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public int getDeduct_stock_type() {
                    return deduct_stock_type;
                }

                public void setDeduct_stock_type(int deduct_stock_type) {
                    this.deduct_stock_type = deduct_stock_type;
                }

                public int getSpec_type() {
                    return spec_type;
                }

                public void setSpec_type(int spec_type) {
                    this.spec_type = spec_type;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public String getGoods_attr() {
                    return goods_attr;
                }

                public void setGoods_attr(String goods_attr) {
                    this.goods_attr = goods_attr;
                }

                public String getGoods_no() {
                    return goods_no;
                }

                public void setGoods_no(String goods_no) {
                    this.goods_no = goods_no;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getLine_price() {
                    return line_price;
                }

                public void setLine_price(String line_price) {
                    this.line_price = line_price;
                }

                public double getGoods_weight() {
                    return goods_weight;
                }

                public void setGoods_weight(double goods_weight) {
                    this.goods_weight = goods_weight;
                }

                public int getIs_user_grade() {
                    return is_user_grade;
                }

                public void setIs_user_grade(int is_user_grade) {
                    this.is_user_grade = is_user_grade;
                }

                public int getGrade_ratio() {
                    return grade_ratio;
                }

                public void setGrade_ratio(int grade_ratio) {
                    this.grade_ratio = grade_ratio;
                }

                public String getGrade_goods_price() {
                    return grade_goods_price;
                }

                public void setGrade_goods_price(String grade_goods_price) {
                    this.grade_goods_price = grade_goods_price;
                }

                public String getGrade_total_money() {
                    return grade_total_money;
                }

                public void setGrade_total_money(String grade_total_money) {
                    this.grade_total_money = grade_total_money;
                }

                public String getCoupon_money() {
                    return coupon_money;
                }

                public void setCoupon_money(String coupon_money) {
                    this.coupon_money = coupon_money;
                }

                public String getPoints_money() {
                    return points_money;
                }

                public void setPoints_money(String points_money) {
                    this.points_money = points_money;
                }

                public int getPoints_num() {
                    return points_num;
                }

                public void setPoints_num(int points_num) {
                    this.points_num = points_num;
                }

                public int getPoints_bonus() {
                    return points_bonus;
                }

                public void setPoints_bonus(int points_bonus) {
                    this.points_bonus = points_bonus;
                }

                public String getVirtual_code_money() {
                    return virtual_code_money;
                }

                public void setVirtual_code_money(String virtual_code_money) {
                    this.virtual_code_money = virtual_code_money;
                }

                public int getExchange_points_num() {
                    return exchange_points_num;
                }

                public void setExchange_points_num(int exchange_points_num) {
                    this.exchange_points_num = exchange_points_num;
                }

                public String getExchange_points_money() {
                    return exchange_points_money;
                }

                public void setExchange_points_money(String exchange_points_money) {
                    this.exchange_points_money = exchange_points_money;
                }

                public int getTotal_num() {
                    return total_num;
                }

                public void setTotal_num(int total_num) {
                    this.total_num = total_num;
                }

                public String getTotal_price() {
                    return total_price;
                }

                public void setTotal_price(String total_price) {
                    this.total_price = total_price;
                }

                public String getTotal_pay_price() {
                    return total_pay_price;
                }

                public void setTotal_pay_price(String total_pay_price) {
                    this.total_pay_price = total_pay_price;
                }

                public int getIs_ind_dealer() {
                    return is_ind_dealer;
                }

                public void setIs_ind_dealer(int is_ind_dealer) {
                    this.is_ind_dealer = is_ind_dealer;
                }

                public int getDealer_money_type() {
                    return dealer_money_type;
                }

                public void setDealer_money_type(int dealer_money_type) {
                    this.dealer_money_type = dealer_money_type;
                }

                public String getFirst_money() {
                    return first_money;
                }

                public void setFirst_money(String first_money) {
                    this.first_money = first_money;
                }

                public String getSecond_money() {
                    return second_money;
                }

                public void setSecond_money(String second_money) {
                    this.second_money = second_money;
                }

                public String getThird_money() {
                    return third_money;
                }

                public void setThird_money(String third_money) {
                    this.third_money = third_money;
                }

                public int getIs_comment() {
                    return is_comment;
                }

                public void setIs_comment(int is_comment) {
                    this.is_comment = is_comment;
                }

                public int getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(int order_id) {
                    this.order_id = order_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public ImageBean getImage() {
                    return image;
                }

                public void setImage(ImageBean image) {
                    this.image = image;
                }

                public SkuBean getSku() {
                    return sku;
                }

                public void setSku(SkuBean sku) {
                    this.sku = sku;
                }

                public GoodsBean getGoods() {
                    return goods;
                }

                public void setGoods(GoodsBean goods) {
                    this.goods = goods;
                }

                public String getRefund() {
                    return refund;
                }

                public void setRefund(String refund) {
                    this.refund = refund;
                }

                public static class ImageBean {
                    /**
                     * file_id : 25159
                     * storage : local
                     * group_id : 0
                     * file_url :
                     * file_name : 20201022130347d14211500.jpg
                     * file_size : 393068
                     * file_type : image
                     * extension : jpg
                     * is_user : 0
                     * is_recycle : 0
                     * is_delete : 0
                     * wxapp_id : 10001
                     * create_time : 2020-10-22 13:03:47
                     * file_path : http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg
                     */

                    private int file_id;
                    private String storage;
                    private int group_id;
                    private String file_url;
                    private String file_name;
                    private int file_size;
                    private String file_type;
                    private String extension;
                    private int is_user;
                    private int is_recycle;
                    private int is_delete;
                    private int wxapp_id;
                    private String create_time;
                    private String file_path;

                    public int getFile_id() {
                        return file_id;
                    }

                    public void setFile_id(int file_id) {
                        this.file_id = file_id;
                    }

                    public String getStorage() {
                        return storage;
                    }

                    public void setStorage(String storage) {
                        this.storage = storage;
                    }

                    public int getGroup_id() {
                        return group_id;
                    }

                    public void setGroup_id(int group_id) {
                        this.group_id = group_id;
                    }

                    public String getFile_url() {
                        return file_url;
                    }

                    public void setFile_url(String file_url) {
                        this.file_url = file_url;
                    }

                    public String getFile_name() {
                        return file_name;
                    }

                    public void setFile_name(String file_name) {
                        this.file_name = file_name;
                    }

                    public int getFile_size() {
                        return file_size;
                    }

                    public void setFile_size(int file_size) {
                        this.file_size = file_size;
                    }

                    public String getFile_type() {
                        return file_type;
                    }

                    public void setFile_type(String file_type) {
                        this.file_type = file_type;
                    }

                    public String getExtension() {
                        return extension;
                    }

                    public void setExtension(String extension) {
                        this.extension = extension;
                    }

                    public int getIs_user() {
                        return is_user;
                    }

                    public void setIs_user(int is_user) {
                        this.is_user = is_user;
                    }

                    public int getIs_recycle() {
                        return is_recycle;
                    }

                    public void setIs_recycle(int is_recycle) {
                        this.is_recycle = is_recycle;
                    }

                    public int getIs_delete() {
                        return is_delete;
                    }

                    public void setIs_delete(int is_delete) {
                        this.is_delete = is_delete;
                    }

                    public int getWxapp_id() {
                        return wxapp_id;
                    }

                    public void setWxapp_id(int wxapp_id) {
                        this.wxapp_id = wxapp_id;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getFile_path() {
                        return file_path;
                    }

                    public void setFile_path(String file_path) {
                        this.file_path = file_path;
                    }
                }

                public static class SkuBean {
                    /**
                     * goods_sku_id : 33775
                     * goods_id : 12476
                     * spec_sku_id : 0
                     * image_id : 0
                     * goods_no :
                     * balance_price : 0.00
                     * goods_price : 198.00
                     * line_price : 0.00
                     * stock_num : 1997
                     * goods_sales : 0
                     * goods_weight : 0.05
                     */

                    private int goods_sku_id;
                    private int goods_id;
                    private String spec_sku_id;
                    private int image_id;
                    private String goods_no;
                    private String balance_price;
                    private String goods_price;
                    private String line_price;
                    private int stock_num;
                    private int goods_sales;
                    private double goods_weight;

                    public int getGoods_sku_id() {
                        return goods_sku_id;
                    }

                    public void setGoods_sku_id(int goods_sku_id) {
                        this.goods_sku_id = goods_sku_id;
                    }

                    public int getGoods_id() {
                        return goods_id;
                    }

                    public void setGoods_id(int goods_id) {
                        this.goods_id = goods_id;
                    }

                    public String getSpec_sku_id() {
                        return spec_sku_id;
                    }

                    public void setSpec_sku_id(String spec_sku_id) {
                        this.spec_sku_id = spec_sku_id;
                    }

                    public int getImage_id() {
                        return image_id;
                    }

                    public void setImage_id(int image_id) {
                        this.image_id = image_id;
                    }

                    public String getGoods_no() {
                        return goods_no;
                    }

                    public void setGoods_no(String goods_no) {
                        this.goods_no = goods_no;
                    }

                    public String getBalance_price() {
                        return balance_price;
                    }

                    public void setBalance_price(String balance_price) {
                        this.balance_price = balance_price;
                    }

                    public String getGoods_price() {
                        return goods_price;
                    }

                    public void setGoods_price(String goods_price) {
                        this.goods_price = goods_price;
                    }

                    public String getLine_price() {
                        return line_price;
                    }

                    public void setLine_price(String line_price) {
                        this.line_price = line_price;
                    }

                    public int getStock_num() {
                        return stock_num;
                    }

                    public void setStock_num(int stock_num) {
                        this.stock_num = stock_num;
                    }

                    public int getGoods_sales() {
                        return goods_sales;
                    }

                    public void setGoods_sales(int goods_sales) {
                        this.goods_sales = goods_sales;
                    }

                    public double getGoods_weight() {
                        return goods_weight;
                    }

                    public void setGoods_weight(double goods_weight) {
                        this.goods_weight = goods_weight;
                    }
                }

                public static class GoodsBean {
                    /**
                     * goods_id : 12476
                     * goods_name : 团团兵红花籽油2*500ml
                     * selling_point :
                     * category_id : 10515
                     * spec_type : 10
                     * deduct_stock_type : 10
                     * content : &lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022130425ec9bf6126.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304307f05e4864.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221304351b97e0200.png&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131034ed9d86778.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201022131043e9ba47164.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010221306001b5258996.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;
                     * goods_sort : 100
                     * buy_limit : 0
                     * least_expend_money : 0.00
                     * delivery_id : 10001
                     * is_new_user_enjoy : 0
                     * is_points_gift : 0
                     * is_points_discount : 0
                     * is_enable_balance_price : 0
                     * is_enable_grade : 1
                     * is_alone_grade : 0
                     * alone_grade_equity : {"1":"","2":""}
                     * is_ind_dealer : 1
                     * dealer_money_type : 1
                     * first_money : 0.00
                     * second_money : 0.00
                     * third_money : 0.00
                     * is_rush : 0
                     * is_points_exchange : 0
                     * need_points_num : 0
                     * need_points_money : 0.00
                     * goods_status : {"text":"上架","value":10}
                     * is_packet : 0
                     * is_checked : 1
                     * video :
                     * goods_sales : 0
                     */

                    private int goods_id;
                    private String goods_name;
                    private String selling_point;
                    private int category_id;
                    private int spec_type;
                    private int deduct_stock_type;
                    private String content;
                    private int goods_sort;
                    private int buy_limit;
                    private String least_expend_money;
                    private int delivery_id;
                    private int is_new_user_enjoy;
                    private int is_points_gift;
                    private int is_points_discount;
                    private int is_enable_balance_price;
                    private int is_enable_grade;
                    private int is_alone_grade;
                    private AloneGradeEquityBean alone_grade_equity;
                    private int is_ind_dealer;
                    private int dealer_money_type;
                    private String first_money;
                    private String second_money;
                    private String third_money;
                    private int is_rush;
                    private int is_points_exchange;
                    private int need_points_num;
                    private String need_points_money;
                    private GoodsStatusBean goods_status;
                    private int is_packet;
                    private int is_checked;
                    private String video;
                    private int goods_sales;

                    public int getGoods_id() {
                        return goods_id;
                    }

                    public void setGoods_id(int goods_id) {
                        this.goods_id = goods_id;
                    }

                    public String getGoods_name() {
                        return goods_name;
                    }

                    public void setGoods_name(String goods_name) {
                        this.goods_name = goods_name;
                    }

                    public String getSelling_point() {
                        return selling_point;
                    }

                    public void setSelling_point(String selling_point) {
                        this.selling_point = selling_point;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public int getSpec_type() {
                        return spec_type;
                    }

                    public void setSpec_type(int spec_type) {
                        this.spec_type = spec_type;
                    }

                    public int getDeduct_stock_type() {
                        return deduct_stock_type;
                    }

                    public void setDeduct_stock_type(int deduct_stock_type) {
                        this.deduct_stock_type = deduct_stock_type;
                    }

                    public String getContent() {
                        return content;
                    }

                    public void setContent(String content) {
                        this.content = content;
                    }

                    public int getGoods_sort() {
                        return goods_sort;
                    }

                    public void setGoods_sort(int goods_sort) {
                        this.goods_sort = goods_sort;
                    }

                    public int getBuy_limit() {
                        return buy_limit;
                    }

                    public void setBuy_limit(int buy_limit) {
                        this.buy_limit = buy_limit;
                    }

                    public String getLeast_expend_money() {
                        return least_expend_money;
                    }

                    public void setLeast_expend_money(String least_expend_money) {
                        this.least_expend_money = least_expend_money;
                    }

                    public int getDelivery_id() {
                        return delivery_id;
                    }

                    public void setDelivery_id(int delivery_id) {
                        this.delivery_id = delivery_id;
                    }

                    public int getIs_new_user_enjoy() {
                        return is_new_user_enjoy;
                    }

                    public void setIs_new_user_enjoy(int is_new_user_enjoy) {
                        this.is_new_user_enjoy = is_new_user_enjoy;
                    }

                    public int getIs_points_gift() {
                        return is_points_gift;
                    }

                    public void setIs_points_gift(int is_points_gift) {
                        this.is_points_gift = is_points_gift;
                    }

                    public int getIs_points_discount() {
                        return is_points_discount;
                    }

                    public void setIs_points_discount(int is_points_discount) {
                        this.is_points_discount = is_points_discount;
                    }

                    public int getIs_enable_balance_price() {
                        return is_enable_balance_price;
                    }

                    public void setIs_enable_balance_price(int is_enable_balance_price) {
                        this.is_enable_balance_price = is_enable_balance_price;
                    }

                    public int getIs_enable_grade() {
                        return is_enable_grade;
                    }

                    public void setIs_enable_grade(int is_enable_grade) {
                        this.is_enable_grade = is_enable_grade;
                    }

                    public int getIs_alone_grade() {
                        return is_alone_grade;
                    }

                    public void setIs_alone_grade(int is_alone_grade) {
                        this.is_alone_grade = is_alone_grade;
                    }

                    public AloneGradeEquityBean getAlone_grade_equity() {
                        return alone_grade_equity;
                    }

                    public void setAlone_grade_equity(AloneGradeEquityBean alone_grade_equity) {
                        this.alone_grade_equity = alone_grade_equity;
                    }

                    public int getIs_ind_dealer() {
                        return is_ind_dealer;
                    }

                    public void setIs_ind_dealer(int is_ind_dealer) {
                        this.is_ind_dealer = is_ind_dealer;
                    }

                    public int getDealer_money_type() {
                        return dealer_money_type;
                    }

                    public void setDealer_money_type(int dealer_money_type) {
                        this.dealer_money_type = dealer_money_type;
                    }

                    public String getFirst_money() {
                        return first_money;
                    }

                    public void setFirst_money(String first_money) {
                        this.first_money = first_money;
                    }

                    public String getSecond_money() {
                        return second_money;
                    }

                    public void setSecond_money(String second_money) {
                        this.second_money = second_money;
                    }

                    public String getThird_money() {
                        return third_money;
                    }

                    public void setThird_money(String third_money) {
                        this.third_money = third_money;
                    }

                    public int getIs_rush() {
                        return is_rush;
                    }

                    public void setIs_rush(int is_rush) {
                        this.is_rush = is_rush;
                    }

                    public int getIs_points_exchange() {
                        return is_points_exchange;
                    }

                    public void setIs_points_exchange(int is_points_exchange) {
                        this.is_points_exchange = is_points_exchange;
                    }

                    public int getNeed_points_num() {
                        return need_points_num;
                    }

                    public void setNeed_points_num(int need_points_num) {
                        this.need_points_num = need_points_num;
                    }

                    public String getNeed_points_money() {
                        return need_points_money;
                    }

                    public void setNeed_points_money(String need_points_money) {
                        this.need_points_money = need_points_money;
                    }

                    public GoodsStatusBean getGoods_status() {
                        return goods_status;
                    }

                    public void setGoods_status(GoodsStatusBean goods_status) {
                        this.goods_status = goods_status;
                    }

                    public int getIs_packet() {
                        return is_packet;
                    }

                    public void setIs_packet(int is_packet) {
                        this.is_packet = is_packet;
                    }

                    public int getIs_checked() {
                        return is_checked;
                    }

                    public void setIs_checked(int is_checked) {
                        this.is_checked = is_checked;
                    }

                    public String getVideo() {
                        return video;
                    }

                    public void setVideo(String video) {
                        this.video = video;
                    }

                    public int getGoods_sales() {
                        return goods_sales;
                    }

                    public void setGoods_sales(int goods_sales) {
                        this.goods_sales = goods_sales;
                    }

                    public static class AloneGradeEquityBean {
                        /**
                         * 1 :
                         * 2 :
                         */

                        @SerializedName("1")
                        private String _$1;
                        @SerializedName("2")
                        private String _$2;

                        public String get_$1() {
                            return _$1;
                        }

                        public void set_$1(String _$1) {
                            this._$1 = _$1;
                        }

                        public String get_$2() {
                            return _$2;
                        }

                        public void set_$2(String _$2) {
                            this._$2 = _$2;
                        }
                    }

                    public static class GoodsStatusBean {
                        /**
                         * text : 上架
                         * value : 10
                         */

                        private String text;
                        private int value;

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public int getValue() {
                            return value;
                        }

                        public void setValue(int value) {
                            this.value = value;
                        }
                    }
                }
            }
        }

        public static class SettingBean {
            /**
             * points_name : 积分
             */

            private String points_name;

            public String getPoints_name() {
                return points_name;
            }

            public void setPoints_name(String points_name) {
                this.points_name = points_name;
            }
        }
    }
}
