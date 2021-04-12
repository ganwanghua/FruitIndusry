package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class MyCommentModel {
    /**
     * code : 1
     * msg : success
     * data : {"list":{"total":1,"per_page":15,"current_page":1,"last_page":1,"data":[{"comment_id":24,"score":10,"content":"具体阿卡丽","is_picture":1,"user_id":17187,"wxapp_id":10001,"create_time":"2021-04-12 14:52:58","user":{"user_id":17187,"nickName":"技术测试-土豪","avatarUrl":"http://btys.vshop365.cn/uploads/202104121418459fa460089.jpeg"},"order_goods":{"order_goods_id":23389,"goods_id":12478,"goods_name":"兵团大地干果礼盒2.1kg","image_id":25187,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33782,"goods_attr":"","goods_no":"","goods_price":"0.00","line_price":"0.00","goods_weight":2.1,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":1,"total_price":"0.00","total_pay_price":"0.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":1,"order_id":19795,"user_id":17187,"image":{"file_id":25187,"storage":"local","group_id":0,"file_url":"","file_name":"202010291636137eec53445.jpg","file_size":515743,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-29 16:36:13","file_path":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg"}},"image":[{"id":21,"comment_id":24,"image_id":25237,"file_path":"http://btys.vshop365.cn/uploads/20210412145257fbd1c0341.jpeg","file_name":"20210412145257fbd1c0341.jpeg","file_url":""}]}]},"total":{"all":1,"praise":1,"review":0,"negative":0}}
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
         * list : {"total":1,"per_page":15,"current_page":1,"last_page":1,"data":[{"comment_id":24,"score":10,"content":"具体阿卡丽","is_picture":1,"user_id":17187,"wxapp_id":10001,"create_time":"2021-04-12 14:52:58","user":{"user_id":17187,"nickName":"技术测试-土豪","avatarUrl":"http://btys.vshop365.cn/uploads/202104121418459fa460089.jpeg"},"order_goods":{"order_goods_id":23389,"goods_id":12478,"goods_name":"兵团大地干果礼盒2.1kg","image_id":25187,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33782,"goods_attr":"","goods_no":"","goods_price":"0.00","line_price":"0.00","goods_weight":2.1,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":1,"total_price":"0.00","total_pay_price":"0.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":1,"order_id":19795,"user_id":17187,"image":{"file_id":25187,"storage":"local","group_id":0,"file_url":"","file_name":"202010291636137eec53445.jpg","file_size":515743,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-29 16:36:13","file_path":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg"}},"image":[{"id":21,"comment_id":24,"image_id":25237,"file_path":"http://btys.vshop365.cn/uploads/20210412145257fbd1c0341.jpeg","file_name":"20210412145257fbd1c0341.jpeg","file_url":""}]}]}
         * total : {"all":1,"praise":1,"review":0,"negative":0}
         */

        private ListBean list;
        private TotalBean total;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public TotalBean getTotal() {
            return total;
        }

        public void setTotal(TotalBean total) {
            this.total = total;
        }

        public static class ListBean {
            /**
             * total : 1
             * per_page : 15
             * current_page : 1
             * last_page : 1
             * data : [{"comment_id":24,"score":10,"content":"具体阿卡丽","is_picture":1,"user_id":17187,"wxapp_id":10001,"create_time":"2021-04-12 14:52:58","user":{"user_id":17187,"nickName":"技术测试-土豪","avatarUrl":"http://btys.vshop365.cn/uploads/202104121418459fa460089.jpeg"},"order_goods":{"order_goods_id":23389,"goods_id":12478,"goods_name":"兵团大地干果礼盒2.1kg","image_id":25187,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33782,"goods_attr":"","goods_no":"","goods_price":"0.00","line_price":"0.00","goods_weight":2.1,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":1,"total_price":"0.00","total_pay_price":"0.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":1,"order_id":19795,"user_id":17187,"image":{"file_id":25187,"storage":"local","group_id":0,"file_url":"","file_name":"202010291636137eec53445.jpg","file_size":515743,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-29 16:36:13","file_path":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg"}},"image":[{"id":21,"comment_id":24,"image_id":25237,"file_path":"http://btys.vshop365.cn/uploads/20210412145257fbd1c0341.jpeg","file_name":"20210412145257fbd1c0341.jpeg","file_url":""}]}]
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
                 * comment_id : 24
                 * score : 10
                 * content : 具体阿卡丽
                 * is_picture : 1
                 * user_id : 17187
                 * wxapp_id : 10001
                 * create_time : 2021-04-12 14:52:58
                 * user : {"user_id":17187,"nickName":"技术测试-土豪","avatarUrl":"http://btys.vshop365.cn/uploads/202104121418459fa460089.jpeg"}
                 * order_goods : {"order_goods_id":23389,"goods_id":12478,"goods_name":"兵团大地干果礼盒2.1kg","image_id":25187,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":33782,"goods_attr":"","goods_no":"","goods_price":"0.00","line_price":"0.00","goods_weight":2.1,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":1,"total_price":"0.00","total_pay_price":"0.00","is_ind_dealer":1,"dealer_money_type":1,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":1,"order_id":19795,"user_id":17187,"image":{"file_id":25187,"storage":"local","group_id":0,"file_url":"","file_name":"202010291636137eec53445.jpg","file_size":515743,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-29 16:36:13","file_path":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg"}}
                 * image : [{"id":21,"comment_id":24,"image_id":25237,"file_path":"http://btys.vshop365.cn/uploads/20210412145257fbd1c0341.jpeg","file_name":"20210412145257fbd1c0341.jpeg","file_url":""}]
                 */

                private int comment_id;
                private int score;
                private String content;
                private int is_picture;
                private int user_id;
                private int wxapp_id;
                private String create_time;
                private UserBean user;
                private OrderGoodsBean order_goods;
                private List<ImageBeanX> image;

                public int getComment_id() {
                    return comment_id;
                }

                public void setComment_id(int comment_id) {
                    this.comment_id = comment_id;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getIs_picture() {
                    return is_picture;
                }

                public void setIs_picture(int is_picture) {
                    this.is_picture = is_picture;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
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

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public OrderGoodsBean getOrder_goods() {
                    return order_goods;
                }

                public void setOrder_goods(OrderGoodsBean order_goods) {
                    this.order_goods = order_goods;
                }

                public List<ImageBeanX> getImage() {
                    return image;
                }

                public void setImage(List<ImageBeanX> image) {
                    this.image = image;
                }

                public static class UserBean {
                    /**
                     * user_id : 17187
                     * nickName : 技术测试-土豪
                     * avatarUrl : http://btys.vshop365.cn/uploads/202104121418459fa460089.jpeg
                     */

                    private int user_id;
                    private String nickName;
                    private String avatarUrl;

                    public int getUser_id() {
                        return user_id;
                    }

                    public void setUser_id(int user_id) {
                        this.user_id = user_id;
                    }

                    public String getNickName() {
                        return nickName;
                    }

                    public void setNickName(String nickName) {
                        this.nickName = nickName;
                    }

                    public String getAvatarUrl() {
                        return avatarUrl;
                    }

                    public void setAvatarUrl(String avatarUrl) {
                        this.avatarUrl = avatarUrl;
                    }
                }

                public static class OrderGoodsBean {
                    /**
                     * order_goods_id : 23389
                     * goods_id : 12478
                     * goods_name : 兵团大地干果礼盒2.1kg
                     * image_id : 25187
                     * deduct_stock_type : 10
                     * spec_type : 10
                     * spec_sku_id : 0
                     * goods_sku_id : 33782
                     * goods_attr :
                     * goods_no :
                     * goods_price : 0.00
                     * line_price : 0.00
                     * goods_weight : 2.1
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
                     * total_num : 1
                     * total_price : 0.00
                     * total_pay_price : 0.00
                     * is_ind_dealer : 1
                     * dealer_money_type : 1
                     * first_money : 0.00
                     * second_money : 0.00
                     * third_money : 0.00
                     * is_comment : 1
                     * order_id : 19795
                     * user_id : 17187
                     * image : {"file_id":25187,"storage":"local","group_id":0,"file_url":"","file_name":"202010291636137eec53445.jpg","file_size":515743,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2020-10-29 16:36:13","file_path":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg"}
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

                    public static class ImageBean {
                        /**
                         * file_id : 25187
                         * storage : local
                         * group_id : 0
                         * file_url :
                         * file_name : 202010291636137eec53445.jpg
                         * file_size : 515743
                         * file_type : image
                         * extension : jpg
                         * is_user : 0
                         * is_recycle : 0
                         * is_delete : 0
                         * wxapp_id : 10001
                         * create_time : 2020-10-29 16:36:13
                         * file_path : http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg
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
                }

                public static class ImageBeanX {
                    /**
                     * id : 21
                     * comment_id : 24
                     * image_id : 25237
                     * file_path : http://btys.vshop365.cn/uploads/20210412145257fbd1c0341.jpeg
                     * file_name : 20210412145257fbd1c0341.jpeg
                     * file_url :
                     */

                    private int id;
                    private int comment_id;
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

                    public int getComment_id() {
                        return comment_id;
                    }

                    public void setComment_id(int comment_id) {
                        this.comment_id = comment_id;
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
            }
        }

        public static class TotalBean {
            /**
             * all : 1
             * praise : 1
             * review : 0
             * negative : 0
             */

            private int all;
            private int praise;
            private int review;
            private int negative;

            public int getAll() {
                return all;
            }

            public void setAll(int all) {
                this.all = all;
            }

            public int getPraise() {
                return praise;
            }

            public void setPraise(int praise) {
                this.praise = praise;
            }

            public int getReview() {
                return review;
            }

            public void setReview(int review) {
                this.review = review;
            }

            public int getNegative() {
                return negative;
            }

            public void setNegative(int negative) {
                this.negative = negative;
            }
        }
    }
}
