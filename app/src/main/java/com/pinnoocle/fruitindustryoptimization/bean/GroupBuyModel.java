package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupBuyModel {


    /**
     * code : 1
     * msg : success
     * data : {"goods_list":[{"goods_id":10088,"goods_name":"兵团大地小兵坚果礼盒750g","category_id":10030,"selling_point":"","people":10,"group_time":24,"is_alone":0,"spec_type":10,"deduct_stock_type":10,"goods_sort":100,"delivery_id":10001,"is_points_gift":1,"is_points_discount":1,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","goods_status":{"text":"上架","value":10},"creator_gift":"","goods_stock":212,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"goods_attr":"","image":null,"diff_price":0},"goods_price":"140.00","total_num":"1","total_price":"126.00","is_user_grade":true,"grade_ratio":"0.90","grade_goods_price":"126.00","grade_total_money":"14.00","points_money":0,"points_num":0,"coupon_money":0,"virtual_code_money":0,"total_pay_price":"126.00","express_price":"0.00","points_bonus":0,"goods_sales":0}],"order_total_num":1,"coupon_list":[{"user_coupon_id":11152,"name":"满100减10","color":{"text":"blue","value":10},"coupon_type":{"text":"满减券","value":10},"reduce_price":"10.00","discount":0,"min_price":"99.00","expire_type":10,"start_time":{"text":"2021/03/11","value":1615449934},"end_time":{"text":"2021/03/23","value":1616486734},"reduced_price":"10.00"}],"has_error":false,"error_msg":null,"order_type":"20","delivery":"10","address":{"address_id":13398,"name":"11","phone":"13433333333","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"11","longitude":"","latitude":"","user_id":17139,"region":{"province":"北京市","city":"北京市","region":"东城区"}},"exist_address":true,"express_price":"0.00","intra_region":true,"extract_shop":[],"is_allow_points":false,"is_use_points":"0","points_money":0,"points_bonus":0,"pay_type":20,"setting":{"delivery":["10","20"],"points_name":"积分","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;","tplSetting":{"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""},"sharing":{"is_enable":"1","template_id":0,"template_params":""}}},"last_extract":{"linkman":"","phone":""},"deliverySetting":["10","20"],"send_payment_msg":0,"send_delivery_msg":0,"send_refund_msg":0,"order_total_price":"126.00","coupon_id":0,"coupon_money":0,"virtual_code":"","virtual_code_money":0,"order_price":"126.00","order_pay_price":"126.00"}
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
         * goods_list : [{"goods_id":10088,"goods_name":"兵团大地小兵坚果礼盒750g","category_id":10030,"selling_point":"","people":10,"group_time":24,"is_alone":0,"spec_type":10,"deduct_stock_type":10,"goods_sort":100,"delivery_id":10001,"is_points_gift":1,"is_points_discount":1,"is_enable_grade":1,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":"0"},"is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","goods_status":{"text":"上架","value":10},"creator_gift":"","goods_stock":212,"goods_image":"http://btys.cc/uploads/2020090816231978dc05966.png","goods_sku":{"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"goods_attr":"","image":null,"diff_price":0},"goods_price":"140.00","total_num":"1","total_price":"126.00","is_user_grade":true,"grade_ratio":"0.90","grade_goods_price":"126.00","grade_total_money":"14.00","points_money":0,"points_num":0,"coupon_money":0,"virtual_code_money":0,"total_pay_price":"126.00","express_price":"0.00","points_bonus":0,"goods_sales":0}]
         * order_total_num : 1
         * coupon_list : [{"user_coupon_id":11152,"name":"满100减10","color":{"text":"blue","value":10},"coupon_type":{"text":"满减券","value":10},"reduce_price":"10.00","discount":0,"min_price":"99.00","expire_type":10,"start_time":{"text":"2021/03/11","value":1615449934},"end_time":{"text":"2021/03/23","value":1616486734},"reduced_price":"10.00"}]
         * has_error : false
         * error_msg : null
         * order_type : 20
         * delivery : 10
         * address : {"address_id":13398,"name":"11","phone":"13433333333","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"11","longitude":"","latitude":"","user_id":17139,"region":{"province":"北京市","city":"北京市","region":"东城区"}}
         * exist_address : true
         * express_price : 0.00
         * intra_region : true
         * extract_shop : []
         * is_allow_points : false
         * is_use_points : 0
         * points_money : 0
         * points_bonus : 0
         * pay_type : 20
         * setting : {"delivery":["10","20"],"points_name":"积分","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;","tplSetting":{"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""},"sharing":{"is_enable":"1","template_id":0,"template_params":""}}}
         * last_extract : {"linkman":"","phone":""}
         * deliverySetting : ["10","20"]
         * send_payment_msg : 0
         * send_delivery_msg : 0
         * send_refund_msg : 0
         * order_total_price : 126.00
         * coupon_id : 0
         * coupon_money : 0
         * virtual_code :
         * virtual_code_money : 0
         * order_price : 126.00
         * order_pay_price : 126.00
         */

        private int order_total_num;
        private boolean has_error;
        private Object error_msg;
        private String order_type;
        private String delivery;
        private AddressBean address;
        private boolean exist_address;
        private String express_price;
        private boolean intra_region;
        private boolean is_allow_points;
        private String is_use_points;
        private int points_money;
        private int points_bonus;
        private int pay_type;
        private SettingBean setting;
        private LastExtractBean last_extract;
        private int send_payment_msg;
        private int send_delivery_msg;
        private int send_refund_msg;
        private String order_total_price;
        private int coupon_id;
        private int coupon_money;
        private String virtual_code;
        private int virtual_code_money;
        private String order_price;
        private String order_pay_price;
        private List<GoodsListBean> goods_list;
        private List<CouponListBean> coupon_list;
        private List<?> extract_shop;
        private List<String> deliverySetting;

        public int getOrder_total_num() {
            return order_total_num;
        }

        public void setOrder_total_num(int order_total_num) {
            this.order_total_num = order_total_num;
        }

        public boolean isHas_error() {
            return has_error;
        }

        public void setHas_error(boolean has_error) {
            this.has_error = has_error;
        }

        public Object getError_msg() {
            return error_msg;
        }

        public void setError_msg(Object error_msg) {
            this.error_msg = error_msg;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public String getDelivery() {
            return delivery;
        }

        public void setDelivery(String delivery) {
            this.delivery = delivery;
        }

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public boolean isExist_address() {
            return exist_address;
        }

        public void setExist_address(boolean exist_address) {
            this.exist_address = exist_address;
        }

        public String getExpress_price() {
            return express_price;
        }

        public void setExpress_price(String express_price) {
            this.express_price = express_price;
        }

        public boolean isIntra_region() {
            return intra_region;
        }

        public void setIntra_region(boolean intra_region) {
            this.intra_region = intra_region;
        }

        public boolean isIs_allow_points() {
            return is_allow_points;
        }

        public void setIs_allow_points(boolean is_allow_points) {
            this.is_allow_points = is_allow_points;
        }

        public String getIs_use_points() {
            return is_use_points;
        }

        public void setIs_use_points(String is_use_points) {
            this.is_use_points = is_use_points;
        }

        public int getPoints_money() {
            return points_money;
        }

        public void setPoints_money(int points_money) {
            this.points_money = points_money;
        }

        public int getPoints_bonus() {
            return points_bonus;
        }

        public void setPoints_bonus(int points_bonus) {
            this.points_bonus = points_bonus;
        }

        public int getPay_type() {
            return pay_type;
        }

        public void setPay_type(int pay_type) {
            this.pay_type = pay_type;
        }

        public SettingBean getSetting() {
            return setting;
        }

        public void setSetting(SettingBean setting) {
            this.setting = setting;
        }

        public LastExtractBean getLast_extract() {
            return last_extract;
        }

        public void setLast_extract(LastExtractBean last_extract) {
            this.last_extract = last_extract;
        }

        public int getSend_payment_msg() {
            return send_payment_msg;
        }

        public void setSend_payment_msg(int send_payment_msg) {
            this.send_payment_msg = send_payment_msg;
        }

        public int getSend_delivery_msg() {
            return send_delivery_msg;
        }

        public void setSend_delivery_msg(int send_delivery_msg) {
            this.send_delivery_msg = send_delivery_msg;
        }

        public int getSend_refund_msg() {
            return send_refund_msg;
        }

        public void setSend_refund_msg(int send_refund_msg) {
            this.send_refund_msg = send_refund_msg;
        }

        public String getOrder_total_price() {
            return order_total_price;
        }

        public void setOrder_total_price(String order_total_price) {
            this.order_total_price = order_total_price;
        }

        public int getCoupon_id() {
            return coupon_id;
        }

        public void setCoupon_id(int coupon_id) {
            this.coupon_id = coupon_id;
        }

        public int getCoupon_money() {
            return coupon_money;
        }

        public void setCoupon_money(int coupon_money) {
            this.coupon_money = coupon_money;
        }

        public String getVirtual_code() {
            return virtual_code;
        }

        public void setVirtual_code(String virtual_code) {
            this.virtual_code = virtual_code;
        }

        public int getVirtual_code_money() {
            return virtual_code_money;
        }

        public void setVirtual_code_money(int virtual_code_money) {
            this.virtual_code_money = virtual_code_money;
        }

        public String getOrder_price() {
            return order_price;
        }

        public void setOrder_price(String order_price) {
            this.order_price = order_price;
        }

        public String getOrder_pay_price() {
            return order_pay_price;
        }

        public void setOrder_pay_price(String order_pay_price) {
            this.order_pay_price = order_pay_price;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public List<CouponListBean> getCoupon_list() {
            return coupon_list;
        }

        public void setCoupon_list(List<CouponListBean> coupon_list) {
            this.coupon_list = coupon_list;
        }

        public List<?> getExtract_shop() {
            return extract_shop;
        }

        public void setExtract_shop(List<?> extract_shop) {
            this.extract_shop = extract_shop;
        }

        public List<String> getDeliverySetting() {
            return deliverySetting;
        }

        public void setDeliverySetting(List<String> deliverySetting) {
            this.deliverySetting = deliverySetting;
        }

        public static class AddressBean {
            /**
             * address_id : 13398
             * name : 11
             * phone : 13433333333
             * province_id : 1
             * city_id : 2
             * region_id : 3
             * district :
             * detail : 11
             * longitude :
             * latitude :
             * user_id : 17139
             * region : {"province":"北京市","city":"北京市","region":"东城区"}
             */

            private int address_id;
            private String name;
            private String phone;
            private int province_id;
            private int city_id;
            private int region_id;
            private String district;
            private String detail;
            private String longitude;
            private String latitude;
            private int user_id;
            private RegionBean region;

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
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

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
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

        public static class SettingBean {
            /**
             * delivery : ["10","20"]
             * points_name : 积分
             * points_describe : a) 积分不可兑现、不可转让,仅可在本平台使用;
             b) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;
             c) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)
             d) 买家在完成该笔交易(订单状态为“已签收”)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;
             * tplSetting : {"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""},"sharing":{"is_enable":"1","template_id":0,"template_params":""}}
             */

            private String points_name;
            private String points_describe;
            private TplSettingBean tplSetting;
            private List<String> delivery;

            public String getPoints_name() {
                return points_name;
            }

            public void setPoints_name(String points_name) {
                this.points_name = points_name;
            }

            public String getPoints_describe() {
                return points_describe;
            }

            public void setPoints_describe(String points_describe) {
                this.points_describe = points_describe;
            }

            public TplSettingBean getTplSetting() {
                return tplSetting;
            }

            public void setTplSetting(TplSettingBean tplSetting) {
                this.tplSetting = tplSetting;
            }

            public List<String> getDelivery() {
                return delivery;
            }

            public void setDelivery(List<String> delivery) {
                this.delivery = delivery;
            }

            public static class TplSettingBean {
                /**
                 * payment : {"is_enable":"0","template_id":"","template_params":""}
                 * delivery : {"is_enable":"0","template_id":"","template_params":""}
                 * refund : {"is_enable":"0","template_id":"","template_params":""}
                 * sharing : {"is_enable":"1","template_id":0,"template_params":""}
                 */

                private PaymentBean payment;
                private DeliveryBean delivery;
                private RefundBean refund;
                private SharingBean sharing;

                public PaymentBean getPayment() {
                    return payment;
                }

                public void setPayment(PaymentBean payment) {
                    this.payment = payment;
                }

                public DeliveryBean getDelivery() {
                    return delivery;
                }

                public void setDelivery(DeliveryBean delivery) {
                    this.delivery = delivery;
                }

                public RefundBean getRefund() {
                    return refund;
                }

                public void setRefund(RefundBean refund) {
                    this.refund = refund;
                }

                public SharingBean getSharing() {
                    return sharing;
                }

                public void setSharing(SharingBean sharing) {
                    this.sharing = sharing;
                }

                public static class PaymentBean {
                    /**
                     * is_enable : 0
                     * template_id :
                     * template_params :
                     */

                    private String is_enable;
                    private String template_id;
                    private String template_params;

                    public String getIs_enable() {
                        return is_enable;
                    }

                    public void setIs_enable(String is_enable) {
                        this.is_enable = is_enable;
                    }

                    public String getTemplate_id() {
                        return template_id;
                    }

                    public void setTemplate_id(String template_id) {
                        this.template_id = template_id;
                    }

                    public String getTemplate_params() {
                        return template_params;
                    }

                    public void setTemplate_params(String template_params) {
                        this.template_params = template_params;
                    }
                }

                public static class DeliveryBean {
                    /**
                     * is_enable : 0
                     * template_id :
                     * template_params :
                     */

                    private String is_enable;
                    private String template_id;
                    private String template_params;

                    public String getIs_enable() {
                        return is_enable;
                    }

                    public void setIs_enable(String is_enable) {
                        this.is_enable = is_enable;
                    }

                    public String getTemplate_id() {
                        return template_id;
                    }

                    public void setTemplate_id(String template_id) {
                        this.template_id = template_id;
                    }

                    public String getTemplate_params() {
                        return template_params;
                    }

                    public void setTemplate_params(String template_params) {
                        this.template_params = template_params;
                    }
                }

                public static class RefundBean {
                    /**
                     * is_enable : 0
                     * template_id :
                     * template_params :
                     */

                    private String is_enable;
                    private String template_id;
                    private String template_params;

                    public String getIs_enable() {
                        return is_enable;
                    }

                    public void setIs_enable(String is_enable) {
                        this.is_enable = is_enable;
                    }

                    public String getTemplate_id() {
                        return template_id;
                    }

                    public void setTemplate_id(String template_id) {
                        this.template_id = template_id;
                    }

                    public String getTemplate_params() {
                        return template_params;
                    }

                    public void setTemplate_params(String template_params) {
                        this.template_params = template_params;
                    }
                }

                public static class SharingBean {
                    /**
                     * is_enable : 1
                     * template_id : 0
                     * template_params :
                     */

                    private String is_enable;
                    private int template_id;
                    private String template_params;

                    public String getIs_enable() {
                        return is_enable;
                    }

                    public void setIs_enable(String is_enable) {
                        this.is_enable = is_enable;
                    }

                    public int getTemplate_id() {
                        return template_id;
                    }

                    public void setTemplate_id(int template_id) {
                        this.template_id = template_id;
                    }

                    public String getTemplate_params() {
                        return template_params;
                    }

                    public void setTemplate_params(String template_params) {
                        this.template_params = template_params;
                    }
                }
            }
        }

        public static class LastExtractBean {
            /**
             * linkman :
             * phone :
             */

            private String linkman;
            private String phone;

            public String getLinkman() {
                return linkman;
            }

            public void setLinkman(String linkman) {
                this.linkman = linkman;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }

        public static class GoodsListBean {
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
             * goods_stock : 212
             * goods_image : http://btys.cc/uploads/2020090816231978dc05966.png
             * goods_sku : {"goods_sku_id":10459,"goods_id":10088,"spec_sku_id":"0","image_id":0,"goods_no":"","sharing_price":"140.00","goods_price":"148.00","line_price":"0.00","stock_num":212,"goods_sales":0,"goods_weight":0.75,"goods_attr":"","image":null,"diff_price":0}
             * goods_price : 140.00
             * total_num : 1
             * total_price : 126.00
             * is_user_grade : true
             * grade_ratio : 0.90
             * grade_goods_price : 126.00
             * grade_total_money : 14.00
             * points_money : 0
             * points_num : 0
             * coupon_money : 0
             * virtual_code_money : 0
             * total_pay_price : 126.00
             * express_price : 0.00
             * points_bonus : 0
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
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private String goods_price;
            private String total_num;
            private String total_price;
            private boolean is_user_grade;
            private String grade_ratio;
            private String grade_goods_price;
            private String grade_total_money;
            private int points_money;
            private int points_num;
            private int coupon_money;
            private int virtual_code_money;
            private String total_pay_price;
            private String express_price;
            private int points_bonus;
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

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getTotal_num() {
                return total_num;
            }

            public void setTotal_num(String total_num) {
                this.total_num = total_num;
            }

            public String getTotal_price() {
                return total_price;
            }

            public void setTotal_price(String total_price) {
                this.total_price = total_price;
            }

            public boolean isIs_user_grade() {
                return is_user_grade;
            }

            public void setIs_user_grade(boolean is_user_grade) {
                this.is_user_grade = is_user_grade;
            }

            public String getGrade_ratio() {
                return grade_ratio;
            }

            public void setGrade_ratio(String grade_ratio) {
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

            public int getPoints_money() {
                return points_money;
            }

            public void setPoints_money(int points_money) {
                this.points_money = points_money;
            }

            public int getPoints_num() {
                return points_num;
            }

            public void setPoints_num(int points_num) {
                this.points_num = points_num;
            }

            public int getCoupon_money() {
                return coupon_money;
            }

            public void setCoupon_money(int coupon_money) {
                this.coupon_money = coupon_money;
            }

            public int getVirtual_code_money() {
                return virtual_code_money;
            }

            public void setVirtual_code_money(int virtual_code_money) {
                this.virtual_code_money = virtual_code_money;
            }

            public String getTotal_pay_price() {
                return total_pay_price;
            }

            public void setTotal_pay_price(String total_pay_price) {
                this.total_pay_price = total_pay_price;
            }

            public String getExpress_price() {
                return express_price;
            }

            public void setExpress_price(String express_price) {
                this.express_price = express_price;
            }

            public int getPoints_bonus() {
                return points_bonus;
            }

            public void setPoints_bonus(int points_bonus) {
                this.points_bonus = points_bonus;
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
                 * goods_attr :
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
                private String goods_attr;
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

                public String getGoods_attr() {
                    return goods_attr;
                }

                public void setGoods_attr(String goods_attr) {
                    this.goods_attr = goods_attr;
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

        public static class CouponListBean {
            /**
             * user_coupon_id : 11152
             * name : 满100减10
             * color : {"text":"blue","value":10}
             * coupon_type : {"text":"满减券","value":10}
             * reduce_price : 10.00
             * discount : 0
             * min_price : 99.00
             * expire_type : 10
             * start_time : {"text":"2021/03/11","value":1615449934}
             * end_time : {"text":"2021/03/23","value":1616486734}
             * reduced_price : 10.00
             */

            private int user_coupon_id;
            private String name;
            private ColorBean color;
            private CouponTypeBean coupon_type;
            private String reduce_price;
            private int discount;
            private String min_price;
            private int expire_type;
            private StartTimeBean start_time;
            private EndTimeBean end_time;
            private String reduced_price;

            public int getUser_coupon_id() {
                return user_coupon_id;
            }

            public void setUser_coupon_id(int user_coupon_id) {
                this.user_coupon_id = user_coupon_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public ColorBean getColor() {
                return color;
            }

            public void setColor(ColorBean color) {
                this.color = color;
            }

            public CouponTypeBean getCoupon_type() {
                return coupon_type;
            }

            public void setCoupon_type(CouponTypeBean coupon_type) {
                this.coupon_type = coupon_type;
            }

            public String getReduce_price() {
                return reduce_price;
            }

            public void setReduce_price(String reduce_price) {
                this.reduce_price = reduce_price;
            }

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public int getExpire_type() {
                return expire_type;
            }

            public void setExpire_type(int expire_type) {
                this.expire_type = expire_type;
            }

            public StartTimeBean getStart_time() {
                return start_time;
            }

            public void setStart_time(StartTimeBean start_time) {
                this.start_time = start_time;
            }

            public EndTimeBean getEnd_time() {
                return end_time;
            }

            public void setEnd_time(EndTimeBean end_time) {
                this.end_time = end_time;
            }

            public String getReduced_price() {
                return reduced_price;
            }

            public void setReduced_price(String reduced_price) {
                this.reduced_price = reduced_price;
            }

            public static class ColorBean {
                /**
                 * text : blue
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

            public static class CouponTypeBean {
                /**
                 * text : 满减券
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

            public static class StartTimeBean {
                /**
                 * text : 2021/03/11
                 * value : 1615449934
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

            public static class EndTimeBean {
                /**
                 * text : 2021/03/23
                 * value : 1616486734
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
