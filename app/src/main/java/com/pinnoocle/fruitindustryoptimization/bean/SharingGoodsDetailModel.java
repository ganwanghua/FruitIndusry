package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SharingGoodsDetailModel {

    /**
     * code : 1
     * msg : success
     * data : {"detail":{"goods_id":10088,"goods_name":"兵团大地小兵坚果礼盒750g","category_id":10030,"selling_point":"","people":10,"group_time":24,"is_alone":0,"spec_type":10,"deduct_stock_type":10,"content":"","goods_sort":100,"delivery_id":10001,"is_points_gift":1,"is_points_discount":1,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","goods_status":{"text":"上架","value":10},"creator_gift":"","comment_data_count":0,"goods_stock":212,"goods_image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"image":null,"diff_price":0},"is_user_grade":false,"goods_multi_spec":null,"category":{"category_id":10030,"name":"干果","parent_id":0,"image_id":0,"sort":100,"create_time":"2020-09-09 18:42:13"},"image":[{"id":10393,"goods_id":10088,"image_id":24544,"file_path":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","file_name":"2020090816231978dc05966.png","file_url":""}],"sku":[{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"image":null,"diff_price":0}],"comment_data":[],"goods_sales":0},"activeList":[],"specData":null}
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
         * detail : {"goods_id":10088,"goods_name":"兵团大地小兵坚果礼盒750g","category_id":10030,"selling_point":"","people":10,"group_time":24,"is_alone":0,"spec_type":10,"deduct_stock_type":10,"content":"","goods_sort":100,"delivery_id":10001,"is_points_gift":1,"is_points_discount":1,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","goods_status":{"text":"上架","value":10},"creator_gift":"","comment_data_count":0,"goods_stock":212,"goods_image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"image":null,"diff_price":0},"is_user_grade":false,"goods_multi_spec":null,"category":{"category_id":10030,"name":"干果","parent_id":0,"image_id":0,"sort":100,"create_time":"2020-09-09 18:42:13"},"image":[{"id":10393,"goods_id":10088,"image_id":24544,"file_path":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","file_name":"2020090816231978dc05966.png","file_url":""}],"sku":[{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"image":null,"diff_price":0}],"comment_data":[],"goods_sales":0}
         * activeList : []
         * specData : null
         */

        private DetailBean detail;
        private Object specData;
        private List<?> activeList;

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public Object getSpecData() {
            return specData;
        }

        public void setSpecData(Object specData) {
            this.specData = specData;
        }

        public List<?> getActiveList() {
            return activeList;
        }

        public void setActiveList(List<?> activeList) {
            this.activeList = activeList;
        }

        public static class DetailBean {
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
             * content :
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
             * comment_data_count : 0
             * goods_stock : 212
             * goods_image : http://btys.vshop365.cn/uploads/2020090816231978dc05966.png
             * goods_sku : {"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"image":null,"diff_price":0}
             * is_user_grade : false
             * goods_multi_spec : null
             * category : {"category_id":10030,"name":"干果","parent_id":0,"image_id":0,"sort":100,"create_time":"2020-09-09 18:42:13"}
             * image : [{"id":10393,"goods_id":10088,"image_id":24544,"file_path":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","file_name":"2020090816231978dc05966.png","file_url":""}]
             * sku : [{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"image":null,"diff_price":0}]
             * comment_data : []
             * goods_sales : 0
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
            private String content;
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
            private int comment_data_count;
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private boolean is_user_grade;
            private Object goods_multi_spec;
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

            public boolean isIs_user_grade() {
                return is_user_grade;
            }

            public void setIs_user_grade(boolean is_user_grade) {
                this.is_user_grade = is_user_grade;
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

            public List<?> getComment_data() {
                return comment_data;
            }

            public void setComment_data(List<?> comment_data) {
                this.comment_data = comment_data;
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
                 * sharing_price : 140.00
                 * goods_price : 148.00
                 * line_price : 0.00
                 * stock_num : 212
                 * goods_sales : 0
                 * goods_weight : 0.75
                 * image : null
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
                private Object image;
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

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }

                public int getDiff_price() {
                    return diff_price;
                }

                public void setDiff_price(int diff_price) {
                    this.diff_price = diff_price;
                }
            }

            public static class CategoryBean {
                /**
                 * category_id : 10030
                 * name : 干果
                 * parent_id : 0
                 * image_id : 0
                 * sort : 100
                 * create_time : 2020-09-09 18:42:13
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
                 * id : 10393
                 * goods_id : 10088
                 * image_id : 24544
                 * file_path : http://btys.vshop365.cn/uploads/2020090816231978dc05966.png
                 * file_name : 2020090816231978dc05966.png
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
                 * goods_sku_id : 10459
                 * goods_id : 10088
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * sharing_price : 140.00
                 * goods_price : 148.00
                 * line_price : 0.00
                 * stock_num : 212
                 * goods_sales : 0
                 * goods_weight : 0.75
                 * image : null
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
                private Object image;
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

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
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
