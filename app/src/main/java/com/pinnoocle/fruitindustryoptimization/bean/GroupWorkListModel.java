package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupWorkListModel {
    /**
     * code : 1
     * msg : success
     * data : {"list":{"total":1,"per_page":15,"current_page":1,"last_page":1,"data":[{"goods_id":10088,"goods_name":"兵团大地小兵坚果礼盒750g","category_id":10030,"selling_point":"","people":10,"group_time":24,"is_alone":0,"spec_type":10,"deduct_stock_type":10,"goods_sort":100,"delivery_id":10001,"is_points_gift":1,"is_points_discount":1,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","goods_status":{"text":"上架","value":10},"creator_gift":"","goods_sales":0,"goods_min_price":"140.00","goods_max_price":"140.00","goods_stock":211,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"126.00","goods_price":"133.20","line_price":"0.00","stock_num":211,"goods_sales":0,"goods_weight":0.75,"diff_price":0},"is_user_grade":true}]}}
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
         * list : {"total":1,"per_page":15,"current_page":1,"last_page":1,"data":[{"goods_id":10088,"goods_name":"兵团大地小兵坚果礼盒750g","category_id":10030,"selling_point":"","people":10,"group_time":24,"is_alone":0,"spec_type":10,"deduct_stock_type":10,"goods_sort":100,"delivery_id":10001,"is_points_gift":1,"is_points_discount":1,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","goods_status":{"text":"上架","value":10},"creator_gift":"","goods_sales":0,"goods_min_price":"140.00","goods_max_price":"140.00","goods_stock":211,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"126.00","goods_price":"133.20","line_price":"0.00","stock_num":211,"goods_sales":0,"goods_weight":0.75,"diff_price":0},"is_user_grade":true}]}
         */

        private ListBean list;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * total : 1
             * per_page : 15
             * current_page : 1
             * last_page : 1
             * data : [{"goods_id":10088,"goods_name":"兵团大地小兵坚果礼盒750g","category_id":10030,"selling_point":"","people":10,"group_time":24,"is_alone":0,"spec_type":10,"deduct_stock_type":10,"goods_sort":100,"delivery_id":10001,"is_points_gift":1,"is_points_discount":1,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","goods_status":{"text":"上架","value":10},"creator_gift":"","goods_sales":0,"goods_min_price":"140.00","goods_max_price":"140.00","goods_stock":211,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"126.00","goods_price":"133.20","line_price":"0.00","stock_num":211,"goods_sales":0,"goods_weight":0.75,"diff_price":0},"is_user_grade":true}]
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
                 * goods_id : 10088
                 * goods_name : 兵团大地小兵坚果礼盒750g
                 * category_id : 10030
                 * selling_point :
                 * people : 10
                 * group_time : 24
                 * is_alone : 0
                 * spec_type : 10
                 * deduct_stock_type : 10
                 * goods_sort : 100
                 * delivery_id : 10001
                 * is_points_gift : 1
                 * is_points_discount : 1
                 * is_enable_grade : 1
                 * is_alone_grade : 0
                 * alone_grade_equity : {"1":"","2":"0"}
                 * is_ind_dealer : 0
                 * dealer_money_type : 10
                 * first_money : 0.00
                 * second_money : 0.00
                 * third_money : 0.00
                 * goods_status : {"text":"上架","value":10}
                 * creator_gift :
                 * goods_sales : 0
                 * goods_min_price : 140.00
                 * goods_max_price : 140.00
                 * goods_stock : 211
                 * goods_image : http://btys.cc/uploads/2020090816231978dc05966.png
                 * goods_sku : {"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"126.00","goods_price":"133.20","line_price":"0.00","stock_num":211,"goods_sales":0,"goods_weight":0.75,"diff_price":0}
                 * is_user_grade : true
                 */

                private int goods_id;
                private String goods_name;
                private int category_id;
                private String selling_point;
                private int people;
                private int group_time;
                private int is_alone;
                private int spec_type;
                private int deduct_stock_type;
                private int goods_sort;
                private int delivery_id;
                private int is_points_gift;
                private int is_points_discount;
                private int is_enable_grade;
                private int is_alone_grade;
                private AloneGradeEquityBean alone_grade_equity;
                private int is_ind_dealer;
                private int dealer_money_type;
                private String first_money;
                private String second_money;
                private String third_money;
                private GoodsStatusBean goods_status;
                private String creator_gift;
                private int goods_sales;
                private String goods_min_price;
                private String goods_max_price;
                private int goods_stock;
                private String goods_image;
                private GoodsSkuBean goods_sku;
                private boolean is_user_grade;

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

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getSelling_point() {
                    return selling_point;
                }

                public void setSelling_point(String selling_point) {
                    this.selling_point = selling_point;
                }

                public int getPeople() {
                    return people;
                }

                public void setPeople(int people) {
                    this.people = people;
                }

                public int getGroup_time() {
                    return group_time;
                }

                public void setGroup_time(int group_time) {
                    this.group_time = group_time;
                }

                public int getIs_alone() {
                    return is_alone;
                }

                public void setIs_alone(int is_alone) {
                    this.is_alone = is_alone;
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

                public int getGoods_sort() {
                    return goods_sort;
                }

                public void setGoods_sort(int goods_sort) {
                    this.goods_sort = goods_sort;
                }

                public int getDelivery_id() {
                    return delivery_id;
                }

                public void setDelivery_id(int delivery_id) {
                    this.delivery_id = delivery_id;
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

                public GoodsStatusBean getGoods_status() {
                    return goods_status;
                }

                public void setGoods_status(GoodsStatusBean goods_status) {
                    this.goods_status = goods_status;
                }

                public String getCreator_gift() {
                    return creator_gift;
                }

                public void setCreator_gift(String creator_gift) {
                    this.creator_gift = creator_gift;
                }

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public String getGoods_min_price() {
                    return goods_min_price;
                }

                public void setGoods_min_price(String goods_min_price) {
                    this.goods_min_price = goods_min_price;
                }

                public String getGoods_max_price() {
                    return goods_max_price;
                }

                public void setGoods_max_price(String goods_max_price) {
                    this.goods_max_price = goods_max_price;
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

                public boolean isIs_user_grade() {
                    return is_user_grade;
                }

                public void setIs_user_grade(boolean is_user_grade) {
                    this.is_user_grade = is_user_grade;
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
                     * goods_sku_id : 10459
                     * goods_id : 10088
                     * spec_sku_id : 0
                     * image_id : 0
                     * goods_no :
                     * sharing_price : 126.00
                     * goods_price : 133.20
                     * line_price : 0.00
                     * stock_num : 211
                     * goods_sales : 0
                     * goods_weight : 0.75
                     * diff_price : 0
                     */

                    private int goods_sku_id;
                    private int goods_id;
                    private String spec_sku_id;
                    private int image_id;
                    private String goods_no;
                    private String sharing_price;
                    private String goods_price;
                    private String line_price;
                    private int stock_num;
                    private int goods_sales;
                    private double goods_weight;
                    private int diff_price;

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

                    public String getSharing_price() {
                        return sharing_price;
                    }

                    public void setSharing_price(String sharing_price) {
                        this.sharing_price = sharing_price;
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

                    public int getDiff_price() {
                        return diff_price;
                    }

                    public void setDiff_price(int diff_price) {
                        this.diff_price = diff_price;
                    }
                }
            }
        }
    }
}
