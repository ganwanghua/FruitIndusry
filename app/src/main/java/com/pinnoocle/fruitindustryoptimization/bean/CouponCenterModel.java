package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class CouponCenterModel {

    /**
     * code : 1
     * msg : success
     * data : {"list":[{"coupon_id":10059,"name":"测试优惠券","color":{"text":"blue","value":10},"coupon_type":{"text":"满减券","value":10},"reduce_price":"1.00","discount":0,"gift":"","min_price":"198.00","expire_type":10,"begin_day":0,"expire_day":3,"start_time":{"text":"1970/01/01","value":0},"end_time":{"text":"1970/01/01","value":0},"apply_range":{"text":"指定商品","value":20},"center_visible":{"text":"显示","value":10},"total_num":-1,"sort":100,"wxapp_id":10001,"is_draw":0,"percent":0,"is_tree":0,"state":{"text":"","value":1}}]}
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
             * coupon_id : 10059
             * name : 测试优惠券
             * color : {"text":"blue","value":10}
             * coupon_type : {"text":"满减券","value":10}
             * reduce_price : 1.00
             * discount : 0
             * gift :
             * min_price : 198.00
             * expire_type : 10
             * begin_day : 0
             * expire_day : 3
             * start_time : {"text":"1970/01/01","value":0}
             * end_time : {"text":"1970/01/01","value":0}
             * apply_range : {"text":"指定商品","value":20}
             * center_visible : {"text":"显示","value":10}
             * total_num : -1
             * sort : 100
             * wxapp_id : 10001
             * is_draw : 0
             * percent : 0
             * is_tree : 0
             * state : {"text":"","value":1}
             */
            private boolean is_receive ;

            public boolean isIs_receive() {
                return is_receive;
            }

            public void setIs_receive(boolean is_receive) {
                this.is_receive = is_receive;
            }

            private int coupon_id;
            private String name;
            private ColorBean color;
            private CouponTypeBean coupon_type;
            private String reduce_price;
            private int discount;
            private String gift;
            private String min_price;
            private int expire_type;
            private int begin_day;
            private int expire_day;
            private StartTimeBean start_time;
            private EndTimeBean end_time;
            private ApplyRangeBean apply_range;
            private CenterVisibleBean center_visible;
            private int total_num;
            private int sort;
            private int wxapp_id;
            private int is_draw;
            private int percent;
            private int is_tree;
            private StateBean state;

            public int getCoupon_id() {
                return coupon_id;
            }

            public void setCoupon_id(int coupon_id) {
                this.coupon_id = coupon_id;
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

            public String getGift() {
                return gift;
            }

            public void setGift(String gift) {
                this.gift = gift;
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

            public int getBegin_day() {
                return begin_day;
            }

            public void setBegin_day(int begin_day) {
                this.begin_day = begin_day;
            }

            public int getExpire_day() {
                return expire_day;
            }

            public void setExpire_day(int expire_day) {
                this.expire_day = expire_day;
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

            public ApplyRangeBean getApply_range() {
                return apply_range;
            }

            public void setApply_range(ApplyRangeBean apply_range) {
                this.apply_range = apply_range;
            }

            public CenterVisibleBean getCenter_visible() {
                return center_visible;
            }

            public void setCenter_visible(CenterVisibleBean center_visible) {
                this.center_visible = center_visible;
            }

            public int getTotal_num() {
                return total_num;
            }

            public void setTotal_num(int total_num) {
                this.total_num = total_num;
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

            public int getIs_draw() {
                return is_draw;
            }

            public void setIs_draw(int is_draw) {
                this.is_draw = is_draw;
            }

            public int getPercent() {
                return percent;
            }

            public void setPercent(int percent) {
                this.percent = percent;
            }

            public int getIs_tree() {
                return is_tree;
            }

            public void setIs_tree(int is_tree) {
                this.is_tree = is_tree;
            }

            public StateBean getState() {
                return state;
            }

            public void setState(StateBean state) {
                this.state = state;
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
                 * text : 1970/01/01
                 * value : 0
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
                 * text : 1970/01/01
                 * value : 0
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

            public static class ApplyRangeBean {
                /**
                 * text : 指定商品
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

            public static class CenterVisibleBean {
                /**
                 * text : 显示
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

            public static class StateBean {
                /**
                 * text :
                 * value : 1
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
