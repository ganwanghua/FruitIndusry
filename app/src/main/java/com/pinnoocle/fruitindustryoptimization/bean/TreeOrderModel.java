package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class TreeOrderModel {
    /**
     * code : 1
     * msg :
     * data : {"orders":[{"order_id":767,"user_id":17139,"order_no":"TR2021031114260217139","user_tree_id":414,"tree_id":17,"type":1,"spec":1,"time":"月","pay_status":1,"price":"-1.00","number":1,"pay_price":"-12.00","pay_time":1615443962,"option":1,"team_id":0,"wxapp_id":10001,"create_time":"2021-03-11 14:26:02","end_time":1646547962,"update_time":"2021-03-11 14:26:02","back_status":0,"cancel_time":0,"land_id":5,"goods_id_arr":"12478","extra_certificate":25197,"coupon":null,"address":"北京市北京市东城区11","user_name":"11","phone":"13333333333","name":"11","has_discount":0,"transaction_id":"","referee_id":0,"wish":"11","tree_name":"测试果树","tree_pic":"http://btys.cc/uploads/202103121658178374d2348.jpg","back_days":"2","isexpire":1,"end_date":"2022-03-06 14:26:02"}]}
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
        private List<OrdersBean> orders;

        public List<OrdersBean> getOrders() {
            return orders;
        }

        public void setOrders(List<OrdersBean> orders) {
            this.orders = orders;
        }

        public static class OrdersBean {
            /**
             * order_id : 767
             * user_id : 17139
             * order_no : TR2021031114260217139
             * user_tree_id : 414
             * tree_id : 17
             * type : 1
             * spec : 1
             * time : 月
             * pay_status : 1
             * price : -1.00
             * number : 1
             * pay_price : -12.00
             * pay_time : 1615443962
             * option : 1
             * team_id : 0
             * wxapp_id : 10001
             * create_time : 2021-03-11 14:26:02
             * end_time : 1646547962
             * update_time : 2021-03-11 14:26:02
             * back_status : 0
             * cancel_time : 0
             * land_id : 5
             * goods_id_arr : 12478
             * extra_certificate : 25197
             * coupon : null
             * address : 北京市北京市东城区11
             * user_name : 11
             * phone : 13333333333
             * name : 11
             * has_discount : 0
             * transaction_id :
             * referee_id : 0
             * wish : 11
             * tree_name : 测试果树
             * tree_pic : http://btys.cc/uploads/202103121658178374d2348.jpg
             * back_days : 2
             * isexpire : 1
             * end_date : 2022-03-06 14:26:02
             */

            private int order_id;
            private int user_id;
            private String order_no;
            private int user_tree_id;
            private int tree_id;
            private int type;
            private int spec;
            private String time;
            private int pay_status;
            private String price;
            private int number;
            private String pay_price;
            private int pay_time;
            private int option;
            private int team_id;
            private int wxapp_id;
            private String create_time;
            private int end_time;
            private String update_time;
            private int back_status;
            private int cancel_time;
            private int land_id;
            private String goods_id_arr;
            private int extra_certificate;
            private Object coupon;
            private String address;
            private String user_name;
            private String phone;
            private String name;
            private int has_discount;
            private String transaction_id;
            private int referee_id;
            private String wish;
            private String tree_name;
            private String tree_pic;
            private String back_days;
            private int isexpire;
            private String end_date;

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

            public String getOrder_no() {
                return order_no;
            }

            public void setOrder_no(String order_no) {
                this.order_no = order_no;
            }

            public int getUser_tree_id() {
                return user_tree_id;
            }

            public void setUser_tree_id(int user_tree_id) {
                this.user_tree_id = user_tree_id;
            }

            public int getTree_id() {
                return tree_id;
            }

            public void setTree_id(int tree_id) {
                this.tree_id = tree_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getSpec() {
                return spec;
            }

            public void setSpec(int spec) {
                this.spec = spec;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getPay_status() {
                return pay_status;
            }

            public void setPay_status(int pay_status) {
                this.pay_status = pay_status;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getPay_price() {
                return pay_price;
            }

            public void setPay_price(String pay_price) {
                this.pay_price = pay_price;
            }

            public int getPay_time() {
                return pay_time;
            }

            public void setPay_time(int pay_time) {
                this.pay_time = pay_time;
            }

            public int getOption() {
                return option;
            }

            public void setOption(int option) {
                this.option = option;
            }

            public int getTeam_id() {
                return team_id;
            }

            public void setTeam_id(int team_id) {
                this.team_id = team_id;
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

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public int getBack_status() {
                return back_status;
            }

            public void setBack_status(int back_status) {
                this.back_status = back_status;
            }

            public int getCancel_time() {
                return cancel_time;
            }

            public void setCancel_time(int cancel_time) {
                this.cancel_time = cancel_time;
            }

            public int getLand_id() {
                return land_id;
            }

            public void setLand_id(int land_id) {
                this.land_id = land_id;
            }

            public String getGoods_id_arr() {
                return goods_id_arr;
            }

            public void setGoods_id_arr(String goods_id_arr) {
                this.goods_id_arr = goods_id_arr;
            }

            public int getExtra_certificate() {
                return extra_certificate;
            }

            public void setExtra_certificate(int extra_certificate) {
                this.extra_certificate = extra_certificate;
            }

            public Object getCoupon() {
                return coupon;
            }

            public void setCoupon(Object coupon) {
                this.coupon = coupon;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getHas_discount() {
                return has_discount;
            }

            public void setHas_discount(int has_discount) {
                this.has_discount = has_discount;
            }

            public String getTransaction_id() {
                return transaction_id;
            }

            public void setTransaction_id(String transaction_id) {
                this.transaction_id = transaction_id;
            }

            public int getReferee_id() {
                return referee_id;
            }

            public void setReferee_id(int referee_id) {
                this.referee_id = referee_id;
            }

            public String getWish() {
                return wish;
            }

            public void setWish(String wish) {
                this.wish = wish;
            }

            public String getTree_name() {
                return tree_name;
            }

            public void setTree_name(String tree_name) {
                this.tree_name = tree_name;
            }

            public String getTree_pic() {
                return tree_pic;
            }

            public void setTree_pic(String tree_pic) {
                this.tree_pic = tree_pic;
            }

            public String getBack_days() {
                return back_days;
            }

            public void setBack_days(String back_days) {
                this.back_days = back_days;
            }

            public int getIsexpire() {
                return isexpire;
            }

            public void setIsexpire(int isexpire) {
                this.isexpire = isexpire;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }
        }
    }
}
