package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectModel {
    /**
     * code : 1
     * msg : success
     * data : {"list":[{"collect_id":98,"user_id":17148,"goods_id":12454,"time":1616643521,"wxapp_id":10001,"create_time":"2021-03-25 11:38:41","update_time":"2021-03-25 11:38:41","is_pt":0,"collect_number":2,"goods":{"goods_id":12454,"goods_name":"兵团大地灰枣夹核桃仁260g","selling_point":"","category_id":10511,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191508f255b1408.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081915070a15e5536.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081915239b6384069.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020090819153445b4e5235.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191545ca85d4698.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191557d5edc3555.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081916084f1955659.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020090819162083fac6117.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191634cafd35274.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","image":[{"id":30576,"goods_id":12454,"image_id":24728,"file_path":"http://btys.vshop365.cn/uploads/202009081914509db049832.png","file_name":"202009081914509db049832.png","file_url":""}],"sku":[{"goods_sku_id":33743,"goods_id":12454,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"25.80","line_price":"0.00","stock_num":11996,"goods_sales":4,"goods_weight":0.26}],"goods_sales":4}}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * collect_id : 98
             * user_id : 17148
             * goods_id : 12454
             * time : 1616643521
             * wxapp_id : 10001
             * create_time : 2021-03-25 11:38:41
             * update_time : 2021-03-25 11:38:41
             * is_pt : 0
             * collect_number : 2
             * goods : {"goods_id":12454,"goods_name":"兵团大地灰枣夹核桃仁260g","selling_point":"","category_id":10511,"spec_type":10,"deduct_stock_type":10,"content":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191508f255b1408.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081915070a15e5536.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081915239b6384069.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020090819153445b4e5235.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191545ca85d4698.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191557d5edc3555.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081916084f1955659.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020090819162083fac6117.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191634cafd35274.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":1,"is_points_discount":1,"is_enable_balance_price":0,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":1,"dealer_money_type":1,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":0,"is_checked":1,"video":"","image":[{"id":30576,"goods_id":12454,"image_id":24728,"file_path":"http://btys.vshop365.cn/uploads/202009081914509db049832.png","file_name":"202009081914509db049832.png","file_url":""}],"sku":[{"goods_sku_id":33743,"goods_id":12454,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"25.80","line_price":"0.00","stock_num":11996,"goods_sales":4,"goods_weight":0.26}],"goods_sales":4}
             */

            private int collect_id;
            private int user_id;
            private int goods_id;
            private int time;
            private int wxapp_id;
            private String create_time;
            private String update_time;
            private int is_pt;
            private int collect_number;
            private GoodsBean goods;

            public int getCollect_id() {
                return collect_id;
            }

            public void setCollect_id(int collect_id) {
                this.collect_id = collect_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
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

            public int getIs_pt() {
                return is_pt;
            }

            public void setIs_pt(int is_pt) {
                this.is_pt = is_pt;
            }

            public int getCollect_number() {
                return collect_number;
            }

            public void setCollect_number(int collect_number) {
                this.collect_number = collect_number;
            }

            public GoodsBean getGoods() {
                return goods;
            }

            public void setGoods(GoodsBean goods) {
                this.goods = goods;
            }

            public static class GoodsBean {
                /**
                 * goods_id : 12454
                 * goods_name : 兵团大地灰枣夹核桃仁260g
                 * selling_point :
                 * category_id : 10511
                 * spec_type : 10
                 * deduct_stock_type : 10
                 * content : &lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191508f255b1408.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081915070a15e5536.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081915239b6384069.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020090819153445b4e5235.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191545ca85d4698.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191557d5edc3555.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202009081916084f1955659.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/2020090819162083fac6117.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20200908191634cafd35274.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;
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
                 * alone_grade_equity : {"1":"","2":"0"}
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
                 * image : [{"id":30576,"goods_id":12454,"image_id":24728,"file_path":"http://btys.vshop365.cn/uploads/202009081914509db049832.png","file_name":"202009081914509db049832.png","file_url":""}]
                 * sku : [{"goods_sku_id":33743,"goods_id":12454,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"25.80","line_price":"0.00","stock_num":11996,"goods_sales":4,"goods_weight":0.26}]
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
                private int goods_sales;
                private List<ImageBean> image;
                private List<SkuBean> sku;

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

                public static class ImageBean {
                    /**
                     * id : 30576
                     * goods_id : 12454
                     * image_id : 24728
                     * file_path : http://btys.vshop365.cn/uploads/202009081914509db049832.png
                     * file_name : 202009081914509db049832.png
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
                     * goods_sku_id : 33743
                     * goods_id : 12454
                     * spec_sku_id : 0
                     * image_id : 0
                     * goods_no :
                     * balance_price : 0.00
                     * goods_price : 25.80
                     * line_price : 0.00
                     * stock_num : 11996
                     * goods_sales : 4
                     * goods_weight : 0.26
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
            }
        }
    }
}
