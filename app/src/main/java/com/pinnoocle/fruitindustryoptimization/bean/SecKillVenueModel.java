package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SecKillVenueModel {
    /**
     * code : 1
     * msg : success
     * data : {"activeList":{"total":1,"per_page":15,"current_page":1,"last_page":1,"data":[{"active_id":4,"goods_id":12469,"start_time":"2020-09-11 00:00:00","end_time":"2022-09-13 00:00:00","expiryt_time":12,"floor_price":"74.00","is_floor_buy":1,"share_title":"麻烦帮我砍一刀！我真的很想要了，爱你哟！(๑\u2032ᴗ\u2035๑)","prompt_words":"\"朋友一生一起走，助力一刀有没有\"","status":1,"active_sales":3000,"goods":{"goods_id":12469,"goods_name":"兵团大地小兵坚果礼盒750g","selling_point":"营养丰富口感好","category_id":10515,"spec_type":10,"deduct_stock_type":10,"sales_initial":0,"sales_actual":0,"goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":0,"second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_delete":0,"wxapp_id":10001,"create_time":"2020-09-09 18:44:32","update_time":"2020-09-30 17:06:44","is_packet":0,"is_checked":1,"video":"","goods_stock":789,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null},"goods_multi_spec":null,"category":{"category_id":10515,"name":"礼盒","parent_id":0,"image_id":0,"sort":100,"wxapp_id":10001,"create_time":"2020-09-14 19:21:10","update_time":"2020-09-14 19:21:10"},"image":[{"id":30536,"goods_id":12469,"image_id":24544,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816231978dc05966.png","file_name":"2020090816231978dc05966.png","file_url":""},{"id":30537,"goods_id":12469,"image_id":24556,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162933f21aa3624.png","file_name":"20200908162933f21aa3624.png","file_url":""},{"id":30538,"goods_id":12469,"image_id":24555,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816293347fc19226.png","file_name":"2020090816293347fc19226.png","file_url":""},{"id":30539,"goods_id":12469,"image_id":24554,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162932f68532425.png","file_name":"20200908162932f68532425.png","file_url":""},{"id":30540,"goods_id":12469,"image_id":24553,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162931467c60452.png","file_name":"20200908162931467c60452.png","file_url":""}],"sku":[{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null}],"spec_rel":[],"goods_sales":0},"helps":[],"helps_count":0,"is_start":true,"is_end":false}]}}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * activeList : {"total":1,"per_page":15,"current_page":1,"last_page":1,"data":[{"active_id":4,"goods_id":12469,"start_time":"2020-09-11 00:00:00","end_time":"2022-09-13 00:00:00","expiryt_time":12,"floor_price":"74.00","is_floor_buy":1,"share_title":"麻烦帮我砍一刀！我真的很想要了，爱你哟！(๑\u2032ᴗ\u2035๑)","prompt_words":"\"朋友一生一起走，助力一刀有没有\"","status":1,"active_sales":3000,"goods":{"goods_id":12469,"goods_name":"兵团大地小兵坚果礼盒750g","selling_point":"营养丰富口感好","category_id":10515,"spec_type":10,"deduct_stock_type":10,"sales_initial":0,"sales_actual":0,"goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":0,"second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_delete":0,"wxapp_id":10001,"create_time":"2020-09-09 18:44:32","update_time":"2020-09-30 17:06:44","is_packet":0,"is_checked":1,"video":"","goods_stock":789,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null},"goods_multi_spec":null,"category":{"category_id":10515,"name":"礼盒","parent_id":0,"image_id":0,"sort":100,"wxapp_id":10001,"create_time":"2020-09-14 19:21:10","update_time":"2020-09-14 19:21:10"},"image":[{"id":30536,"goods_id":12469,"image_id":24544,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816231978dc05966.png","file_name":"2020090816231978dc05966.png","file_url":""},{"id":30537,"goods_id":12469,"image_id":24556,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162933f21aa3624.png","file_name":"20200908162933f21aa3624.png","file_url":""},{"id":30538,"goods_id":12469,"image_id":24555,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816293347fc19226.png","file_name":"2020090816293347fc19226.png","file_url":""},{"id":30539,"goods_id":12469,"image_id":24554,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162932f68532425.png","file_name":"20200908162932f68532425.png","file_url":""},{"id":30540,"goods_id":12469,"image_id":24553,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162931467c60452.png","file_name":"20200908162931467c60452.png","file_url":""}],"sku":[{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null}],"spec_rel":[],"goods_sales":0},"helps":[],"helps_count":0,"is_start":true,"is_end":false}]}
         */

        private ActiveListBean activeList;

        public ActiveListBean getActiveList() {
            return activeList;
        }

        public void setActiveList(ActiveListBean activeList) {
            this.activeList = activeList;
        }

        public static class ActiveListBean {
            /**
             * total : 1
             * per_page : 15
             * current_page : 1
             * last_page : 1
             * data : [{"active_id":4,"goods_id":12469,"start_time":"2020-09-11 00:00:00","end_time":"2022-09-13 00:00:00","expiryt_time":12,"floor_price":"74.00","is_floor_buy":1,"share_title":"麻烦帮我砍一刀！我真的很想要了，爱你哟！(๑\u2032ᴗ\u2035๑)","prompt_words":"\"朋友一生一起走，助力一刀有没有\"","status":1,"active_sales":3000,"goods":{"goods_id":12469,"goods_name":"兵团大地小兵坚果礼盒750g","selling_point":"营养丰富口感好","category_id":10515,"spec_type":10,"deduct_stock_type":10,"sales_initial":0,"sales_actual":0,"goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":0,"second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_delete":0,"wxapp_id":10001,"create_time":"2020-09-09 18:44:32","update_time":"2020-09-30 17:06:44","is_packet":0,"is_checked":1,"video":"","goods_stock":789,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null},"goods_multi_spec":null,"category":{"category_id":10515,"name":"礼盒","parent_id":0,"image_id":0,"sort":100,"wxapp_id":10001,"create_time":"2020-09-14 19:21:10","update_time":"2020-09-14 19:21:10"},"image":[{"id":30536,"goods_id":12469,"image_id":24544,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816231978dc05966.png","file_name":"2020090816231978dc05966.png","file_url":""},{"id":30537,"goods_id":12469,"image_id":24556,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162933f21aa3624.png","file_name":"20200908162933f21aa3624.png","file_url":""},{"id":30538,"goods_id":12469,"image_id":24555,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816293347fc19226.png","file_name":"2020090816293347fc19226.png","file_url":""},{"id":30539,"goods_id":12469,"image_id":24554,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162932f68532425.png","file_name":"20200908162932f68532425.png","file_url":""},{"id":30540,"goods_id":12469,"image_id":24553,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162931467c60452.png","file_name":"20200908162931467c60452.png","file_url":""}],"sku":[{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null}],"spec_rel":[],"goods_sales":0},"helps":[],"helps_count":0,"is_start":true,"is_end":false}]
             */

            private int total;
            private int per_page;
            private int current_page;
            private int last_page;
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getLast_page() {
                return last_page;
            }

            public void setLast_page(int last_page) {
                this.last_page = last_page;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * active_id : 4
                 * goods_id : 12469
                 * start_time : 2020-09-11 00:00:00
                 * end_time : 2022-09-13 00:00:00
                 * expiryt_time : 12
                 * floor_price : 74.00
                 * is_floor_buy : 1
                 * share_title : 麻烦帮我砍一刀！我真的很想要了，爱你哟！(๑′ᴗ‵๑)
                 * prompt_words : "朋友一生一起走，助力一刀有没有"
                 * status : 1
                 * active_sales : 3000
                 * goods : {"goods_id":12469,"goods_name":"兵团大地小兵坚果礼盒750g","selling_point":"营养丰富口感好","category_id":10515,"spec_type":10,"deduct_stock_type":10,"sales_initial":0,"sales_actual":0,"goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":0,"second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_delete":0,"wxapp_id":10001,"create_time":"2020-09-09 18:44:32","update_time":"2020-09-30 17:06:44","is_packet":0,"is_checked":1,"video":"","goods_stock":789,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null},"goods_multi_spec":null,"category":{"category_id":10515,"name":"礼盒","parent_id":0,"image_id":0,"sort":100,"wxapp_id":10001,"create_time":"2020-09-14 19:21:10","update_time":"2020-09-14 19:21:10"},"image":[{"id":30536,"goods_id":12469,"image_id":24544,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816231978dc05966.png","file_name":"2020090816231978dc05966.png","file_url":""},{"id":30537,"goods_id":12469,"image_id":24556,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162933f21aa3624.png","file_name":"20200908162933f21aa3624.png","file_url":""},{"id":30538,"goods_id":12469,"image_id":24555,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816293347fc19226.png","file_name":"2020090816293347fc19226.png","file_url":""},{"id":30539,"goods_id":12469,"image_id":24554,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162932f68532425.png","file_name":"20200908162932f68532425.png","file_url":""},{"id":30540,"goods_id":12469,"image_id":24553,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162931467c60452.png","file_name":"20200908162931467c60452.png","file_url":""}],"sku":[{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null}],"spec_rel":[],"goods_sales":0}
                 * helps : []
                 * helps_count : 0
                 * is_start : true
                 * is_end : false
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
                private int active_sales;
                private GoodsBean goods;
                private int helps_count;
                private boolean is_start;
                private boolean is_end;
                private List<?> helps;

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

                public int getActive_sales() {
                    return active_sales;
                }

                public void setActive_sales(int active_sales) {
                    this.active_sales = active_sales;
                }

                public GoodsBean getGoods() {
                    return goods;
                }

                public void setGoods(GoodsBean goods) {
                    this.goods = goods;
                }

                public int getHelps_count() {
                    return helps_count;
                }

                public void setHelps_count(int helps_count) {
                    this.helps_count = helps_count;
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

                public List<?> getHelps() {
                    return helps;
                }

                public void setHelps(List<?> helps) {
                    this.helps = helps;
                }

                public static class GoodsBean {
                    /**
                     * goods_id : 12469
                     * goods_name : 兵团大地小兵坚果礼盒750g
                     * selling_point : 营养丰富口感好
                     * category_id : 10515
                     * spec_type : 10
                     * deduct_stock_type : 10
                     * sales_initial : 0
                     * sales_actual : 0
                     * goods_sort : 100
                     * buy_limit : 0
                     * least_expend_money : 0.00
                     * delivery_id : 10001
                     * is_new_user_enjoy : 0
                     * is_points_gift : 0
                     * is_points_discount : 1
                     * is_enable_balance_price : 0
                     * is_enable_grade : 1
                     * is_alone_grade : 0
                     * alone_grade_equity : {"1":"","2":"0"}
                     * is_ind_dealer : 1
                     * dealer_money_type : 1
                     * first_money : 0
                     * second_money : 0.00
                     * third_money : 0.00
                     * is_rush : 0
                     * is_points_exchange : 0
                     * need_points_num : 0
                     * need_points_money : 0.00
                     * goods_status : {"text":"上架","value":10}
                     * is_delete : 0
                     * wxapp_id : 10001
                     * create_time : 2020-09-09 18:44:32
                     * update_time : 2020-09-30 17:06:44
                     * is_packet : 0
                     * is_checked : 1
                     * video :
                     * goods_stock : 789
                     * goods_image : http://btys.cc/uploads/2020090816231978dc05966.png
                     * goods_sku : {"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null}
                     * goods_multi_spec : null
                     * category : {"category_id":10515,"name":"礼盒","parent_id":0,"image_id":0,"sort":100,"wxapp_id":10001,"create_time":"2020-09-14 19:21:10","update_time":"2020-09-14 19:21:10"}
                     * image : [{"id":30536,"goods_id":12469,"image_id":24544,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816231978dc05966.png","file_name":"2020090816231978dc05966.png","file_url":""},{"id":30537,"goods_id":12469,"image_id":24556,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162933f21aa3624.png","file_name":"20200908162933f21aa3624.png","file_url":""},{"id":30538,"goods_id":12469,"image_id":24555,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/2020090816293347fc19226.png","file_name":"2020090816293347fc19226.png","file_url":""},{"id":30539,"goods_id":12469,"image_id":24554,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162932f68532425.png","file_name":"20200908162932f68532425.png","file_url":""},{"id":30540,"goods_id":12469,"image_id":24553,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","file_path":"http://btys.cc/uploads/20200908162931467c60452.png","file_name":"20200908162931467c60452.png","file_url":""}]
                     * sku : [{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"wxapp_id":10001,"create_time":"2020-09-30 17:06:44","update_time":"2020-09-30 17:06:44","image":null}]
                     * spec_rel : []
                     * goods_sales : 0
                     */

                    private int goods_id;
                    private String goods_name;
                    private String selling_point;
                    private int category_id;
                    private int spec_type;
                    private int deduct_stock_type;
                    private int sales_initial;
                    private int sales_actual;
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
                    private int first_money;
                    private String second_money;
                    private String third_money;
                    private int is_rush;
                    private int is_points_exchange;
                    private int need_points_num;
                    private String need_points_money;
                    private GoodsStatusBean goods_status;
                    private int is_delete;
                    private int wxapp_id;
                    private String create_time;
                    private String update_time;
                    private int is_packet;
                    private int is_checked;
                    private String video;
                    private int goods_stock;
                    private String goods_image;
                    private GoodsSkuBean goods_sku;
                    private Object goods_multi_spec;
                    private CategoryBean category;
                    private int goods_sales;
                    private List<ImageBean> image;
                    private List<SkuBean> sku;
                    private List<?> spec_rel;

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

                    public int getSales_initial() {
                        return sales_initial;
                    }

                    public void setSales_initial(int sales_initial) {
                        this.sales_initial = sales_initial;
                    }

                    public int getSales_actual() {
                        return sales_actual;
                    }

                    public void setSales_actual(int sales_actual) {
                        this.sales_actual = sales_actual;
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

                    public int getFirst_money() {
                        return first_money;
                    }

                    public void setFirst_money(int first_money) {
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

                    public String getUpdate_time() {
                        return update_time;
                    }

                    public void setUpdate_time(String update_time) {
                        this.update_time = update_time;
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

                    public List<?> getSpec_rel() {
                        return spec_rel;
                    }

                    public void setSpec_rel(List<?> spec_rel) {
                        this.spec_rel = spec_rel;
                    }

                    public static class AloneGradeEquityBean {
                        /**
                         * 1 :
                         * 2 : 0
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
                         * goods_sku_id : 33728
                         * goods_id : 12469
                         * spec_sku_id : 0
                         * image_id : 0
                         * goods_no : 131646
                         * balance_price : 0.00
                         * goods_price : 148.00
                         * line_price : 0.00
                         * stock_num : 789
                         * goods_sales : 0
                         * goods_weight : 0.75
                         * wxapp_id : 10001
                         * create_time : 2020-09-30 17:06:44
                         * update_time : 2020-09-30 17:06:44
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
                        private int wxapp_id;
                        private String create_time;
                        private String update_time;
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

                        public String getUpdate_time() {
                            return update_time;
                        }

                        public void setUpdate_time(String update_time) {
                            this.update_time = update_time;
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
                         * category_id : 10515
                         * name : 礼盒
                         * parent_id : 0
                         * image_id : 0
                         * sort : 100
                         * wxapp_id : 10001
                         * create_time : 2020-09-14 19:21:10
                         * update_time : 2020-09-14 19:21:10
                         */

                        private int category_id;
                        private String name;
                        private int parent_id;
                        private int image_id;
                        private int sort;
                        private int wxapp_id;
                        private String create_time;
                        private String update_time;

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

                        public String getUpdate_time() {
                            return update_time;
                        }

                        public void setUpdate_time(String update_time) {
                            this.update_time = update_time;
                        }
                    }

                    public static class ImageBean {
                        /**
                         * id : 30536
                         * goods_id : 12469
                         * image_id : 24544
                         * wxapp_id : 10001
                         * create_time : 2020-09-30 17:06:44
                         * file_path : http://btys.cc/uploads/2020090816231978dc05966.png
                         * file_name : 2020090816231978dc05966.png
                         * file_url :
                         */

                        private int id;
                        private int goods_id;
                        private int image_id;
                        private int wxapp_id;
                        private String create_time;
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
                         * goods_sku_id : 33728
                         * goods_id : 12469
                         * spec_sku_id : 0
                         * image_id : 0
                         * goods_no : 131646
                         * balance_price : 0.00
                         * goods_price : 148.00
                         * line_price : 0.00
                         * stock_num : 789
                         * goods_sales : 0
                         * goods_weight : 0.75
                         * wxapp_id : 10001
                         * create_time : 2020-09-30 17:06:44
                         * update_time : 2020-09-30 17:06:44
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
                        private int wxapp_id;
                        private String create_time;
                        private String update_time;
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

                        public String getUpdate_time() {
                            return update_time;
                        }

                        public void setUpdate_time(String update_time) {
                            this.update_time = update_time;
                        }

                        public Object getImage() {
                            return image;
                        }

                        public void setImage(Object image) {
                            this.image = image;
                        }
                    }
                }
            }
        }
    }
}
