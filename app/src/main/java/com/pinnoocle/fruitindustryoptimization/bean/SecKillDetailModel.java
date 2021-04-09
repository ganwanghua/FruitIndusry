package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SecKillDetailModel {

    /**
     * code : 1
     * msg : success
     * data : {"active":{"active_id":5,"goods_id":12474,"start_time":"2021-04-09 00:00:00","end_time":"2021-04-30 00:00:00","expiryt_time":12,"floor_price":"8.00","is_floor_buy":1,"share_title":"麻烦帮我砍一刀！我真的很想要了，爱你哟！(๑\u2032ᴗ\u2035๑)","prompt_words":"\"朋友一生一起走，助力一刀有没有\"","status":1,"is_start":true,"is_end":false,"active_sales":11},"goods":{"goods_id":12474,"goods_name":"兵团大地无核白葡萄干120g","selling_point":"货源火爆预定中！提早下单，优先备货！","category_id":10511,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251617541cf637680.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251618085c6b40407.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516182050a454122.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925161832340a06813.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516184569ab33882.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162708d8cc22500.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162723e24652228.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516273526e307024.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251627453c8201979.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162800a25888730.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251628133417d7552.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251628249c8d06587.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162834474ac0258.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":""},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","comment_data_count":0,"goods_stock":2297,"goods_image":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","goods_sku":{"goods_sku_id":33762,"goods_id":12474,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2297,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null,"is_user_grade":false,"bought_num":0,"category":{"category_id":10511,"name":"干果","parent_id":0,"image_id":0,"sort":10,"create_time":"2020-09-08 17:47:37"},"image":[{"id":30616,"goods_id":12474,"image_id":24979,"file_path":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","file_name":"20200925161332e88273839.jpg","file_url":""},{"id":30617,"goods_id":12474,"image_id":24980,"file_path":"http://btys.vshop365.cn/uploads/20200925161645a82a86575.png","file_name":"20200925161645a82a86575.png","file_url":""}],"sku":[{"goods_sku_id":33762,"goods_id":12474,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2297,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"9.90","image":null}],"comment_data":[],"goods_sales":4},"setting":{"bargain_rules":"活动期间，用户发起秒杀，邀请好友助力达到人数即可使用秒杀价进行购买"},"is_partake":false,"task_id":0}
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
         * active : {"active_id":5,"goods_id":12474,"start_time":"2021-04-09 00:00:00","end_time":"2021-04-30 00:00:00","expiryt_time":12,"floor_price":"8.00","is_floor_buy":1,"share_title":"麻烦帮我砍一刀！我真的很想要了，爱你哟！(๑\u2032ᴗ\u2035๑)","prompt_words":"\"朋友一生一起走，助力一刀有没有\"","status":1,"is_start":true,"is_end":false,"active_sales":11}
         * goods : {"goods_id":12474,"goods_name":"兵团大地无核白葡萄干120g","selling_point":"货源火爆预定中！提早下单，优先备货！","category_id":10511,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251617541cf637680.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251618085c6b40407.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516182050a454122.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925161832340a06813.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516184569ab33882.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162708d8cc22500.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162723e24652228.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516273526e307024.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251627453c8201979.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162800a25888730.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251628133417d7552.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251628249c8d06587.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162834474ac0258.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":""},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","comment_data_count":0,"goods_stock":2297,"goods_image":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","goods_sku":{"goods_sku_id":33762,"goods_id":12474,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2297,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null,"is_user_grade":false,"bought_num":0,"category":{"category_id":10511,"name":"干果","parent_id":0,"image_id":0,"sort":10,"create_time":"2020-09-08 17:47:37"},"image":[{"id":30616,"goods_id":12474,"image_id":24979,"file_path":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","file_name":"20200925161332e88273839.jpg","file_url":""},{"id":30617,"goods_id":12474,"image_id":24980,"file_path":"http://btys.vshop365.cn/uploads/20200925161645a82a86575.png","file_name":"20200925161645a82a86575.png","file_url":""}],"sku":[{"goods_sku_id":33762,"goods_id":12474,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2297,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"9.90","image":null}],"comment_data":[],"goods_sales":4}
         * setting : {"bargain_rules":"活动期间，用户发起秒杀，邀请好友助力达到人数即可使用秒杀价进行购买"}
         * is_partake : false
         * task_id : 0
         */

        private ActiveBean active;
        private GoodsBean goods;
        private SettingBean setting;
        private boolean is_partake;
        private int task_id;

        public ActiveBean getActive() {
            return active;
        }

        public void setActive(ActiveBean active) {
            this.active = active;
        }

        public GoodsBean getGoods() {
            return goods;
        }

        public void setGoods(GoodsBean goods) {
            this.goods = goods;
        }

        public SettingBean getSetting() {
            return setting;
        }

        public void setSetting(SettingBean setting) {
            this.setting = setting;
        }

        public boolean isIs_partake() {
            return is_partake;
        }

        public void setIs_partake(boolean is_partake) {
            this.is_partake = is_partake;
        }

        public int getTask_id() {
            return task_id;
        }

        public void setTask_id(int task_id) {
            this.task_id = task_id;
        }

        public static class ActiveBean {
            /**
             * active_id : 5
             * goods_id : 12474
             * start_time : 2021-04-09 00:00:00
             * end_time : 2021-04-30 00:00:00
             * expiryt_time : 12
             * floor_price : 8.00
             * is_floor_buy : 1
             * share_title : 麻烦帮我砍一刀！我真的很想要了，爱你哟！(๑′ᴗ‵๑)
             * prompt_words : "朋友一生一起走，助力一刀有没有"
             * status : 1
             * is_start : true
             * is_end : false
             * active_sales : 11
             */

            private int active_id;
            private int goods_id;
            private String start_time;
            private String end_time;
            private int expiryt_time;
            private String floor_price;
            private int is_floor_buy;
            private String share_title;
            private String prompt_words;
            private int status;
            private boolean is_start;
            private boolean is_end;
            private int active_sales;

            public int getActive_id() {
                return active_id;
            }

            public void setActive_id(int active_id) {
                this.active_id = active_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public int getExpiryt_time() {
                return expiryt_time;
            }

            public void setExpiryt_time(int expiryt_time) {
                this.expiryt_time = expiryt_time;
            }

            public String getFloor_price() {
                return floor_price;
            }

            public void setFloor_price(String floor_price) {
                this.floor_price = floor_price;
            }

            public int getIs_floor_buy() {
                return is_floor_buy;
            }

            public void setIs_floor_buy(int is_floor_buy) {
                this.is_floor_buy = is_floor_buy;
            }

            public String getShare_title() {
                return share_title;
            }

            public void setShare_title(String share_title) {
                this.share_title = share_title;
            }

            public String getPrompt_words() {
                return prompt_words;
            }

            public void setPrompt_words(String prompt_words) {
                this.prompt_words = prompt_words;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public boolean isIs_start() {
                return is_start;
            }

            public void setIs_start(boolean is_start) {
                this.is_start = is_start;
            }

            public boolean isIs_end() {
                return is_end;
            }

            public void setIs_end(boolean is_end) {
                this.is_end = is_end;
            }

            public int getActive_sales() {
                return active_sales;
            }

            public void setActive_sales(int active_sales) {
                this.active_sales = active_sales;
            }
        }

        public static class GoodsBean {
            /**
             * goods_id : 12474
             * goods_name : 兵团大地无核白葡萄干120g
             * selling_point : 货源火爆预定中！提早下单，优先备货！
             * category_id : 10511
             * spec_type : 10
             * deduct_stock_type : 10
             * content : &lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251617541cf637680.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251618085c6b40407.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516182050a454122.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925161832340a06813.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516184569ab33882.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162708d8cc22500.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162723e24652228.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020092516273526e307024.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251627453c8201979.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162800a25888730.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251628133417d7552.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009251628249c8d06587.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200925162834474ac0258.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;
             * goods_sort : 100
             * buy_limit : 0
             * least_expend_money : 0.00
             * delivery_id : 10001
             * is_new_user_enjoy : 0
             * is_points_gift : 1
             * is_points_discount : 1
             * is_enable_balance_price : 0
             * is_enable_grade : 1
             * is_alone_grade : 0
             * alone_grade_equity : {"1":"","2":""}
             * is_ind_dealer : 1
             * dealer_money_type : 1
             * first_money : 10.00
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
             * comment_data_count : 0
             * goods_stock : 2297
             * goods_image : http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg
             * goods_sku : {"goods_sku_id":33762,"goods_id":12474,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2297,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"9.90","image":null}
             * goods_multi_spec : null
             * is_user_grade : false
             * bought_num : 0
             * category : {"category_id":10511,"name":"干果","parent_id":0,"image_id":0,"sort":10,"create_time":"2020-09-08 17:47:37"}
             * image : [{"id":30616,"goods_id":12474,"image_id":24979,"file_path":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","file_name":"20200925161332e88273839.jpg","file_url":""},{"id":30617,"goods_id":12474,"image_id":24980,"file_path":"http://btys.vshop365.cn/uploads/20200925161645a82a86575.png","file_name":"20200925161645a82a86575.png","file_url":""}]
             * sku : [{"goods_sku_id":33762,"goods_id":12474,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2297,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"9.90","image":null}]
             * comment_data : []
             * goods_sales : 4
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
            private int comment_data_count;
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private Object goods_multi_spec;
            private boolean is_user_grade;
            private int bought_num;
            private CategoryBean category;
            private int goods_sales;
            private List<ImageBean> image;
            private List<SkuBean> sku;
            private List<?> comment_data;

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

            public int getComment_data_count() {
                return comment_data_count;
            }

            public void setComment_data_count(int comment_data_count) {
                this.comment_data_count = comment_data_count;
            }

            public int getGoods_stock() {
                return goods_stock;
            }

            public void setGoods_stock(int goods_stock) {
                this.goods_stock = goods_stock;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public GoodsSkuBean getGoods_sku() {
                return goods_sku;
            }

            public void setGoods_sku(GoodsSkuBean goods_sku) {
                this.goods_sku = goods_sku;
            }

            public Object getGoods_multi_spec() {
                return goods_multi_spec;
            }

            public void setGoods_multi_spec(Object goods_multi_spec) {
                this.goods_multi_spec = goods_multi_spec;
            }

            public boolean isIs_user_grade() {
                return is_user_grade;
            }

            public void setIs_user_grade(boolean is_user_grade) {
                this.is_user_grade = is_user_grade;
            }

            public int getBought_num() {
                return bought_num;
            }

            public void setBought_num(int bought_num) {
                this.bought_num = bought_num;
            }

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
            }

            public int getGoods_sales() {
                return goods_sales;
            }

            public void setGoods_sales(int goods_sales) {
                this.goods_sales = goods_sales;
            }

            public List<ImageBean> getImage() {
                return image;
            }

            public void setImage(List<ImageBean> image) {
                this.image = image;
            }

            public List<SkuBean> getSku() {
                return sku;
            }

            public void setSku(List<SkuBean> sku) {
                this.sku = sku;
            }

            public List<?> getComment_data() {
                return comment_data;
            }

            public void setComment_data(List<?> comment_data) {
                this.comment_data = comment_data;
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

            public static class GoodsSkuBean {
                /**
                 * goods_sku_id : 33762
                 * goods_id : 12474
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * balance_price : 0.00
                 * goods_price : 9.90
                 * line_price : 0.00
                 * stock_num : 2297
                 * goods_sales : 3
                 * goods_weight : 0.12
                 * goods_old_price : 9.90
                 * image : null
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
                private String goods_old_price;
                private Object image;

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

                public String getGoods_old_price() {
                    return goods_old_price;
                }

                public void setGoods_old_price(String goods_old_price) {
                    this.goods_old_price = goods_old_price;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }

            public static class CategoryBean {
                /**
                 * category_id : 10511
                 * name : 干果
                 * parent_id : 0
                 * image_id : 0
                 * sort : 10
                 * create_time : 2020-09-08 17:47:37
                 */

                private int category_id;
                private String name;
                private int parent_id;
                private int image_id;
                private int sort;
                private String create_time;

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }
            }

            public static class ImageBean {
                /**
                 * id : 30616
                 * goods_id : 12474
                 * image_id : 24979
                 * file_path : http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg
                 * file_name : 20200925161332e88273839.jpg
                 * file_url :
                 */

                private int id;
                private int goods_id;
                private int image_id;
                private String file_path;
                private String file_name;
                private String file_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getFile_path() {
                    return file_path;
                }

                public void setFile_path(String file_path) {
                    this.file_path = file_path;
                }

                public String getFile_name() {
                    return file_name;
                }

                public void setFile_name(String file_name) {
                    this.file_name = file_name;
                }

                public String getFile_url() {
                    return file_url;
                }

                public void setFile_url(String file_url) {
                    this.file_url = file_url;
                }
            }

            public static class SkuBean {
                /**
                 * goods_sku_id : 33762
                 * goods_id : 12474
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * balance_price : 0.00
                 * goods_price : 9.90
                 * line_price : 0.00
                 * stock_num : 2297
                 * goods_sales : 3
                 * goods_weight : 0.12
                 * goods_old_price : 9.90
                 * image : null
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
                private String goods_old_price;
                private Object image;

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

                public String getGoods_old_price() {
                    return goods_old_price;
                }

                public void setGoods_old_price(String goods_old_price) {
                    this.goods_old_price = goods_old_price;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }
        }

        public static class SettingBean {
            /**
             * bargain_rules : 活动期间，用户发起秒杀，邀请好友助力达到人数即可使用秒杀价进行购买
             */

            private String bargain_rules;

            public String getBargain_rules() {
                return bargain_rules;
            }

            public void setBargain_rules(String bargain_rules) {
                this.bargain_rules = bargain_rules;
            }
        }
    }
}
